package br.com.uem.iss.sisnut.view;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.execution.Event;

import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.modelo.Pedido;
import br.com.uem.iss.sisnut.modelo.Produto;

public class PedidoBean implements Serializable {

	final static Logger logger = LoggerFactory.getLogger(PedidoBean.class);
	
	private Pedido pedido= null;
	
	private Produto produto = null;
	
	private Paciente paciente = null;
	
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

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
		pedido.setProduto(produto);
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
		System.out.println("teste paciente bean "+paciente);
		pedido.setPaciente(paciente);
	}
	
	  

}
