package br.com.uem.iss.sisnut.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.uem.iss.sisnut.modelo.Paciente;
import br.com.uem.iss.sisnut.modelo.Produto;


public interface PacienteRepositorio extends CrudRepository<Paciente,Integer>, JpaSpecificationExecutor<Paciente>{


	
	@Query("select p from Paciente p where p.ativo=1")
	public List<Paciente> findAllativo();

}
