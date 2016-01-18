package br.com.uem.iss.sisnut.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Email;
import br.com.uem.iss.sisnut.modelo.Endereco;
import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.modelo.Telefone;
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
	
	public List<Paciente> findAll(){
		return pacienteServico.findAll();
	}
	
	public Event salvePaciente(PacienteBean pacienteBean, MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			System.out.println("Salvando Paciente:1");
			Paciente paciente = pacienteBean.getPaciente();
			paciente.setAtivo(1);
			Endereco endereco = new Endereco();
			endereco.setRua(pacienteBean.getRua());
			Telefone telefone = new Telefone();
			telefone.setTelefone(pacienteBean.getTelefone());
			Email email = new Email();
			email.setEmail(pacienteBean.getEmail());
			
			paciente.setEndereco(endereco);
			paciente.setTelefone(telefone);
			paciente.setEmail(email);
			
			System.out.println("Salvando Paciente:"+ paciente.getNome());
			pacienteServico.save(paciente);
			messageBuilder = new MessageBuilder().error();
			messageBuilder.code("salve.paciente");
			messageContext.addMessage(messageBuilder.build());
			return new EventFactorySupport().success(this);
			
		}catch (Throwable ex3){
			  messageBuilder = new MessageBuilder().error();
			  messageBuilder.code("erro.paciente.salve");
			  messageBuilder.arg(ex3);
			  messageContext.addMessage(messageBuilder.build());
			  return new EventFactorySupport().error(this);	
		}
			
		
		
	}
}
