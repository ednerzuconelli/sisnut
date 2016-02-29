package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Pedido;
import br.com.uem.iss.sisnut.servico.PedidoServico;

public class PedidoBean implements Serializable {

	final static Logger logger = LoggerFactory.getLogger(PedidoBean.class);
	
	private Pedido pedido= null;
	
	@Autowired
	private PedidoServico pedidoservico;
	
	public PedidoBean() {
		
	}
	
	public PedidoBean(Pedido pedido, Event event){
		this.pedido = pedido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setPedidoservico(PedidoServico pedidoservico) {
		this.pedidoservico = pedidoservico;
	}

		
	  

}
