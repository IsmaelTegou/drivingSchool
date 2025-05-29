import { Component } from '@angular/core';
import {CourseService} from '../../service/course.service';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {Course} from '../model/Course.model';

@Component({
  selector: 'app-new-course',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './new-course.component.html',
  styleUrl: './new-course.component.css'
})
export class NewCourseComponent {

  constructor(private courseService: CourseService, private router: Router){}

  saveCourse(course: Course){
    console.log(course);
    course.administratorId = 1;
    course.instructorId = 1;
    course.planningId = 1;
    console.log(course);
    this.courseService.saveCourse(course).subscribe({
      next: data => {
        this.router.navigateByUrl('courses');
      }, error: error => {
        console.log(error);
      }
    });
  }
}
