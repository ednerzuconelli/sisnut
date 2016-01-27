package br.com.uem.iss.sisnut.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.joda.time.DateTime;
import org.primefaces.event.FlowEvent;
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
		return new PacienteBean(new EventFactorySupport().success(this));
	}
	
	 public String onFlowProcess(FlowEvent event) {
	     
	            return "confirm";
	     
	    }
	
	
	public List<Paciente> findAll(){
		return pacienteServico.findAll();
	}
	

	
 
	
	public Event salvePaciente(PacienteBean pacienteBean, MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			
			Paciente paciente = new Paciente();
			List<Endereco> endereco = new ArrayList<Endereco>();
			List<Telefone> telefone = new ArrayList<Telefone>();
			List<Email> email = new ArrayList<Email>();
			
			Endereco end1 = new Endereco();
			end1.setRua(pacienteBean.getRua());
			end1.setNumero(pacienteBean.getNumero());
			end1.setComplemento(pacienteBean.getComplemento());
			end1.setBairro(pacienteBean.getBairro());
			
			Endereco end2 = new Endereco();
			end2.setRua(pacienteBean.getRua2());
			end2.setNumero(pacienteBean.getNumero2());
			end2.setComplemento(pacienteBean.getComplemento2());
			end2.setBairro(pacienteBean.getBairro2());
			
			endereco.add(end1);
			endereco.add(end2);
			
			Telefone tel = new Telefone();
			tel.setTelefone(pacienteBean.getTel());
			
			Telefone tel2 = new Telefone();
			tel2.setTelefone(pacienteBean.getTelcom());
			
			Telefone tel3 = new Telefone();
			tel3.setTelefone(pacienteBean.getTelcel());
			
			telefone.add(tel);
			telefone.add(tel2);
			telefone.add(tel3);
			
			Email email1 = new Email();
			Email email2 = new Email();
			email1.setEmail(pacienteBean.getEmail());
			email2.setEmail(pacienteBean.getEmail2());
			
			email.add(email1);
			email.add(email2);
			
			paciente.setNome(pacienteBean.getNome());
			paciente.setDataNascimento(DateTime.parse(pacienteBean.getDataNascimento()));
			paciente.setEndereco(endereco);
			paciente.setTelefone(telefone);
			paciente.setEmail(email);
			paciente.setContato("EU");
			DateTime data = new DateTime(System.currentTimeMillis());
			
			paciente.setDataCadatro(data);
			
			pacienteServico.save(paciente);
			
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
