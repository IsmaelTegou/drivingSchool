import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { PlanningService } from '../../service/planning.service';
import { Planning } from '../model/Planning.model';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-edit-planning',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-planning.component.html',
  styleUrl: './edit-planning.component.css'
})
export class EditPlanningComponent {
  constructor(private planningService: PlanningService, private route: Router, private activatedRoute: ActivatedRoute){}
 
  editPlanning(planning: Planning){
    
  }
}
