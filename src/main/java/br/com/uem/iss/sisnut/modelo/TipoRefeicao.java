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
@Table(name="tiporefeicao" )
public class TipoRefeicao implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull @NotEmpty
	@Column(name="tiporefeicao", nullable=false, length=128)
	private String tipoRefeicao;
	
	@Column(name="ativo")
	private Integer ativo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoRefeicao() {
		return tipoRefeicao;
	}

	public void setTiporefeicao(String tiporefeicao) {
		this.tipoRefeicao = tiporefeicao;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
	
	
}
