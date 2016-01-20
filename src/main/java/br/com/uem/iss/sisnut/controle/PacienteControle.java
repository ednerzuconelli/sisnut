package br.com.uem.iss.sisnut.controle;

import java.util.List;

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
	private List<Endereco> endereco;
	private String rua,numero,complemento,bairro;
	
	
	@Autowired
	private PacienteServico pacienteServico;
	
	public PacienteBean newPacienteBean(){
		Paciente paciente = new Paciente();
		return new PacienteBean(paciente, new EventFactorySupport().success(this));
	}
	

	public List<Paciente> findAll(){
		return pacienteServico.findAll();
	}
	
	 public String onFlowProcess(FlowEvent event) {
	       
	            return event.getNewStep();
	        
	  }
	
	public Event salvePaciente(PacienteBean pacienteBean, MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			System.out.println("Salvando Paciente:1");
			Paciente paciente = pacienteBean.getPaciente();
			paciente.setAtivo(1);
			
			
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


	public List<Endereco> getEndereco() {
		return endereco;
	}


	public void setEndereco(List<Endereco> endereco) {
		this.endereco = endereco;
	}


	public String getRua() {
		return rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
}
