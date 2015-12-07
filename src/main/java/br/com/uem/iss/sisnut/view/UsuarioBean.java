package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Usuario;

public class UsuarioBean implements Serializable{
	
	private Usuario usuario = null;
	final static Logger logger = LoggerFactory.getLogger(UsuarioBean.class);
	
	
	
	public UsuarioBean(Usuario usuario, Event event){
		this.usuario = usuario;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	
}
