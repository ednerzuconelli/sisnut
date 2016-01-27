package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Paciente;



public class PacienteBean implements Serializable {
	
	private String nome,dataNascimento,rua,numero,complemento,bairro,uf,cidade,rua2,numero2,complemento2,bairro2,uf2,cidade2,tel,telcom,telcel,email,email2;
	
	
	
	
	final static Logger logger = LoggerFactory.getLogger(PacienteBean.class);

  
	public PacienteBean(Event success) {
		// TODO Auto-generated constructor stub
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getRua2() {
		return rua2;
	}


	public void setRua2(String rua2) {
		this.rua2 = rua2;
	}


	public String getNumero2() {
		return numero2;
	}


	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}


	public String getComplemento2() {
		return complemento2;
	}


	public void setComplemento2(String complemento2) {
		this.complemento2 = complemento2;
	}


	public String getBairro2() {
		return bairro2;
	}


	public void setBairro2(String bairro2) {
		this.bairro2 = bairro2;
	}


	public String getUf2() {
		return uf2;
	}


	public void setUf2(String uf2) {
		this.uf2 = uf2;
	}


	public String getCidade2() {
		return cidade2;
	}


	public void setCidade2(String cidade2) {
		this.cidade2 = cidade2;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getTelcom() {
		return telcom;
	}


	public void setTelcom(String telcom) {
		this.telcom = telcom;
	}


	public String getTelcel() {
		return telcel;
	}


	public void setTelcel(String telcel) {
		this.telcel = telcel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	
	

	
	
	
	
}
