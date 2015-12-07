package br.com.uem.iss.sisnut.repositorio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.uem.iss.sisnut.modelo.Produto;
import br.com.uem.iss.sisnut.modelo.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario,Integer>, JpaSpecificationExecutor<Usuario> {

}
