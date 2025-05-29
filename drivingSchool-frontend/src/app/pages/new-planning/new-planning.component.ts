import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Planning } from '../../models/planning';
import { PlanningService } from '../../service/planning.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-new-planning',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './new-planning.component.html',
  styleUrl: './new-planning.component.css'
})
export class NewPlanningComponent {

  courseNames:string[]  = [];
constructor(private planningService: PlanningService, private router: Router){
   this.courseNames = this.courseNames;
}

savePlanning(planning: Planning){
 console.log(planning);
     this.planningService.savePlanning(planning).subscribe({
       next: data => {
       this.router.navigateByUrl('plannings');
       }, error: error => {
         console.log(error);
       }
     });
}


}
