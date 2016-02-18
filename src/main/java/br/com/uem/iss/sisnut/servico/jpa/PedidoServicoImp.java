package br.com.uem.iss.sisnut.servico.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.uem.iss.sisnut.modelo.Pedido;
import br.com.uem.iss.sisnut.repositorio.PedidoRepositorio;
import br.com.uem.iss.sisnut.servico.PedidoServico;

@Service("pedidoServico")
@Repository
@Transactional
public class PedidoServicoImp implements PedidoServico {

	@Autowired
	private PedidoRepositorio pedidorepositorio;
	
	@Transactional
	@Override
	public void save(Pedido pedido) {
		pedidorepositorio.save(pedido);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Pedido> findAll() {
		return (List<Pedido>) pedidorepositorio.findAll();
	}

}
