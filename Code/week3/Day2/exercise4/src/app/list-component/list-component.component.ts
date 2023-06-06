import { Component } from '@angular/core';
import { Item } from '../model/item';

@Component({
  selector: 'app-list-component',
  templateUrl: './list-component.component.html',
  styleUrls: ['./list-component.component.css']
})
export class ListComponentComponent {

  selectedItem: Item | undefined;

  items: Item[] = [
    new Item(1, 'apple'),
    new Item(2, 'banana'),
    new Item(3, 'orange'),
    new Item(4, 'kiwi'),
    new Item(5, 'grape'),
  ]

  sendItem(item: Item) {
    this.selectedItem = item;
  }
  

}
