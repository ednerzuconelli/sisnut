package br.com.uem.iss.sisnut.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Avaliacao;
import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.servico.AvaliacaoServico;
import br.com.uem.iss.sisnut.servico.PacienteServico;
import br.com.uem.iss.sisnut.view.AvaliacaoBean;

@Component("avaliacaoControle")
public class AvaliacaoControle {

	private int pacienteCod;
	
	@Autowired
	private PacienteServico pacienteServico;
	
	@Autowired
	private AvaliacaoServico avaliacaoServico;

	public AvaliacaoBean newAvaliacaoBean(){
		Avaliacao avaliacao = new Avaliacao();
		System.out.println("Gerando Avalia��o Bean");
		
		return new AvaliacaoBean(avaliacao, new EventFactorySupport().success(this));
	
	}
	
	public Event salveAvaliacao(AvaliacaoBean avaliacaoBean, MessageContext messageContext){
		
		Avaliacao avaliacao = avaliacaoBean.getAvaliacao();
		Paciente paciente = pacienteServico.findPacienteById(this.getPacienteCod());
		avaliacao.setPessoa(paciente);
		avaliacaoServico.save(avaliacao);
		return new EventFactorySupport().success(this);
		//WILLIANS Testar cadastro de avalia��o
	}

	public int getPacienteCod() {
		return pacienteCod;
	}

	public void setPacienteCod(int pacienteCod) {
		this.pacienteCod = pacienteCod;
	}

	

	
}
