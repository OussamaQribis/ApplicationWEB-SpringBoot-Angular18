import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';



@NgModule({
  imports: [RouterModule.forChild([
    { path: 'affectation', loadChildren: () => import('./components/suivi-at/suivi-at.module').then(m => m.SuiviATModule) },
    { path: 'Bons', loadChildren: () => import('./components/bon-dintervention/bon-dintervention.module').then(m => m.BonDinterventionModule) }
  
  ])],


  exports: [RouterModule]
})
export class AdminRoutingModule { }
