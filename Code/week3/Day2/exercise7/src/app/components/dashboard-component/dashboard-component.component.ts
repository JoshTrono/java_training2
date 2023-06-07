import { Component } from '@angular/core';
import { Card } from 'src/app/models/Card';

@Component({
  selector: 'app-dashboard-component',
  templateUrl: './dashboard-component.component.html',
  styleUrls: ['./dashboard-component.component.css']
})
export class DashboardComponentComponent {

  cards: Card[] = [
    new Card('Card 1', 'This is card 1'),
    new Card('Card 2', 'This is card 2'),
    new Card('Card 3', 'This is card 3'),
    new Card('Card 4', 'This is card 4'),
  ]
}
