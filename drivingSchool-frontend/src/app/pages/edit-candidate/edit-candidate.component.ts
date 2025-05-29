import { Component } from '@angular/core';
import { CandidatService } from '../../service/candidat.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Candidate } from '../model/Candidate.model';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-candidate',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-candidate.component.html',
  styleUrl: './edit-candidate.component.css'
})
export class EditCandidateComponent {
   currentCandidate: Candidate= new Candidate();
   id:string="";
 constructor(private candidatService: CandidatService, private route: Router, private activatedRoute: ActivatedRoute){
  this.id=atob(this.activatedRoute.snapshot.params['id']);
  console.log("==");
  console.log(atob(this.activatedRoute.snapshot.params['id']));
   this.findCandidateById(this.id);
   
 }
 editCandidate(candidate: Candidate){
  console.log(candidate);
  candidate.id=this.id;
    this.candidatService.editCandidate(candidate).subscribe({
      next: data => {
        
      this.route.navigateByUrl('candidats');
      }
    });
 }
 findCandidateById(id: String){
  
    this.candidatService.findCandidateById(id).subscribe(
       (data: any)=> {
       console.log(data);
       this.currentCandidate =data;
      }
    );
 }

}
