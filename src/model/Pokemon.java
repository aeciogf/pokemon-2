package model;

public class Pokemon {

	private String nome;
	private double forca;
	
	public Pokemon (String n, double f){
		nome = n;
		forca = f;
	}
	
	public String getNome(){
		return nome;
	}
	
	public double getForca(){
		return forca;
	}
}
