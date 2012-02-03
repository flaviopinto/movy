package br.com.flavio.movy.controller;

import java.util.Collection;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.flavio.movy.business.UsuarioBusiness;
import br.com.flavio.movy.model.Usuario;

@Resource
public class UsuarioController {
	
	private final Result result;
	private final UsuarioBusiness usuarioBusiness;
	
	public UsuarioController(Result result, UsuarioBusiness usuarioBusiness) {
		this.result = result;
		this.usuarioBusiness = usuarioBusiness;
	}
	
	@Get("/usuario/{usuario.id}")
	public void exibir(Usuario usuario){
		usuario = usuarioBusiness.loadById(usuario.getId());
		
		result.include("usuario", usuario);
	}
	
	@Get("/usuario/{usuario.id}/editar")
	public void editar(Usuario usuario){
		usuario = usuarioBusiness.loadById(usuario.getId());
		
		result.include("usuario", usuario).forwardTo(this).novo();
	}
	
	@Get("/usuario/novo")
	public void novo(){
		
	}
	
	@Get("/usuario")
	public void listagem(){
		Collection<Usuario> usuarioList = usuarioBusiness.loadAll();
		
		result.include("usuarioList", usuarioList);
	}
	
	@Post("/usuario")
	public void salvar(Usuario usuario){
		usuario = usuarioBusiness.save(usuario);
		
		result.include("message", "Usuario salvo com sucesso!").redirectTo(this).exibir(usuario);
	}
	
	@Delete("/usuario/{usuario.id}")
	public void remover(Usuario usuario){
		usuarioBusiness.remove(usuario);
		
		result.include("message", "Usuario removido com sucesso!").redirectTo(this).listagem();
	}
	
	
	
	
	
	
	
	
}
