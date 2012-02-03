package br.com.flavio.movy.business;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.flavio.movy.model.Artista;

@Component
public class ArtistaBusiness {
	
	private EntityManager manager;
	
	public ArtistaBusiness(EntityManager manager) {
		this.manager = manager;
	}
	
	public Artista save(Artista artista){
		return manager.merge(artista);
	}
	
	public Artista loadById(long id){
		return manager.find(Artista.class, id);
	}
	
	public void remove(Artista artista){
		manager.remove(manager.getReference(Artista.class, artista.getId()));
	}
	
	public Collection<Artista> loadAll(){
		Query query = manager.createQuery("from Artista");
		return query.getResultList();
	}
}
