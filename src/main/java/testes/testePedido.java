package testes;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.controle.PacienteControle;
import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.servico.PacienteServico;
import br.com.uem.iss.sisnut.view.PacienteBean;

public class testePedido {

	@Autowired
	private PacienteServico pacienteservico;
	
	@Test
	public void deveriaCriarLogQuandoInserePedido() {
		
		Event success = null;
		PacienteBean paciente = new PacienteBean(success);
		paciente.setNome("teste");
		//pacienteservico.save(paciente);
		
	}

}
