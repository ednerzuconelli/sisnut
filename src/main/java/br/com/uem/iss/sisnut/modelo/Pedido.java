package br.com.uem.iss.sisnut.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Pedido implements Serializable {

	@Id
	@Column
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
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="produto_id", updatable=true, insertable=true, nullable=true)
	@Cascade(CascadeType.ALL)
	private List<Produto> produto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="paciente_id", updatable=true, insertable=true, nullable=true)
	@Cascade(CascadeType.ALL)
	private Paciente paciente;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(DateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getEnviou() {
		return enviou;
	}

	public void setEnviou(Integer enviou) {
		this.enviou = enviou;
	}

	

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", dataPedido=" + dataPedido + ", quantidade=" + quantidade + ", valorUnitario="
				+ valorUnitario + ", enviou=" + enviou + ", produto=" + produto + ", paciente=" + paciente
				+ "]";
	}
	
	
	
}
