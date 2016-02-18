package br.com.uem.iss.sisnut.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.spi.TimeZoneNameProvider;

import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;

import org.joda.time.DateTime;
import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.webflow.action.EventFactorySupport;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Email;
import br.com.uem.iss.sisnut.modelo.Endereco;
import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.modelo.Telefone;
import br.com.uem.iss.sisnut.modelo.TipoEmail;
import br.com.uem.iss.sisnut.modelo.Usuario;
import br.com.uem.iss.sisnut.servico.EmailServico;
import br.com.uem.iss.sisnut.servico.PacienteServico;
import br.com.uem.iss.sisnut.view.PacienteBean;
import br.com.uem.iss.sisnut.view.ProdutoBean;
import br.com.uem.iss.sisnut.view.UsuarioBean;


@Component("pacienteControle")
public class PacienteControle {

	private Paciente pacienteSelecionado;
	
	@Autowired
	private PacienteServico pacienteServico;
	
	@Autowired 
	private EmailServico emailServico;
	
	public PacienteBean newPacienteBean(){
		return new PacienteBean(new EventFactorySupport().success(this));
	}
	
	 public String onFlowProcess(FlowEvent event) {
	     
	            return "confirm";
	     
	    }
	
	
	public List<Paciente> findAllativo(){
		return pacienteServico.findAllativo();
	}
	
	public PacienteBean editPaciente(){
		
		PacienteBean pacienteBean = new PacienteBean(new EventFactorySupport().success(this));
		pacienteBean.setPaciente(pacienteSelecionado);
		pacienteBean.setNome(pacienteSelecionado.getNome());
		pacienteBean.setDataNascimento(pacienteSelecionado.getDataNascimento().toString());
		pacienteBean.setBairro(pacienteSelecionado.getEndereco().get(0).getBairro());
		pacienteBean.setBairro2(pacienteSelecionado.getEndereco().get(1).getBairro());
		//pacienteBean.setCidade(pacienteSelecionado.getEndereco().get(0).getCidade().getCidade());
		//pacienteBean.setCidade2(pacienteSelecionado.getEndereco().get(1).getCidade().getCidade());
		pacienteBean.setComplemento(pacienteSelecionado.getEndereco().get(0).getComplemento());
		pacienteBean.setComplemento2(pacienteSelecionado.getEndereco().get(1).getComplemento());
		pacienteBean.setEmail(pacienteSelecionado.getEmail().get(0).getEmail());
		pacienteBean.setEmail2(pacienteSelecionado.getEmail().get(1).getEmail());
		
		pacienteBean.setNumero(pacienteSelecionado.getEndereco().get(0).getNumero());
		pacienteBean.setNumero2(pacienteSelecionado.getEndereco().get(1).getNumero());
		pacienteBean.setRua(pacienteSelecionado.getEndereco().get(0).getRua());
		pacienteBean.setRua2(pacienteSelecionado.getEndereco().get(1).getRua());
		pacienteBean.setTel(pacienteSelecionado.getTelefone().get(0).getTelefone());
		pacienteBean.setTelcom(pacienteSelecionado.getTelefone().get(1).getTelefone());
		pacienteBean.setTelcel(pacienteSelecionado.getTelefone().get(2).getTelefone());
		//pacienteBean.setUf(pacienteSelecionado.getEndereco().get(0).getCidade().getEstado());
		//pacienteBean.setUf2(pacienteSelecionado.getEndereco().get(1).getCidade().getEstado());
	
		return pacienteBean;
	}

	public Event deletePaciente(MessageContext messageContext){
		MessageBuilder messageBuilder = null;
		try{
			Paciente paciente = pacienteSelecionado;
			paciente.setAtivo(0);
			pacienteServico.save(paciente);
		} catch (Throwable ex4){
			  messageBuilder = new MessageBuilder().error();
			  messageBuilder.code("erro.paciente.delete");
			  messageBuilder.arg(ex4);
			  messageContext.addMessage(messageBuilder.build());
			  return new EventFactorySupport().error(this);	
		}
			
		return new EventFactorySupport().success(this);
		
		
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
			
			TipoEmail tp = new TipoEmail();
			TipoEmail tp2 = new TipoEmail();
			tp.setTipo("pessoal");
			tp2.setTipo("Alternativo");
			
			email1.setEmail(pacienteBean.getEmail());
			email1.setTipoemail(tp);
			email2.setEmail(pacienteBean.getEmail2());
			email2.setTipoemail(tp2);
			email1.setPessoa(paciente);
			email2.setPessoa(paciente);
			
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
			paciente.setAtivo(1);
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

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}


	
	
}
