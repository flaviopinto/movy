package br.com.flavio.movy.business;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.flavio.movy.model.Filme;
import br.com.flavio.movy.teste.FilmeInexistente;

@Component
public class FilmeBusiness {
	
	private EntityManager manager;
	
	public FilmeBusiness(EntityManager manager) {
		this.manager = manager;
	}
	
	public Filme save(Filme filme){
		return manager.merge(filme);
	}
	
	public Filme loadById(long id) throws FilmeInexistente{
		Filme filme = manager.find(Filme.class, id);
		if(filme == null){
			throw new FilmeInexistente();
		}
		return filme;
	}
	
	public void remove(Filme filme){
		manager.remove(manager.getReference(Filme.class, filme.getId()));
	}
	
	public Collection<Filme> loadAll(){
		Query query = manager.createQuery("from Filme");
		return query.getResultList();
	}
	
}
