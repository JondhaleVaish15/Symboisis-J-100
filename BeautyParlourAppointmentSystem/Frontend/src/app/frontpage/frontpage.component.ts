import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-frontpage',
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './frontpage.component.html',
  styleUrl: './frontpage.component.css'
})
export class FrontpageComponent {

isLoginClicked: boolean = false;
isAdmin: any;
isUser: any;
 

  showLoginOptions(): void {
    this.isLoginClicked = !this.isLoginClicked; 
  }
    

  showRegister(): void {
    console.log("Register clicked");
  }
  constructor(private router: Router) {}

  

}


