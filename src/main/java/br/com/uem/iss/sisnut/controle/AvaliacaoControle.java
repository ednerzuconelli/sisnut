package br.com.uem.iss.sisnut.controle;

import java.util.List;

import org.joda.time.DateTime;
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

	private Paciente pacienteSelecionado;
	
	@Autowired
	private PacienteServico pacienteServico;
	
	@Autowired
	private AvaliacaoServico avaliacaoServico;

	public AvaliacaoBean newAvaliacaoBean(){
		Avaliacao avaliacao = new Avaliacao();
		System.out.println("Gerando Avaliação Bean");
		
		return new AvaliacaoBean(avaliacao, new EventFactorySupport().success(this));
	
	}
	

	
	public List<Avaliacao> findByPaciente(){
		List<Avaliacao> avaliacoes = avaliacaoServico.findByPaciente(pacienteSelecionado);
		return avaliacoes;
		
	}
	
	public Event salveAvaliacao(AvaliacaoBean avaliacaoBean, MessageContext messageContext){
		
		Avaliacao avaliacao = avaliacaoBean.getAvaliacao();
		Paciente paciente = pacienteServico.findPacienteById(pacienteSelecionado.getCod());
		DateTime data = new DateTime(System.currentTimeMillis());
		
		avaliacao.setDataCadatro(data);
		avaliacao.setPessoa(paciente);
		avaliacaoServico.save(avaliacao);
		return new EventFactorySupport().success(this);
		
	}

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}



	

	
}
