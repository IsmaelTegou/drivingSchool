import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import {BarDeNavigationComponent } from'./pages/bar-de-navigation/bar-de-navigation.component';
import { FooterComponent } from './pages/footer/footer.component';
import { SignInComponent } from './pages/sign-in/sign-in.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { PaymentComponent } from "./pages/payment/payment.component";
import { InstructorComponent } from './pages/instructor/instructor.component';
import { AsideComponent } from "./pages/aside/aside.component";
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { CandidatComponent } from './pages/candidat/candidat.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, BarDeNavigationComponent, FooterComponent,SignInComponent, SignUpComponent,
     ProfileComponent, PaymentComponent, InstructorComponent, AsideComponent, DashboardComponent, RouterModule, CandidatComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'tist';
  nom_parent = 'nom_parent';
}

