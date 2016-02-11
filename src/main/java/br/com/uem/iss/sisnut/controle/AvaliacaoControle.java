package br.com.uem.iss.sisnut.controle;

import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Avaliacao;
import br.com.uem.iss.sisnut.view.AvaliacaoBean;

@Component("avaliacaoControle")
public class AvaliacaoControle {

	private int pacienteCod;

	public AvaliacaoBean newAvaliacaoBean(){
		Avaliacao avaliacao = new Avaliacao();
		
		return new AvaliacaoBean(avaliacao, new EventFactorySupport().success(this));
	
	
	}
	
	public Event salveAvaliacao(AvaliacaoBean avaliacaoBean, MessageContext messageContext){
		return null;
		//WILLIANS implementar salvar o cadastro;
	}

	public int getPacienteCod() {
		return pacienteCod;
	}

	public void setPacienteCod(int pacienteCod) {
		this.pacienteCod = pacienteCod;
	}

	

	
}
