import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Phone } from 'src/app/models/phone';

@Component({
  selector: 'app-input-component',
  templateUrl: './input-component.component.html',
  styleUrls: ['./input-component.component.css']
})
export class InputComponentComponent {

  @Input() phone!: Phone;

  @Output() onValueChange: EventEmitter<string> = new EventEmitter<string>();


}
