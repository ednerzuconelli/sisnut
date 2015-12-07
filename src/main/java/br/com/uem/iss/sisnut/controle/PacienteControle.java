package br.com.uem.iss.sisnut.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.modelo.Usuario;
import br.com.uem.iss.sisnut.servico.PacienteServico;
import br.com.uem.iss.sisnut.view.PacienteBean;
import br.com.uem.iss.sisnut.view.UsuarioBean;

@Component("pacienteControle")
public class PacienteControle {
	
	@Autowired
	private PacienteServico pacienteServico;
	
	public PacienteBean newPacienteBean(){
		Paciente paciente = new Paciente();
		return new PacienteBean(paciente, new EventFactorySupport().success(this));
	}
	
	public Event salvePaciente(PacienteBean pacienteBean, MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			Paciente paciente = pacienteBean.getPaciente();
			paciente.setAtivo(1);
			pacienteServico.save(paciente);
			
		}catch (Throwable ex3){
			  messageBuilder = new MessageBuilder().error();
			  messageBuilder.code("erro.produto.salve");
			  messageBuilder.arg(ex3);
			  messageContext.addMessage(messageBuilder.build());
			  return new EventFactorySupport().error(this);	
		}
			
		return new EventFactorySupport().success(this);
		
	}
}
