import { Component } from '@angular/core';

@Component({
  selector: 'app-parent-component',
  templateUrl: './parent-component.component.html',
  styleUrls: ['./parent-component.component.css']
})
export class ParentComponentComponent {
  parentProp: string = 'Parent Property';
  test: string = 'test';

  receiveChildEvent($event: string) {
    this.test = $event;
    console.log($event);
  }

}
