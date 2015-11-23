package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.TipoRefeicao;
import br.com.uem.iss.sisnut.servico.TipoRefeicaoServico;

public class TipoRefeicaoBean implements Serializable {

	final static Logger logger = LoggerFactory.getLogger(TipoRefeicaoBean.class);
	
	private TipoRefeicao tiporefeicao = null;
	
	@Autowired
	private TipoRefeicaoServico tiporefeicaoservico;
	
	public TipoRefeicaoBean(){
	}
	
	public TipoRefeicaoBean(TipoRefeicao tiporefeicao, Event event){
		this.tiporefeicao = tiporefeicao;
	}

	public TipoRefeicao getTiporefeicao() {
		return tiporefeicao;
	}

	public void setTiporefeicao(TipoRefeicao tiporefeicao) {
		this.tiporefeicao = tiporefeicao;
	}
	
	
	
}
