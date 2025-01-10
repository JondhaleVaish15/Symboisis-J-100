import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-service',
  imports: [CommonModule,FormsModule],
  templateUrl: './service.component.html',
  styleUrl: './service.component.css'
})
export class ServiceComponent {
  constructor(private router: Router) {}

  goToAbout() {
    this.router.navigate(['/appointment']); 
  }

  
}

