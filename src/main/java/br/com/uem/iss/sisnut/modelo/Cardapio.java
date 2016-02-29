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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@SuppressWarnings("serial")
@Entity
@Table(name="cardapio" )
public class Cardapio implements Serializable{
	
	@Id
	@Column(name="cardapio_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="cardapio_cod", updatable=true, insertable=true, nullable=true)
	@Cascade(CascadeType.ALL)
	private List<Refeicao> refeicao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Refeicao> getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(List<Refeicao> refeicao) {
		this.refeicao = refeicao;
	}
	
	
}
