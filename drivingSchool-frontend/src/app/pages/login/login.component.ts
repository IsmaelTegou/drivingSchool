import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { RouterLink } from '@angular/router';

@Component({
   selector: 'app-login',
  standalone: true,
  imports: [FormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  isSubmitted: boolean = false;

  onSubmit() {
    this.isSubmitted = true;
    // Afficher les informations dans la console (ici, tu peux ajouter la logique d'authentification)
    if (this.email && this.password) {
    console.log('Email:', this.email);
    console.log('Mot de passe:', this.password);
    this.router.navigateByUrl('/home');
    // Tu peux ajouter ici la logique de vérification
    }
  }  
  constructor(private router: Router) {}
  //router = inject(Router);
  onLogin() {
      alert("Hello Jeff");
      // Logique de connexion ici (si besoin)
      this.router.navigateByUrl('/home'); // Redirige vers la page d'accueil
     // this.router.navigateByUrl('/homes').then(()=>{
       // location.reload();
     // });
    }
}
 

