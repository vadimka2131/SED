import {Component, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {LogInUser, User} from "../../../../models/account/user.model";
import {MessageService} from "primeng/components/common/messageservice";
import {AuthenticationService} from "../../../../services/authService";
import {NgForm} from "@angular/forms";
import {Globals} from "../../../../globals";
/*import {HeaderComponent} from "../../../header/header";*/

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
               private globals: Globals,
               /**private headerComponent: HeaderComponent*/) {
      this.user = new LogInUser();
      this.auth_user = new User();
      this.tryed = false;
   }

   public LogIn(form: NgForm) {
      console.log(form);
      console.log("this.globals.role", this.globals.role);
      if (form.invalid) {
         form.submitted;
         return;
      }
      this.authenticationService.login(this.user).subscribe(
          res => {
             if (res.token) {
                this.authenticationService.setToken(res.token);
                this.authenticationService.handleAuth();
                this.authenticationService.getRole().subscribe(
                    result => {
                       console.log("login");
                       this.globals.role = result;
                       // this.headerComponent.setUser(this.user.username);
                    }
                );
             }
          },
          err => {
             console.log(err);
             if (err.status === 401) {
                this.error = "Не верный логин пароль.";
             }
          }
      );
   }
}
