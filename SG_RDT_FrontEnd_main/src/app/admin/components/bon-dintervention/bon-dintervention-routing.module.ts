import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BonDinterventionComponent } from './bon-dintervention.component';

const routes: Routes = [{path:'',component:BonDinterventionComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class BonDinterventionRoutingModule { }
