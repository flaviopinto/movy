package br.com.flavio.movy.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

@Resource
public class IndexController {
	
	@Get("/")
	public void index() {}
}
