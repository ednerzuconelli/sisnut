package br.com.uem.iss.sisnut.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
}
