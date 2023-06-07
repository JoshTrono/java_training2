import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { PokemonService } from 'src/app/services/pokemon.service';

@Component({
  selector: 'app-search-component',
  templateUrl: './search-component.component.html',
  styleUrls: ['./search-component.component.css']
})
export class SearchComponentComponent {
  constructor(private router: Router, private pokemonService: PokemonService) { }
  search = {
    id: '',
  }



  onSubmitSearch(): void {
   const id = this.search.id;
   console.log(id);
   
   let observable = this.pokemonService.getPokemon(id);
    observable.subscribe((response) => {
      console.log(response);
      this.router.navigate(['/details'], { state: { pokemon: response } });
   });

  }
    

    

}
