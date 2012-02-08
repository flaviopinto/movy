package br.com.flavio.movy.teste;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.flavio.movy.business.FilmeBusiness;
import br.com.flavio.movy.model.Filme;

public class FilmeBusinessTest {
	
	private FilmeBusiness business;
	private Filme filme;
	@Mock private EntityManager manager;
	
	@Before
	public void  setUp() {
		MockitoAnnotations.initMocks(this);
		business = new FilmeBusiness(manager);
		this.filme = new Filme();
	}
	
	@Test public void
	deveSerPossivelSalvarUmFilme(){
		when(manager.merge(filme)).thenReturn(filme);
		
		assertEquals(filme, business.save(filme));
	}
	
	@Test public void
	deveSerPossivelCarregarUmFilmePeloId(){
		when(manager.find(any(Class.class), any())).thenReturn(filme);
		
		assertEquals(filme, business.loadById(1L));
	}
	
	@Test(expected=FilmeInexistente.class) public void 
	quandoInformarUmIdInexistenteDevoReceberUmErroDeFilmeInexistente() {
		when(manager.find(any(Class.class), any())).thenReturn(null);
		
		business.loadById(50);
	}

}
