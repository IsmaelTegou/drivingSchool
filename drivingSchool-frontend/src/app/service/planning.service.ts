import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import{Planning} from '../models/planning';

@Injectable({
  providedIn: 'root'
})
export class PlanningService {
  private readonly apiUrl = 'http://localhost:8080';
  constructor(private http: HttpClient) { }
  getAllPlannings() {
    return this.http.get(`${this.apiUrl}/findAllPlannings`);
  }

  deletePlanning(planning: any) {
    console.log(planning);
    return this.http.delete(`${this.apiUrl}/deletePlannings/${planning.id}`);
  }

  savePlanning(planning: Planning){
    console.log(planning);
    return this.http.post(`${this.apiUrl}/createPlanning`,planning);
  }
  editPlanning(planning: Planning){
    console.log(planning);
    return this.http.put(` ${this.apiUrl}/updatePlanning/${planning.id}`, planning);
  }
}

