package br.com.flavio.movy.teste;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.flavio.movy.business.FilmeBusiness;
import br.com.flavio.movy.controller.FilmeController;
import br.com.flavio.movy.model.Filme;

public class FilmeControllerTest {
	
	private FilmeController controller;
	private Result result;
	private Filme filme;
	
	@Mock private FilmeBusiness filmeBusiness;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		result = new MockResult();
		controller = new FilmeController(filmeBusiness, result);
		filme = new Filme();
		filme.setId(1L);
	}
	
	
	@Test public void
	deveSerPossívelExibireUmFilme() {
		when(filmeBusiness.loadById(anyLong())).thenReturn(filme);
		
		controller.exibir(new Filme());
		
		assertNotNull(result.included().get("filme"));
	}
	
	@Test public void
	deveSerPossivelExibirUmaListaDeFilmes(){
		List<Filme> listaDeFilmes = new ArrayList<Filme>();
		when(filmeBusiness.loadAll()).thenReturn(listaDeFilmes);

		controller.listagem();
		
		assertEquals(listaDeFilmes, result.included().get("filmeList"));
	}
	
	@Test public void
	quandoTentarExibirUmFilmeQueNaoExisteDeveExbirUmaMensagemDeErro() {
		when(filmeBusiness.loadById(anyLong())).thenThrow(new FilmeInexistente());
		
		controller.exibir(filme);
		
		assertEquals("O filme selecionado não existe.", result.included().get("error"));
	}
	
	@Test public void 
	deveSerPossivelEditarUmFilme(){
		when(filmeBusiness.loadById(anyLong())).thenReturn(filme);
		
		controller.editar(filme);
		
		assertNotNull(result.included().get("filme"));
		
	}
	
	@Test public void
	ePossivelTerUmNovoFilme(){
		when(filmeBusiness.loadById(anyLong())).thenReturn(filme);
		
		controller.novo();
		
		assertNull(result.included().get("filme"));
	}
	
	@Test public void 
	deveSerPossivelSalvarumFilme(){
		
		controller.salvar(filme);
		
		assertEquals("O filme foi salvo com sucesso.", result.included().get("message"));
	}
	
	@Test public void
	deveSerPossivelRemoverUmFilme(){
		
		
		controller.remover(filme);
		
		assertEquals("O filme foi removido com sucesso.", result.included().get("message"));
	}
	
}
