package br.com.flavio.movy.teste;

@SuppressWarnings("serial")
public class FilmeInexistente extends RuntimeException {
	
	public FilmeInexistente(){
		super("O filme selecionado não existe.");
	}
	
}
