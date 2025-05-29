import {Component, OnInit} from '@angular/core';
import {InstructorService} from '../../service/instructor.service';
import { Router } from '@angular/router';
import { Instructor } from '../model/Instructo.model';

@Component({
  selector: 'app-instructor',
  standalone: true,
  imports: [],
  templateUrl: './instructor.component.html',
  styleUrl: './instructor.component.css'
})
export class InstructorComponent {

  public instructors: any;
  id: string= "";

  constructor(private instructorService: InstructorService, private router: Router){
      this.getAllInstructors();
  }

  getAllInstructors(){
    this.instructorService.getAllInstructors().subscribe({
      next: data => {
        this.instructors = data;
      }, error: error => {
        console.log(error);
      }
    });
  }
  deleteInstructor(instructor: any){
 const conf = confirm("Are you sure you want to delete this instructor?");
 if (conf) {
   this.instructorService.deleteInstructor(instructor).subscribe({
     next: data => {
       this.getAllInstructors();
     }, error: error => {
       console.log(error);
     }
   })
 }
  }
  
  addInstructor() {
    this.router.navigateByUrl('new-instructor');
  }

  editInstructor(instructor: Instructor){
     const id = '' + instructor.id
      this.router.navigateByUrl('edit-instructor/'+btoa(id));
  }

  findInstructorById(id: string){}
}
