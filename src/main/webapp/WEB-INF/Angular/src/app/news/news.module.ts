//Core (Ядро)
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
//Компоненты
import {ListNewsComponent} from "./components/list-news/list-news.component";
import {EditorComponent} from "./components/editor/editor.component";
//Роутинг
import {NewsRoutes} from "./news.routes";

//Экспорты

@NgModule({
  declarations: [
    ListNewsComponent,
    EditorComponent
  ],
  imports: [   //Сюда импорты (типа файлы, которые нужно добавить в код)
    NewsRoutes,
    CommonModule,
    FormsModule,
    HttpModule
  ],
  exports: [
    //    OrderListComponent, OrderDetailsComponent, OrderNewComponent
  ],
  providers: [] //Сюда сервисы
})
export class NewsModule { }
