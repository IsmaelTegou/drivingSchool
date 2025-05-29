import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Instructor } from '../model/Instructo.model';
import { InstructorService } from '../../service/instructor.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-instructor',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-instructor.component.html',
  styleUrl: './edit-instructor.component.css'
})
export class EditInstructorComponent {

   currentInstructor : Instructor= new Instructor();
  id: string= "";

  constructor(private instructorService: InstructorService, private route: Router, private activatedRoute:ActivatedRoute){
    this.id=atob(this.activatedRoute.snapshot.params['id']);
    console.log(atob(this.activatedRoute.snapshot.params['id']));
    this.findInstructorById(this.id);
  }
 

editInstructor(instructor: Instructor){
 console.log(Instructor);
  instructor.id= this.id;
  this.instructorService.editInstructor(instructor).subscribe({
      next: data => {
        
      this.route.navigateByUrl('instructors');
      }
    });
}


 findInstructorById(id: string){
   this.instructorService.findInstructorById(id).subscribe(  
    (data: any)=> {
       console.log(data);
       this.currentInstructor =data;
      }
   );
 }

}
