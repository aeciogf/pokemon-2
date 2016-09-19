package controller;

import java.util.ArrayList;
import java.util.List;

import model.Pokemon;

public class Carrinho {
	private static List<Pokemon> pokemons = new ArrayList<Pokemon>();
	
	public void addPokemon(Pokemon... pkm){
		for (Pokemon pokemon: pkm)
			pokemons.add(pokemon);
	}
	
	public List<Pokemon> getPokemons(){
		return pokemons;
	}
}
