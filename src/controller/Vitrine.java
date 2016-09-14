package controller;

import java.util.ArrayList;
import java.util.List;

import model.Pokemon;

public class Vitrine {
	private static List<Pokemon> pokemons = new ArrayList<Pokemon>();
	
	public void addProdutos(Pokemon... pkm){
		for (Pokemon pokemon: pkm)
			pokemons.add(pokemon);
	}
	
	public List<Pokemon> getPokemons(){
		return pokemons;
	}
}