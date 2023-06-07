import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SearchComponentComponent } from './components/search-component/search-component.component';
import { DetailsComponent } from './components/details/details.component';

const routes: Routes = [
  { path: 'test', component: SearchComponentComponent},
  { path: "details", component: DetailsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
