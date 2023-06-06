import { Component } from '@angular/core';
import { Phone } from 'src/app/models/phone';


@Component({
  selector: 'app-form-component',
  templateUrl: './form-component.component.html',
  styleUrls: ['./form-component.component.css']
})
export class FormComponentComponent {

  phone: Phone = new Phone('Joshua','josh.trono@gmail.com','352 123-1234');


}
