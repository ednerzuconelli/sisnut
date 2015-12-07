package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.CategoriaProduto;
import br.com.uem.iss.sisnut.servico.CategoriaProdutoServico;


public class CategoriaProdutoBean implements Serializable {

	final static Logger logger = LoggerFactory.getLogger(CategoriaProdutoBean.class);
	
	private CategoriaProduto categoriaproduto = null;
	
	public CategoriaProdutoBean(){
		
	}
	
	public CategoriaProdutoBean(CategoriaProduto categoriaproduto, Event event){
		this.categoriaproduto = categoriaproduto;
	}

	public CategoriaProduto getCategoriaproduto() {
		return categoriaproduto;
	}

	public void setCategoriaproduto(CategoriaProduto categoriaproduto) {
		this.categoriaproduto = categoriaproduto;
	}

	
	
}
