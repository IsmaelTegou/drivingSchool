import { Component } from '@angular/core';
import {Candidate} from '../model/Candidate.model';
import {CandidatService} from '../../service/candidat.service';
import {Router} from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-new-candidate',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './new-candidate.component.html',
  styleUrl: './new-candidate.component.css'
})
export class NewCandidateComponent {
  constructor(private candidatService: CandidatService, private router: Router) {}
  saveCandidate(candidate:Candidate) {
    console.log(candidate);
    this.candidatService.saveCandidate(candidate).subscribe({
      next: data => {
      this.router.navigateByUrl('candidats');
      }, error: error => {
        console.log(error);
      }
    });
  }
}
