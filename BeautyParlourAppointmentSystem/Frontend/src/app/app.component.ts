import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { AppoinmentComponent } from './appoinment/appoinment.component';
import { FrontpageComponent } from './frontpage/frontpage.component';
import { ServiceComponent } from './service/service.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule, FormsModule, ServiceComponent, AppoinmentComponent,FrontpageComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Beautyparlourappoinmentsystem';
userName: any;
}
