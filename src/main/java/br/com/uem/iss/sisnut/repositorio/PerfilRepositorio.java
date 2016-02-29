package br.com.uem.iss.sisnut.repositorio;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.uem.iss.sisnut.modelo.Perfil;



public interface PerfilRepositorio extends CrudRepository<Perfil, Integer>, JpaSpecificationExecutor<Perfil> {

}
