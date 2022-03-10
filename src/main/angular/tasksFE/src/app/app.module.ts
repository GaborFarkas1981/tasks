import {APP_INITIALIZER, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {TableModule} from "primeng/table";
import {ListboxModule} from "primeng/listbox";
import {FormsModule} from "@angular/forms";
import {TasksService} from "./shared/service/tasks.service";
import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import {KeycloakAngularModule, KeycloakService} from "keycloak-angular";
import {initializer} from "../utils/app-init";
import {AdminComponent} from "./admin/admin.component";
import {AccessDeniedComponent} from "./access-denied/access-denied.component";
import {ManagerComponent} from "./manager/manager.component";

@NgModule({
  declarations: [
    AppComponent,
    AccessDeniedComponent,
    ManagerComponent,
    AdminComponent,
  ],
  imports: [
    BrowserModule,
    TableModule,
    ListboxModule,
    FormsModule,
    KeycloakAngularModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [
    TasksService,
    {
      provide: APP_INITIALIZER,
      useFactory: initializer,
      deps: [KeycloakService],
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
