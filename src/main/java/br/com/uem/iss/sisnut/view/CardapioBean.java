package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Cardapio;

public class CardapioBean implements Serializable {

	private Cardapio cardapio=null;
	
	public CardapioBean(Cardapio cardapio,Event event) {
		this.cardapio = cardapio;
		
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}
	
	
}
