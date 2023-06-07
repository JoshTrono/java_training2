import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { DashboardComponentComponent } from './components/dashboard-component/dashboard-component.component';
import { CardComponentComponent } from './components/card-component/card-component.component';
import { ListComponentComponent } from './components/list-component/list-component.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponentComponent,
    CardComponentComponent,
    ListComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
