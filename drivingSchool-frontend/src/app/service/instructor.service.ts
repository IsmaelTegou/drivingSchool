import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Instructor } from '../pages/model/Instructo.model';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {
  private readonly apiUrl = 'http://localhost:8080';
  private readonly apiUrlDistant: string = "http://192.168.111.162:8080";

  constructor(private http: HttpClient) { }

  getAllInstructors(){
    return this.http.get( `${this.apiUrl}/findAllInstructors`);
  }

  deleteInstructor(instructor: any) {
    console.log(instructor);
    return this.http.delete( `${this.apiUrl}/deleteInstructor/${instructor.id}`);
  }

  saveInstructor(instructor:Instructor){
    console.log(instructor);
    return this.http.post( `${this.apiUrl}/createInstructor`, instructor);
  }

  editInstructor(instructor: Instructor){
     console.log(instructor);
    return this.http.put( `${this.apiUrl}/updateInstructor/${instructor.id}`, instructor);
  }

  findInstructorById(id: string){
    return this.http.get( `${this.apiUrl}/findInstructorById/${id}`);
  }
}
