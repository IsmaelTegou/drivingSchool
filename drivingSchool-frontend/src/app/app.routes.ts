import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component'; // ← importer le composant
import { HomeComponent } from './pages/home/home.component';
import { FooterComponent } from './pages/footer/footer.component';
import { SignInComponent } from './pages/sign-in/sign-in.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { ProfileComponent } from './pages/profile/profile.component';
import { PaymentComponent } from './pages/payment/payment.component';
import { InstructorComponent } from './pages/instructor/instructor.component';
import { AsideComponent } from './pages/aside/aside.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { CandidatComponent } from './pages/candidat/candidat.component';
import {CourseComponent} from './pages/course/course.component';
import {PlanningComponent} from './pages/planning/planning.component';
import {NewCandidateComponent} from './pages/new-candidate/new-candidate.component';


export const routes: Routes = [
    { path: 'login', component: LoginComponent },
    //{ path: 'home', component: HomeComponent },
    { path: 'footer', component: FooterComponent },
    { path: 'sign-in', component: SignInComponent },
    { path: 'sign-up', component: SignUpComponent },
    { path: 'profile', component: ProfileComponent },
    { path: 'payments', component: PaymentComponent },
    { path: 'instructors', component: InstructorComponent },
    { path: 'candidats', component: CandidatComponent },
    { path: 'aside', component: AsideComponent },
    { path: 'dashboard', component: DashboardComponent },
    { path: 'courses', component: CourseComponent },
    { path: 'plannings', component: PlanningComponent },
    { path: 'new-candidate', component: NewCandidateComponent },
    { path: '', redirectTo: 'login', pathMatch: 'full' }// redirection vers login au démarrage
  ];


