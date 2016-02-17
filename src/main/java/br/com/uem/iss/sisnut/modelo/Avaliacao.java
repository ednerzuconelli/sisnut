package br.com.uem.iss.sisnut.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

@SuppressWarnings("serial")
@Entity
@Table(name="avaliacao" )
public class Avaliacao implements Serializable {

	@Id
	@Column(name="avaliacao_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="peso")
	private float peso;
	
	@Column(name="data_cadastro", nullable=false)
	private DateTime  dataCadatro;
	
	@Column(name="altura")
	private float altura;
	
	@Column(name="gordura")
	private float gordura;
	
	@Column(name="massaossea")
	private float massaossea;
	
	@Column(name="massavisceral")
	private float massavisceral;
	
	@Column(name="agua")
	private float agua;
	
	@Column(name="idademetabolica")
	private float idademetabolica;
	
	@Column(name="imc")
	private float imc;
	
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public float getPeso() {
		return peso;
	}


	public void setPeso(float peso) {
		this.peso = peso;
	}


	public float getAltura() {
		return altura;
	}


	public void setAltura(float altura) {
		this.altura = altura;
	}


	public float getGordura() {
		return gordura;
	}


	public void setGordura(float gordura) {
		this.gordura = gordura;
	}


	public float getMassaossea() {
		return massaossea;
	}


	public void setMassaossea(float massaossea) {
		this.massaossea = massaossea;
	}


	public float getMassavisceral() {
		return massavisceral;
	}


	public void setMassavisceral(float massavisceral) {
		this.massavisceral = massavisceral;
	}


	public float getAgua() {
		return agua;
	}


	public void setAgua(float agua) {
		this.agua = agua;
	}


	public float getIdademetabolica() {
		return idademetabolica;
	}


	public void setIdademetabolica(float idademetabolica) {
		this.idademetabolica = idademetabolica;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public DateTime getDataCadatro() {
		return dataCadatro;
	}


	public void setDataCadatro(DateTime dataCadatro) {
		this.dataCadatro = dataCadatro;
	}
	
	
	
}
