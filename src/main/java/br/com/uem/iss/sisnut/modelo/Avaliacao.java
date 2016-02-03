package br.com.uem.iss.sisnut.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="avaliacao" )
public class Avaliacao {

	@Id
	@Column(name="avaliacao_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="peso")
	private float peso;
	
	@Column(name="altura")
	private float altura;
	
	@Column(name="gordura")
	private float gordura;
	
	@Column(name="massaossea")
	private float massaossea;
	
	@Column(name="massaviceral")
	private float massaviceral;
	
	@Column(name="agua")
	private float agua;
	
	@Column(name="idademetabolica")
	private float idademetabolica;
	
	
	@Column(name="id_pessoa")
	private Pessoa pessoa;
}
