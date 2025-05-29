import { Component } from '@angular/core';
import { CandidatService } from '../../service/candidat.service';
import {Router} from '@angular/router';
import { Candidat } from '../../models/candidat';
import { Candidate } from '../model/Candidate.model';


@Component({
  selector: 'app-candidat',
  standalone: true,
  imports: [
  ],
  templateUrl: './candidat.component.html',
  styleUrl: './candidat.component.css'
})
export class CandidatComponent {
  public candidats: any;
 constructor(private candidatService: CandidatService, private router: Router) {
  this.getAllCandidat();
}

 // getAllCandidat(){
 //  this.candidatService.getAllCandidats().subscribe((data:any)=>{
 //  console.log(data);
 //  this.candidats=data;
 //  },error=>{
 //    console.log(error)
 //  });
 //
 // }

  getAllCandidat() {
   this.candidatService.getAllCandidats().subscribe({
     next: data => {
       this.candidats = data;
     }, error: error => {
       console.log(error);
     }
   });
  }

  deleteCandidate(candidat: any) {
  const conf =confirm('Are you sure you want to delete this candidat?');
  if (conf) {
    this.candidatService.deleteCandidate(candidat).subscribe({
      next: data => {
        this.getAllCandidat();
      }, error: error => {
        console.log(error);
      }
    })
  }
  }

  addCandidate() {
    this.router.navigateByUrl('new-candidate');
  }

  editCandidate(candidate: Candidate){
       const id = '' + candidate.id
      this.router.navigateByUrl('edit-candidate/'+btoa(id));
          
  }
}