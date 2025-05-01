import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-bar-de-navigation',
  standalone: true,
  imports: [],
  templateUrl: './bar-de-navigation.component.html',
  styleUrl: './bar-de-navigation.component.css'
})
export class BarDeNavigationComponent {
  @Input() nom = "toto";
}
