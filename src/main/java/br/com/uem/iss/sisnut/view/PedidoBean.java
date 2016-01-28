package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Pedido;

public class PedidoBean implements Serializable {

	final static Logger logger = LoggerFactory.getLogger(PedidoBean.class);
	
	private Pedido pedido= null;
	
	public PedidoBean() {
		// TODO Auto-generated constructor stub
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
	
	  

}
