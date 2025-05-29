import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { InstructorService } from '../../service/instructor.service';
import { FormsModule } from '@angular/forms';
import { Instructor } from '../model/Instructo.model';
@Component({
  selector: 'app-new-instructor',
  standalone: true,
  imports: [ FormsModule],
  templateUrl: './new-instructor.component.html',
  styleUrl: './new-instructor.component.css'
  
})
export class NewInstructorComponent {
  constructor(private instructorService: InstructorService, private router: Router) {}
   saveInstructor(instructor:Instructor) {
     console.log(instructor);
     this.instructorService.saveInstructor(instructor).subscribe({
       next: data => {
       this.router.navigateByUrl('instructor');
       }, error: error => {
         console.log(error);
       }
     });
   }
}
