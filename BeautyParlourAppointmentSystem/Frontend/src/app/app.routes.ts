
import { NgModule } from '@angular/core';

import {  RouterModule, Routes } from '@angular/router';
import { AppoinmentComponent } from './appoinment/appoinment.component';
import { FrontpageComponent } from './frontpage/frontpage.component';
import { ServiceComponent } from './service/service.component';

export const routes: Routes = [
    {path :'',component:FrontpageComponent},
    { path: 'service',component:ServiceComponent },  
    { path: 'appointment', component: AppoinmentComponent },  
  
];
@NgModule({
    imports: [RouterModule.forRoot(routes)],  
    exports: [RouterModule] 
  })
  export class AppRoutingModule {}