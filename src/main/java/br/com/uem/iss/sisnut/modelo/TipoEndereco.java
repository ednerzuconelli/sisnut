package br.com.uem.iss.sisnut.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="tipoendereco" )
public class TipoEndereco implements Serializable {

	@Id
	@Column(name="tipoendereco_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull @NotEmpty
	@Column(name="tipo", nullable=false, length=128)
	private String tipo;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
