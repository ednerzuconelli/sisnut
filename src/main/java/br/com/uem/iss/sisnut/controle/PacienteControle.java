package br.com.uem.iss.sisnut.controle;

import java.util.List;

import javax.faces.event.ActionEvent;

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
import br.com.uem.iss.sisnut.view.EnderecoBean;
import br.com.uem.iss.sisnut.view.PacienteBean;
import br.com.uem.iss.sisnut.view.UsuarioBean;

@Component("pacienteControle")
public class PacienteControle {
	private List<Endereco> endereco;
	private List<Telefone> telefone;
	private List<Email> ema;
	private String rua,numero,complemento,bairro,tel,email;
	private List<String> listaEndereco;
	
	
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
	
	public void cadastrarEndereco(){
		Endereco end = new Endereco();
		end.setNumero(getNumero());
		end.setRua(getRua());
		end.setComplemento(getComplemento());
		end.setBairro(getBairro());
		endereco.add(end);
		listaEndereco.add(end.getRua()+","+end.getNumero()+" "+end.getComplemento()+" "+end.getBairro());
	}
	
	
 
	
	public Event salvePaciente(PacienteBean pacienteBean, MessageContext messageContext){
		MessageBuilder messageBuilder=null;
		try{
			
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


	public List<Email> getEma() {
		return ema;
	}


	public void setEma(List<Email> ema) {
		this.ema = ema;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public List<Telefone> getTelefone() {
		return telefone;
	}


	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}


	public List<String> getListaEndereco() {
		return listaEndereco;
	}


	public void setListaEndereco(List<String> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
	
	
}
