package br.com.uem.iss.sisnut.modelo;

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
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name="pedido" )
public class Pedido {

	@Id
	@Column(name="pedido_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@DateTimeFormat(iso=ISO.DATE)
	@Column(name="data_pedido", nullable=false)
	private DateTime  dataPedido;
	
	@Column(name="quantidade")
	private Double quantidade;
	
	@Column(name="valor_unitario")
	private Double valorUnitario;
	
	@Column(name="enviou")
	private Integer enviou;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="produto_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Produto produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="paciente_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Paciente paciente;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fornecedor_id", updatable=true, insertable=true, nullable=true)
	@Fetch(FetchMode.SELECT)
	@Cascade(CascadeType.ALL)
	private Fornecedor fornecedor;
}
