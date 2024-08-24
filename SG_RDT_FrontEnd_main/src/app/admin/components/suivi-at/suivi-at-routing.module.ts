import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SuiviATComponent } from './suivi-at.component';
import { LoginComponent } from 'src/app/demo/components/auth/login/login.component';

const routes: Routes = [{path:'',component:SuiviATComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SuiviATRoutingModule { }
