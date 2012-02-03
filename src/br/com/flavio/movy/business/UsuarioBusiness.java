package br.com.flavio.movy.business;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.vraptor.ioc.Component;
import br.com.flavio.movy.model.Usuario;

@Component
public class UsuarioBusiness {
	
	private EntityManager manager;
	
	public UsuarioBusiness(EntityManager manager){
		this.manager = manager;
	}
	
	public Usuario save(Usuario usuario){
		return manager.merge(usuario);
	}
	
	public Usuario loadById(long id){
		return manager.find(Usuario.class, id);
	}
	
	public void remove(Usuario usuario){
		manager.remove(manager.getReference(Usuario.class, usuario.getId()));
	}
	
	public Collection<Usuario> loadAll(){
		Query query = manager.createQuery("from Usuario");
		return query.getResultList();
	}
}
