import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ServiceAppointment } from './service-appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
   apiUrl:string = 'http://localhost:8080/api';
  http:any;
  constructor(private httpClient: HttpClient) { }
  private  httpOptions={
  headers:new HttpHeaders({
    'Content-type':'application/json'
  })
  }
  getAppointments(): Observable<any> {
    return this.http.get(`${this.apiUrl}/AppointmentsRecord`);
  }
  createAppointment(appointmentData:ServiceAppointment): Observable<any> {
    console.log("Creating appointment with data:", appointmentData); 
    return this.httpClient.post(`${this.apiUrl}/CreateAppointment`, appointmentData, this.httpOptions);
  }
  
  
}
