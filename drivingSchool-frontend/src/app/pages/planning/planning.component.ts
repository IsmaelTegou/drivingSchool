import { Component } from '@angular/core';
import{Planning} from '../../models/planning';
import{PlanningService} from '../../service/planning.service';

@Component({
  selector: 'app-planning',
  standalone: true,
  imports: [],
  templateUrl: './planning.component.html',
  styleUrl: './planning.component.css'
})
export class PlanningComponent {
  public planning: any;
  constructor(private planningService: PlanningService) {
    this.getAllPlanning();
  }
  getAllPlanning(){
    this.planningService.getAllPlannings().subscribe({
      next: data => {
        this.planning = data;
      }, error: error => {
        console.log(error);
      }
    });
  }

  deletePlanning(planning: any) {
    const conf = confirm("Are you sure you want to delete this planning?");
    if (conf) {
      this.planningService.deletePlanning(planning).subscribe({
        next: data => {
          this.getAllPlanning();
        }, error: error => {
          console.log(error);
        }
      })
    }
  }
}
