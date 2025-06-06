import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Course} from '../pages/model/Course.model';


@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private readonly apiUrl = 'http://localhost:8080';
  private readonly apiUrlDistant: string = "http://192.168.111.162:8080";

  constructor(private http: HttpClient) { }

  getAllCourses(){
    return this.http.get( `${this.apiUrl}/findAllCourses`);
  }

  deleteCourse(course: any) {
    console.log(course);
    return this.http.delete( `${this.apiUrl}/deleteCourse/${course.id}`);
  }

  saveCourse(course: Course){
    console.log(course);
    return this.http.post( `${this.apiUrl}/createCourse`, course);
  }
}
