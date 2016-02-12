package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Avaliacao;

public class AvaliacaoBean implements Serializable {

	final static Logger logger = LoggerFactory.getLogger(AvaliacaoBean.class);
	
	private Avaliacao avaliacao = null;
	
	public AvaliacaoBean(Avaliacao avaliacao, Event event) {
		this.avaliacao = avaliacao;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	
}
