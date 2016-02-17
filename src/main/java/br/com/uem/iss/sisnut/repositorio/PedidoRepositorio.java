package br.com.uem.iss.sisnut.repositorio;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.uem.iss.sisnut.modelo.Pedido;

public interface PedidoRepositorio extends CrudRepository<Pedido, Integer>, JpaSpecificationExecutor<Pedido> {

}
