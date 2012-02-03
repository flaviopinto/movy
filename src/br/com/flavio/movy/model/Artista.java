package br.com.flavio.movy.model;

import javax.persistence.Entity;

@Entity
public class Artista extends AbstractEntity{
	
	private String imagem;
	private String nome;
	
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
