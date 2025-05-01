import { Component } from '@angular/core';
import { CandidatService } from '../../service/candidat.service';

@Component({
  selector: 'app-candidat',
  standalone: true,
  imports: [],
  templateUrl: './candidat.component.html',
  styleUrl: './candidat.component.css'
})
export class CandidatComponent {
  public candidats: any;
 constructor(private candidatService: CandidatService){
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
}
