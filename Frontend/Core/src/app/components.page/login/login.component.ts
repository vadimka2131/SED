import {Component, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {LogInUser, User} from "../../models/account/user.model";
import {MessageService} from "primeng/components/common/messageservice";
import {AuthenticationService} from "../../services/auth.service";
import {NgForm} from "@angular/forms";
import {Globals} from "../../globals";
import {StatusType} from "../../models/statusType.model";

@Component({
   selector: 'login-page',
   templateUrl: './login.component.html',
   styleUrls: ['./login.component.css']/*,
    providers: [HeaderComponent]*/
})

export class LogInComponent {
   public user: LogInUser;
   public auth_user: User;
   public error: string;
   public tryed: boolean;

   constructor(private authenticationService: AuthenticationService,
               private router: Router,
               private messageService: MessageService,
               private globals: Globals) {
      this.user = new LogInUser();
      this.auth_user = new User();
      this.tryed = false;
   }

   public LogIn(form: NgForm) {
      if (form.invalid) {
         form.submitted;
         return;
      }
      this.authenticationService.login(this.user).subscribe(
          res => {
             if (res) {
                this.authenticationService.setToken(res.token);
                this.authenticationService.handleAuth();
                this.authenticationService.getRole().subscribe(
                    result => {
                       this.globals.role = result.data;
                    }
                );
                 this.authenticationService.getUser().subscribe(
                     res => {
                         this.globals.user = res.data;
                    }
                 );
                 this.authenticationService.getUserAccessRight().subscribe(
                     res => {
                         if (res.status === StatusType.OK.toString()) {
                             this.globals.accessRight = res.data;
                         }
                     }
                 );
             }
          },
          err => {
             if (err.status === 401) {
                this.error = "Не верный логин пароль.";
             }
          }
      );
   }
}
