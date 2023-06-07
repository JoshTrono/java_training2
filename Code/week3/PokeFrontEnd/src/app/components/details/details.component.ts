import { Component, Input } from '@angular/core';
import { ActivatedRoute, Data, Router, RoutesRecognized } from '@angular/router';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent {

  constructor(private router: Router, private pokemonService: PokemonService) { }

  pokemon: any;

  async ngOnInit(): Promise<void> {
    //this.pokemon = await this.pokemonService.getPokemonDetails();
    let observable = this.pokemonService.getPokemonDetails();
    observable.subscribe((response: any) => {
      console.log(response);
      this.pokemon = response;
    });
  }

  
  

  
}
