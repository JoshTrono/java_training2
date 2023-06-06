import { Component, Input } from '@angular/core';
import { Item } from '../model/item';

@Component({
  selector: 'app-item-component',
  templateUrl: './item-component.component.html',
  styleUrls: ['./item-component.component.css']
})
export class ItemComponentComponent {
  @Input() selectedItem!: Item | undefined;
}
