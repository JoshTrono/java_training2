import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent {
  
  constructor(private pokemonService: PokemonService, private router: Router) { }

  pokemons: any;

  selectedPokemon: any;
  ngOnInit() {
    let observable = this.pokemonService.getPokemonList();
    observable.subscribe((response: any) => {
      this.pokemons = response.results;

      console.log(this.pokemons);
    });

    
  }
  // select pokemon directs to details page with pokemon data
  selectPokemon(selectedPokemon: any) {
    console.log("onSelect");
    this.selectedPokemon = selectedPokemon;
    console.log(this.selectedPokemon);
    const pokemonlink = this.selectedPokemon.url;
    const pokemonID = pokemonlink.split("/").filter(Boolean).pop();
    let pokemonDetail = this.pokemonService.getPokemon(pokemonID);
    pokemonDetail.subscribe((response: any) => {
      console.log(response);
      this.router.navigate(['/details'], { state: { pokemon: response } });
    });
  }
}
