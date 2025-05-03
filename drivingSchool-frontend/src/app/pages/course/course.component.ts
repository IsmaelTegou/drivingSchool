import { Component } from '@angular/core';
import {CourseService} from '../../service/course.service';

@Component({
  selector: 'app-course',
  standalone: true,
  imports: [],
  templateUrl: './course.component.html',
  styleUrl: './course.component.css'
})
export class CourseComponent {

  courses: any;

  constructor(private courseService: CourseService) {
    this.getAllCourses();
  }

  getAllCourses(): void {
    this.courseService.getAllCourses().subscribe({
      next: data => {
        this.courses = data;
      }, error: err => {
        console.log(err);
      }
    })
  }

  deleteCourse(course: any) {
    const conf = confirm("Are you sure you want to delete this course?");
    if (conf) {
      this.courseService.deleteCourse(course).subscribe({
        next: data => {
          this.getAllCourses();
        }, error: error => {
          console.log(error);
        }
      })
    }
  }
}
