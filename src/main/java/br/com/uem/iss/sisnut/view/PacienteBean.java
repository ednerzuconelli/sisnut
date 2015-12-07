package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Paciente;



public class PacienteBean implements Serializable {
	
	private Paciente paciente = null;
	final static Logger logger = LoggerFactory.getLogger(PacienteBean.class);
	
	
	public PacienteBean(Paciente paciente, Event success) {
		this.paciente = paciente;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	
	
}
