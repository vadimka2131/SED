import { Injectable } from "@angular/core";
import { HttpErrorResponse } from "@angular/common/http";
import 'rxjs/add/operator/catch';

@Injectable()
export class UtilsService {


    constructor(
    ) {
    }

    private name1 = ["Август", "Авдей", "Аверкий", "Аверьян", "Авксентий", "Автоном", "Агап", "Агафон", "Аггей", "Адам", "Адриан", "Азарий", "Александр", "Алексей", "Амвросий", "Амос", "Ананий", "Анатолий", "Андрей", "Андриан", "Андрон", "Андроник", "Аникей", "Аникита", "Анисим", "Антип", "Аполлинарий", "Аполлон", "Арефий", "Аристарх", "Аркадий", "Арсений", "Артем", "Артемий", "Архип", "Аскольд", "Афанасий", "Афиноген", "Бажен", "Богдан", "Болеслав", "Борис", "Борислав", "Боян", "Бронислав", "Вадим", "Валентин", "Валерий", "Валерьян", "Варфоломей", "Василий", "Вацлав", "Венедикт", "Вениамин", "Викентий", "Виктор", "Викторин", "Виссарион", "Виталий", "Владимир", "Владислав", "Влас", "Всеволод", "Вячеслав", "Гавриил", "Гаврила", "Галактион", "Гедеон", "Геннадий", "Георгий", "Герасим", "Герман", "Глеб", "Гордей", "Григорий", "Гурий", "Давид", "Давыд", "Даниил", "Данила", "Дементий", "Демид", "Демьян", "Денис", "Дмитрий", "Дорофей", "Евгений", "Евграф", "Евдоким", "Евлампий", "Евсей", "Евстафий", "Евстигней", "Егор", "Елизар", "Елисей", "Емельян", "Епифан", "Еремей", "Ермил", "Ермолай", "Ерофей", "Ефим", "Ефрем", "Захар", "Зиновий", "Зосима", "Иван", "Игнатий", "Игорь", "Измаил", "Изот", "Изяслав", "Илларион", "Илья", "Иннокентий", "Иосиф", "Ипат", "Ипатий", "Ипполит", "Ираклий", "Исай", "Исидор", "Казимир", "Каллистрат", "Капитон", "Карл", "Карп", "Касьян", "Ким", "Кир", "Кирилл", "Клавдий", "Клементий", "Клим", "Климент", "Кондрат", "Кондратий", "Константин", "Корней", "Корнил", "Корнилий", "Кузьма", "Лавр", "Лаврентий", "Ладислав", "Лазарь", "Лев", "Леон", "Леонид", "Леонтий", "Лонгин", "Лука", "Лукьян", "Лучезар", "Любомир", "Макар", "Максим", "Максимильян", "Мариан", "Марк", "Мартын", "Матвей", "Мефодий", "Мечислав", "Милан", "Милен", "Мина", "Мир", "Мирон", "Мирослав", "Митрофан", "Михаил", "Михей", "Модест", "Моисей", "Мокий", "Мстислав", "Назар", "Натан", "Наум", "Нестор", "Никандр", "Никанор", "Никита", "Никифор", "Никодим", "Николай", "Никон", "Нифонт", "Олег", "Олимпий", "Онисим", "Онуфрий", "Орест", "Осип", "Остап", "Павел", "Панкрат", "Пантелеймон", "Парамон", "Парфем", "Пахом", "Петр", "Пимен", "Платон", "Поликарп", "Порфирий", "Потап", "Прокл", "Прохор", "Радим", "Ратибор", "Ратмир", "Родион", "Роман", "Ростислав", "Рубен", "Руслан", "Рюрик", "Савва", "Савватий", "Савелий", "Самсон", "Самуил", "Светозар", "Святослав", "Севастьян", "Селиван", "Семен", "Серафим", "Сергей", "Сидор", "Сила", "Сильвестр", "Симон", "Сократ", "Соломон", "Софрон", "Спартак", "Спиридон", "Станимир", "Станислав", "Степан", "Стоян", "Тарас", "Твердислав", "Творимир", "Терентий", "Тимофей", "Тимур", "Тит", "Тихон", "Трифон", "Трофим", "Ульян", "Устин", "Фаддей", "Федор", "Федосий", "Федот", "Феликс", "Феоктист", "Феофан", "Ферапонт", "Филарет", "Филимон", "Филипп", "Флорентин", "Фока", "Фома", "Фортунат", "Фотий", "Фрол", "Харитон", "Харлампий", "Христофор", "Чеслав", "Эдуард", "Эмиль", "Эммануил", "Эраст", "Эрнест", "Эрнст", "Юлиан", "Юлий", "Юрий", "Яков", "Якуб", "Ян", "Януарий", "Ярослав"];
    private name2 = ["Смирнов", "Иванов", "Кузнецов", "Соколов", "Попов", "Лебедев", "Козлов", "Новиков", "Морозов", "Петров", "Волков", "Соловьёв", "Васильев", "Зайцев", "Павлов", "Семёнов", "Голубев", "Виноградов", "Богданов", "Воробьёв", "Фёдоров", "Михайлов", "Беляев", "Тарасов", "Белов", "Комаров", "Орлов", "Киселёв", "Макаров", "Андреев", "Ковалёв", "Ильин", "Гусев", "Титов", "Кузьмин", "Кудрявцев", "Баранов", "Куликов", "Алексеев", "Степанов", "Яковлев", "Сорокин", "Сергеев", "Романов", "Захаров", "Борисов", "Королёв", "Герасимов", "Пономарёв", "Григорьев", "Лазарев", "Медведев", "Ершов", "Никитин", "Соболев", "Рябов", "Поляков", "Цветков", "Данилов", "Жуков", "Фролов", "Журавлёв", "Николаев", "Крылов", "Максимов", "Сидоров", "Осипов", "Белоусов", "Федотов", "Дорофеев", "Егоров", "Матвеев", "Бобров", "Дмитриев", "Калинин", "Анисимов", "Петухов", "Антонов", "Тимофеев", "Никифоров", "Веселов", "Филиппов", "Марков", "Большаков", "Суханов", "Миронов", "Ширяев", "Александров", "Коновалов", "Шестаков", "Казаков", "Ефимов", "Денисов", "Громов", "Фомин", "Давыдов", "Мельников", "Щербаков", "Блинов", "Колесников", "Карпов", "Афанасьев", "Власов", "Маслов", "Исаков", "Тихонов", "Аксёнов", "Гаврилов", "Родионов", "Котов", "Горбунов", "Кудряшов", "Быков", "Зуев", "Третьяков", "Савельев", "Панов", "Рыбаков", "Суворов", "Абрамов", "Воронов", "Мухин", "Архипов", "Трофимов", "Мартынов", "Емельянов", "Горшков", "Чернов", "Овчинников", "Селезнёв", "Панфилов", "Копылов", "Михеев", "Галкин", "Назаров", "Лобанов", "Лукин", "Беляков", "Потапов", "Некрасов", "Хохлов", "Жданов", "Наумов", "Шилов", "Воронцов", "Ермаков", "Дроздов", "Игнатьев", "Савин", "Логинов", "Сафонов", "Капустин", "Кириллов", "Моисеев", "Елисеев", "Кошелев", "Костин", "Горбачёв", "Орехов", "Ефремов", "Исаев", "Евдокимов", "Калашников", "Кабанов", "Носков", "Юдин", "Кулагин", "Лапин", "Прохоров", "Нестеров", "Харитонов", "Агафонов", "Муравьёв", "Ларионов", "Федосеев", "Зимин", "Пахомов", "Шубин", "Игнатов", "Филатов", "Крюков", "Рогов", "Кулаков", "Терентьев", "Молчанов", "Владимиров", "Артемьев", "Гурьев", "Зиновьев", "Гришин", "Кононов", "Дементьев", "Ситников", "Симонов", "Мишин", "Фадеев", "Комиссаров", "Мамонтов", "Носов", "Гуляев", "Шаров", "Устинов", "Вишняков", "Евсеев", "Лаврентьев", "Брагин", "Константинов", "Корнилов", "Авдеев", "Зыков", "Бирюков", "Шарапов", "Никонов", "Щукин", "Дьячков", "Одинцов", "Сазонов", "Якушев", "Красильников", "Гордеев", "Самойлов", "Князев", "Беспалов", "Уваров", "Шашков", "Бобылёв", "Доронин", "Белозёров", "Рожков", "Самсонов", "Мясников", "Лихачёв", "Буров", "Сысоев", "Фомичёв", "Русаков", "Стрелков", "Гущин", "Тетерин", "Колобов", "Субботин", "Фокин", "Блохин", "Селиверстов", "Пестов", "Кондратьев", "Силин", "Меркушев", "Лыткин", "Туров"];
    private name3 = ["Zaepnebav", "Saavvom", "Liechokas", "Vavapdahi", "Muak", "Netanufsa", "Kalevnurs", "Saabam", "Paantangy", "Shaamapep", "Tearel", "Pakenebet", "Noaser", "Kekaknana", "Keunlesok", "Leeldasha", "Loessham", "Zhekakmus", "sertificate", "Gaakschot", "Vyul", "Moegibzya", "Palatalak", "Necesavzh", "Nalalalna", "Lonubnos", "Liesasev", "Seve", "Latenar", "Kaipsat", "Mocadlovn", "Ries", "Kyaeralso", "Toaksach", "Devyukmus", "Bash", "Zoep", "Zera", "Nipihshel", "Baevvak", "Mokalut", "Keetsakva", "Selazhsan", "Schamabun", "Telesolip", "Geamzol", "Neotketsi", "Sase", "Laka", "Pikovinka", "Zhayulkop", "Pusalebav", "Vielbar", "Sovevyrme", "Dyuefnal", "Noapaglus", "Raiz", "Malaslach", "sertificate", "Pibantazh", "Naaldimno", "Viatih", "Tuke", "Daasnub", "Moovrevri", "Naka", "Maoszhama", "Naezan", "Daanbabaz", "Kaky", "Lyuavav", "Pausanikv", "Saet", "Pameklap", "Nasheshna", "Rekebov", "Riyugelli", "Leerkefba", "Basagsaps", "Sezasnash", "Pepemsesn", "Tuamkakma", "Sobumavre", "Nyogrevev", "Cyua", "Leromich", "Taesenel", "Sala", "Meessaska", "Kaashap", "Keaneshva", "Bele", "Voyukirip", "sertificate", "Razantas", "Paka", "Butushaf", "Zhapaniln", "Sile", "Kaahvesch", "sertificate", "Tisaschfu", "Saalsoh", "Zamalmabe", "Pepalbam", "Savobem", "Paekpyubt", "Koopkim", "Kealkan", "Gazhabers", "Live", "Vyfafzhek", "Byuacas", "Lamevan", "Meko", "Sezhascha", "Maovekkak", "Nose", "Bomyalveb", "Nadasvav", "Pilanem", "Lovobkane", "Noly", "Naal", "Bevannana", "Halazhpab", "Kaalmonno", "Layulscho", "Zagopuzhe", "Pamadsame", "Tyulettes", "Kolo", "Sonarmakaza", "sertificate", "Veakmin", "Nakosazvekl", "Luannas", "Kaashan", "Seeshoslokn", "Vesenvalkov", "Laisikachal", "Lyuamzugano", "Paschezikal", "Disapazhas", "Saponadaked", "Zhoa", "Scha", "Hesappibazh", "Siyutkansap", "Lyusasolsos", "Geam", "Buukkapages", "Siakbimlal", "Ganehnamziv", "Veokyuzlana", "Vaezvovtavr", "Zyuyundom", "Taalbas", "Lyaakalshav", "Zaaman", "Zhor", "Sakakavazhv", "Chaasditnak", "Deveshuh", "Layurannel"];

    getFIO(): string {
        let name = this.capFirst(this.name1[this.getRandomInt(0, this.name1.length + 1)]) + ' ' + this.capFirst(this.name2[this.getRandomInt(0, this.name2.length + 1)]);
        return name;
    }

    getNickname(): string {
        let name = this.capFirst(this.name3[this.getRandomInt(0, this.name3.length + 1)]);
        return name;
    }

    generatePassword(len) {
        let ints = [0,1,2,3,4,5,6,7,8,9];
        let chars = ['a','b','c','d','e','f','g','h','j','k','l','m','n','o','p','r','s','t','u','v','w','x','y','z'];
        let out = '';
        for (let i = 0; i < len; i++) {
            let ch = Math.random();
            if (ch < 0.5) {
                let ch2 = Math.ceil( Math.random() * ints.length - 1)
                out += ints[ch2];
            } else {
                let ch2 = Math.ceil( Math.random() * chars.length - 1);
                out += chars[ch2];
            }
        }
        return out;
    }

    private capFirst(str) {
        return str.charAt(0).toUpperCase() + str.slice(1);
    }
    private getRandomInt(min, max) {
        return Math.floor(Math.random() * (max - min)) + min;
    }
}