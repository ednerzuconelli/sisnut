package br.com.uem.iss.sisnut.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("serial")
@Entity
@Table(name="produto" )
public class Produto implements Serializable {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull @NotEmpty
	@Column(name="produto", nullable=false, length=128)
	private String produto;
	@Column(name="valorvenda") 
	private Double valorvenda;
	@Column(name="valorcusto")
	private Double valorcusto;
	@Column(name="estoque")
	private Double estoque;
	@Column(name="ativo")
	private Integer ativo;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="categoriaproduto_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private CategoriaProduto categoriaproduto;
	
}
