package br.com.flavio.movy.controller;

import java.util.Collection;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.flavio.movy.business.FilmeBusiness;
import br.com.flavio.movy.model.Filme;

@Resource
public class FilmeController {

	/**
	 * br.com.caelum.vraptor.Result
	 * forward - encaminha e não muda URL.
	 * redirect - encaminha e muda URL.
	 * of - encaminha, mas, não executa o método.
	 * include - inclui objetos ou tipos primitivos no request.
	 */
	private final Result result;
	private final FilmeBusiness filmeBusiness;
	
	public FilmeController(FilmeBusiness filmeBusiness, Result result) {
		this.filmeBusiness = filmeBusiness;
		this.result = result;
	}
	
	@Get("/filme/{filme.id}")
	public void exibir(Filme filme){
		try {
			filme = filmeBusiness.loadById(filme.getId());
			result.include("filme", filme);
		} catch (Exception e) {
			result.include("error", e.getMessage());
		}
	}
	
	@Get("/filme/{filme.id}/editar")
	public void editar(Filme filme) {
	  filme = filmeBusiness.loadById(filme.getId());

	  result.include("filme", filme).forwardTo(this).novo();
	}
	
	@Get("/filme/novo")
	public void novo() {
		return;
	}
	
	@Get("/filme")
	public void listagem(){
		Collection<Filme> filmeList = filmeBusiness.loadAll();
		
		result.include("filmeList", filmeList);
	}
	
	@Post("/filme")
	public void salvar(Filme filme){
		filme = filmeBusiness.save(filme);
		
		result.include("message", "O filme foi salvo com sucesso.");
		result.redirectTo(this).exibir(filme);
	}

	@Delete("/filme/{filme.id}")
	public void remover(Filme filme){
		filmeBusiness.remove(filme);
		
		result.include("message", "O filme foi removido com sucesso.")
			  .redirectTo(this).listagem();
	}
	
}
