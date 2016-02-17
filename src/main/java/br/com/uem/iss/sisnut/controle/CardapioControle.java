package br.com.uem.iss.sisnut.controle;

import org.springframework.stereotype.Component;

import br.com.uem.iss.sisnut.modelo.Paciente;

@Component("cardapioControle")
public class CardapioControle {
	//WILLIANS implementar Controle
	
	private Paciente pacienteSelecionado;

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}
}
