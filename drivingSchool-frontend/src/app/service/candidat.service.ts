import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {Candidate} from '../pages/model/Candidate.model';

@Injectable({
  providedIn: 'root'
})
export class CandidatService {
  private readonly apiUrl = 'http://localhost:8080';
  private readonly apiUrlDistant: string = "http://192.168.111.162:8080";

  constructor(private http: HttpClient) { }

  getAllCandidats(){
   return this.http.get( `${this.apiUrl}/findAllCandidate`);
  }
  deleteCandidate(candidat:any){
    console.log(candidat);
    return this.http.delete( `${this.apiUrl}/deleteCandidate/${candidat.id}`);
  }
  saveCandidate(candidat:Candidate){
    console.log(candidat);
    return this.http.post( `${this.apiUrl}/createCandidate`, candidat);
  }
}
