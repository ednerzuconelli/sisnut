package br.com.uem.iss.sisnut.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.servico.ProdutoServico;

public class ProdutoBean implements Serializable {
	
	final static Logger logger = LoggerFactory.getLogger(ProdutoBean.class);
	
	private Produto produto = null;
	private boolean value;
	
	private Produto selectedProduto;
	
	
	@Autowired
	private ProdutoServico produtoservico;
	
		
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

	public Produto getSelectedProduto() {
		return selectedProduto;
	}

	public void setSelectedProduto(Produto selectedProduto) {
		this.selectedProduto = selectedProduto;
	}
	
	public void setprodutoservico(ProdutoServico servico){
		this.produtoservico = servico;
	}

}
