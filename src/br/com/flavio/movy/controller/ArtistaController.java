package br.com.flavio.movy.controller;

import java.util.Collection;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.flavio.movy.business.ArtistaBusiness;
import br.com.flavio.movy.model.Artista;

@Resource
public class ArtistaController {
	
	private final Result result;
	private final ArtistaBusiness artistaBusiness;
	
	public ArtistaController(Result result, ArtistaBusiness artistaBusiness) {
		this.result = result;
		this.artistaBusiness = artistaBusiness;
	}
	
	@Get("/artista/{artista.id}")
	public void exibir(Artista artista){
		artista = artistaBusiness.loadById(artista.getId());
		
		result.include("artista", artista);
	}
	
	@Get("/artista/{artista.id}/editar")
	public void editar(Artista artista){
		artista = artistaBusiness.loadById(artista.getId());
		
		result.include("artista", artista).forwardTo(this).novo();
	}
	
	@Get("/artista/novo")
	public void novo(){
		
	}
	
	@Get("/artista")
	public void listagem(){
		Collection<Artista> artistaList = artistaBusiness.loadAll();
		
		result.include("artistaList", artistaList);
	}
	
	@Post("/artista")
	public void salvar(Artista artista){
		artista = artistaBusiness.save(artista);
		
		result.include("message", "Artista salvo com sucesso!").redirectTo(this).exibir(artista);
	}
	
	@Delete("/artista/{artista.id}")
	public void remover(Artista artista){
		artistaBusiness.remove(artista);
		
		result.include("message", "Artista removido com sucesso!").redirectTo(this).listagem();
	}
	
}
