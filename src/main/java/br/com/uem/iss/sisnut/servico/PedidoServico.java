package br.com.uem.iss.sisnut.servico;

import java.util.List;

import br.com.uem.iss.sisnut.modelo.Pedido;

public interface PedidoServico {

	public void save(Pedido pedido);
	
	public List<Pedido> findAll();
	
}
