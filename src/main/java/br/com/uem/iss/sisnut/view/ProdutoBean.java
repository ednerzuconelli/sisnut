package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Produto;

public class ProdutoBean implements Serializable {
	
	final static Logger logger = LoggerFactory.getLogger(ProdutoBean.class);
	
	private Produto produto = null;
	private boolean value;
	
	public ProdutoBean(){
	}
	
	public ProdutoBean(Produto produto, Event event){
		this.produto=produto;
	}
	
	public Produto getProduto(){
		return produto;
	}
	
	public void setProduto(Produto produto){
		this.produto = produto;
	}
	
	
	public void addMessage() {  
        String summary = value ? "Checked" : "Unchecked";  
  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));  
    }

}
