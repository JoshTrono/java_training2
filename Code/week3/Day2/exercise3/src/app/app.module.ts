import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListComponentComponent } from './list-component/list-component.component';
import { ItemComponentComponent } from './item-component/item-component.component';

@NgModule({
  declarations: [
    AppComponent,
    ListComponentComponent,
    ItemComponentComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
