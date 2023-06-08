import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PokemonService {
  private apiUrl = 'https://pokeapi.co/api/v2';

  constructor(private http: HttpClient) { }

  private pokemon: any;

  

  getPokemon(nameOrId: string) {
    // return observable for getting a pokemon
    let observable = this.http.get(`${this.apiUrl}/pokemon/${nameOrId}`);
    this.pokemon = observable;
    return observable;
  }

  getPokemonDetails() {
    console.log("getPokemonDetails")
    let observable = this.pokemon;
    return observable;
  }

  getPokemonList() {
    // return observable for a list of pokemon
    // `${this.apiUrl}/pokemon?limit=100`
    let observable = this.http.get(`${this.apiUrl}/pokemon?limit=100`);
    return observable;
  }
}