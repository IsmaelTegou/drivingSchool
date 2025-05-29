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
import {NewCourseComponent} from './pages/new-course/new-course.component';
import {NewPaymentComponent} from './pages/new-payment/new-payment.component';
import { NewInstructorComponent } from './pages/new-instructor/new-instructor.component';
import { EditCandidateComponent } from './pages/edit-candidate/edit-candidate.component';
import { EditInstructorComponent } from './pages/edit-instructor/edit-instructor.component';
import { NewPlanningComponent } from './pages/new-planning/new-planning.component';
import { EditPlanningComponent } from './pages/edit-planning/edit-planning.component';


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
    { path: 'new-course', component: NewCourseComponent},
    { path: 'new-payment', component: NewPaymentComponent },
     { path: 'new-planning', component: NewPlanningComponent },
    { path: 'new-instructor', component: NewInstructorComponent},
    { path: 'edit-candidate/:id', component: EditCandidateComponent},
    { path: 'edit-instructor/:id', component: EditInstructorComponent},
     { path: 'edit-planning/:id', component: EditPlanningComponent},
    { path: '', redirectTo: 'login', pathMatch: 'full' }// redirection vers login au démarrage
  ];


