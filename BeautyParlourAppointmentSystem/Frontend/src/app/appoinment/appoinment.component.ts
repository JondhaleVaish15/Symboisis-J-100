import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AppointmentService } from '../appointment.service';


@Component({
  selector: 'app-appoinment',
  imports: [CommonModule,FormsModule],
  templateUrl: './appoinment.component.html',
  styleUrl: './appoinment.component.css'
})
export class AppoinmentComponent implements OnInit {
 clientId:number = 4;
 serviceId:number =23
 userName:string='';
  Appointmentstatus: string='pending';
  selectedService: string ='';
  selectedType: string='';
  appointmentDate: string ='';
  appointmentTime: string='';
  appointmentData: any ; 
  Haircut:string='';
  bookAppointment1:string='';
  
  services = [
    {
      name: 'Hair Service',
      types: ['Hair Cut', 'Basic Hair Styling', 'Normal Blow-Dry+Wash', 'Advance Blow-Dry Wash', 'Hair Extension', 'Ola Plex'],
    },
    {
      name: 'Makeup Package',
      types: ['Bridal Makeup', 'Pre-bridal makeup', 'Traditional Makeup', 'Airbrush Makeup', 'Party Makeup'],
    },
    {
      name: 'Facial',
      types: ['Gold Facial', 'Carbon Facial', 'Hydra Facial', 'Diamond Facial', 'Skin Brightening', 'Dermaplanning'],
    },
    {
      name: 'Nail Art',
      types: ['Basic Nail Art', 'Gel Nails', 'Acrylic Nails', '3D Nail Art'],
    },
  ];
  HairCut=[
    {
     name:'haircut',
    types: ['Bop Cut','Step Cut','Layer cut','Butterfly Cut']
    }
  ];
  router: Router | undefined; 
 
  constructor(
    private appointmentService: AppointmentService,
    private _router: Router,
    private fb: FormBuilder
  ) {}
  ngOnInit(): void {
    console.log("Service booking component initialized");
  
 
}

  SubTypes(serviceName: string): string[] {
    const service = this.services.find((s) => s.name == serviceName);
    return service ? service.types : [];
  }
  

  onSubmit() {
  
    if (!this.selectedService || !this.selectedType || !this.appointmentDate || !this.appointmentTime || !this.Appointmentstatus) {
      alert('Please fill out all fields to book your appointment.');
      return;
    }
    this.appointmentData = {
    
    client: { clientId: this.clientId },
    service: { serviceId: this.serviceId }, 
    appointmentDate: this.appointmentDate,
    appointmentTime: this.appointmentTime,
    appointmentStatus: this.Appointmentstatus
    }
 
    this.appointmentService.createAppointment(this.appointmentData).subscribe(
      (response: any) => {
        alert('Appointment successfully booked!');
      },
      (error: { status: any; }) => {
        console.error('Error booking appointment:', error); 
      } 
    );
   
  }
}




