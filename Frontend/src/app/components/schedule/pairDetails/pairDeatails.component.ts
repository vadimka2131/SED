import {Component, EventEmitter, Input, OnChanges, OnInit, Output} from "@angular/core";
import {Pair} from "../../../models/shedule/pair";
import {Group} from "../../../models/shedule/group";
import {DictionaryService} from "../../../services/dictionary.service";
import {Discipline} from "../../../models/shedule/discipline";
import {Professor} from "../../../models/account/professor";
import {AccountService} from "../../../services/accountService";
import {Room} from "../../../models/shedule/room.model";
import {ScheduleService} from "../../../services/schedule.service";
import {isUndefined} from "util";
import {StatusType} from "../../../models/statusType.model";
import {NotificationService} from "../../../services/notification.service";
import {WeekType} from "../../../models/shedule/weekType.enum";
import {PairType} from "../../../models/shedule/pairType";
import {PageResult} from "../../../models/admin/PageResult.model.list";
import {User} from "../../../models/account/user.model";

@Component({
    selector: 'pair-details',
    templateUrl: './pairDeatails.component.html',
    styleUrls: ["./pairDeatails.component.css"]
})

export class PairDetailsComponent implements OnInit, OnChanges {
    @Input() editablePair: Pair;
    @Input() pointX: number;
    @Input() pointY: number;
    @Input() editable: boolean = false;
    @Output() close = new EventEmitter<any>();
    @Output() updatePairs = new EventEmitter<any>();

    public pair: Pair = new Pair();

    public findGroups: Array<Group> = new Array<Group>();
    public findDisciplines: Array<Discipline> = new Array<Discipline>();
    public findProfessors: Array<Professor> = new Array<Professor>();
    public findRooms: Array<Room> = new Array<Room>();
    public findPairTypes: Array<PairType> = new Array<PairType>();
    public showDeleteDialog: boolean = false;
    public WeekTypes = WeekType;

    constructor(private dictionaryService: DictionaryService,
                private accountService: AccountService,
                private notification: NotificationService,
                private ScheduleService: ScheduleService,
    ) { }

    ngOnInit() {
        this.GetPairTypes();
    }

    ngOnChanges() {
        if (!isUndefined(this.editablePair)) this.pair = JSON.parse(JSON.stringify(this.editablePair));
        else this.pair = null;
    }

    getStyle() {
        let style;
        if (this.pointX && this.pointY) {
            style = {
                "position": 'absolute',
                "left": (this.pointX + 10) + 'px',
                "top": this.pointY + 'px'
            };
            return style;
        } else {
            style = {};
            return style;
        }
    }

    AllUpdatePairs() {
        this.checkOnEmpty();
        this.ScheduleService.Save(this.pair).subscribe(
            result => {
                if (result.status === StatusType.OK.toString()) {
                    this.updatePairs.emit();
                    this.closeDetails();
                }
                this.notification.FromStatus(result);
            }
        );
    }

    deletePair() {
        this.ScheduleService.Delete(this.pair.id).subscribe(
            result => {
                if (result.status === StatusType.OK.toString()) {
                    this.updatePairs.emit();
                    this.closeDetails();
                }
                this.notification.FromStatus(result);
            }
        );
    }

    public closeDetails() {
        this.close.emit();
    }

    public GetPairTypes() {
        this.dictionaryService.GetPairTypes()
            .subscribe((res: PageResult) => {
                this.findPairTypes = res.content;
            });
    }

    public selectGroup(group: Group) {
        this.pair.lesson.group = group;
    }
    public selectDiscipline(discipline: Discipline) {
        this.pair.lesson.discipline = discipline;
    }
    public selectProfessor(professor: Professor) {
        this.pair.lesson.professor = professor;
    }
    public selectRoom(room: Room) {
        this.pair.room = room;
    }
    public selectWeekType(week: string) {
        if (this.editablePair.id !== 0 && this.editablePair.weektype !==  week) {
            if (this.editablePair.weektype === WeekType.Все.toString()
            || week === WeekType.Все.toString()) {
                this.pair.id = this.editablePair.id;
            } else {
                this.pair.id = this.editablePair.id;
            }
        }
        if (this.editablePair.id !== 0 && this.editablePair.weektype ===  week) {
            this.pair.id = this.editablePair.id;
        }
        this.pair.weektype = week;
    }
    selectPairType(pairType: PairType) {
        this.pair.pairType = pairType;
    }

    public checkOnEmpty() {
        if (isUndefined(this.pair) || this.pair == null) {
            this.pair = new Pair();
        }
        if (this.pair.lesson.discipline == null) {
            this.pair.lesson.discipline = new Discipline();
        }
        if (this.pair.lesson.professor == null) {
            this.pair.lesson.professor = new Professor();
        }
        if (this.pair.lesson.professor.user == null) {
            this.pair.lesson.professor.user = new User();
        }
        if (this.pair.room == null) {
            this.pair.room = new Room();
        }
        if (this.pair.lesson.group == null) {
            this.pair.lesson.group = new Group();
        }
        if (this.pair.pairType == null || this.pair.pairType.type === "") {
            if (this.findPairTypes)
                this.pair.pairType = this.findPairTypes[0];
            else
                this.pair.pairType = new PairType();
        }
    }

    public searchGroups(event: any) {
        let filter = {
            globalFilter: event.query.substring(0, 60)
        }
        let temp: Array<Group> = new Array();
        this.dictionaryService.GetGroups(filter).subscribe(
            result => {
                temp = result.content;
                if (temp.length > 0)
                    this.findGroups = temp;
                else
                    this.findGroups = [];
            }, error => console.error(error)
        );
    }
    public searchDisciplines(event: any) {
        let filter = {
            globalFilter: event.query.substring(0, 60)
        }
        let temp: Array<Discipline> = new Array();
        this.dictionaryService.GetDisciplines(filter).subscribe(
            result => {
                temp = result.content;
                if (temp.length > 0)
                    this.findDisciplines = temp;
                else
                    this.findDisciplines = [];
            }, error => console.error(error)
        );
    }
    /*public searchPairTypes(event: any) {
        let filter = {
            globalFilter: event.query.substring(0, 60)
        }
        let temp: Array<PairType> = new Array();
        this.dictionaryService.GetPairTypes(filter).subscribe(
            result => {
                temp = result.content;
                console.log("temp", temp);
                if (temp.length > 0)
                    this.findPairTypes = temp;
                else
                    this.findPairTypes = [];
            }, error => console.error(error)
        );
    }*/

    public searchProfessors(event: any) {
        let filter = {
            globalFilter: event.query.substring(0, 60)
        };
        let temp: Array<Professor> = new Array();
        this.dictionaryService.GetProfessors(filter).subscribe(
            result => {
                temp = result.content;
                if (temp.length > 0) {
                    this.findProfessors = temp;
                }
                else
                    this.findProfessors = [];
            }, error => console.error(error)
        );
    }
    public searchRooms(event: any) {
        let filter = {
            globalFilter: event.query.substring(0, 60)
        };
        let temp: Array<Room> = new Array();
        this.dictionaryService.GetRooms(filter).subscribe(
            result => {
                temp = result.content;
                if (temp.length > 0)
                    this.findRooms = temp;
                else
                    this.findRooms = [];
            }, error => console.error(error)
        );
    }

}