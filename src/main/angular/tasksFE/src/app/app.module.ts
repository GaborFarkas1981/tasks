import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {TableModule} from "primeng/table";
import {ListboxModule} from "primeng/listbox";
import {FormsModule} from "@angular/forms";
import {TasksService} from "./shared/service/tasks.service";
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    TableModule,
    ListboxModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [TasksService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
