import { Component } from '@angular/core';
import{Planning} from '../../models/planning';
import{PlanningService} from '../../service/planning.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-planning',
  standalone: true,
  imports: [],
  templateUrl: './planning.component.html',
  styleUrl: './planning.component.css'
})
export class PlanningComponent {
  public plannings: any;
  constructor(private planningService: PlanningService, private route: Router) {
    this.getAllPlanning();
  }
  getAllPlanning(){
    this.planningService.getAllPlannings().subscribe({
      next: data => {
        this.plannings = data;
        console.log(this.plannings);
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

  addPlanning(planning: Planning){
     this.route.navigateByUrl('new-planning');
  }

  editPlanning(planning: Planning){}
}
