package testes;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.uem.iss.sisnut.modelo.Pedido;
import br.com.uem.iss.sisnut.servico.PacienteServico;
import br.com.uem.iss.sisnut.servico.PedidoServico;
import br.com.uem.iss.sisnut.servico.ProdutoServico;

public class testePedido {

	@Autowired
	private PacienteServico pacienteservico;
	
	@Autowired
	private PedidoServico pedidoservico;
	
	@Autowired
	private ProdutoServico produtoservico;
	
	@Test
	public void deveriaCriarLogQuandoInserePedido() {
		
		Pedido pedido = new Pedido();
		pedido.setPaciente(pacienteservico.findPacienteById(1));
		pedido.setProduto(produtoservico.getById(1));
		pedido.setQuantidade(1.0);
		pedido.setValorUnitario(10.0);
		pedido.setEnviou(0);
		pedidoservico.save(pedido);
		
	}

}
