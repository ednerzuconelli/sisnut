package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Avaliacao;

public class AvaliacaoBean implements Serializable {

	private Avaliacao avaliacao;
	
	public AvaliacaoBean(Avaliacao avaliacao, Event success) {
		// TODO Auto-generated constructor stub
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	
}
