package br.com.uem.iss.sisnut.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@SuppressWarnings("serial")
@Entity
@Table(name="email" )
@SequenceGenerator(name="email_id_email_seq", sequenceName="email_id_email_seq", allocationSize=1)
public class Email implements Serializable {

	@Id
	@Column(name="email_id")
	@GeneratedValue(generator="email_id_email_seq", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name="email", nullable=false, length=128)
	private String email;
	

	
	@JoinColumn(name="tipoemail_id", updatable=true, insertable=true, nullable=true)
	@Cascade(CascadeType.ALL)
	private TipoEmail tipoemail;
	
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoEmail getTipoemail() {
		return tipoemail;
	}

	public void setTipoemail(TipoEmail tipoemail) {
		this.tipoemail = tipoemail;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	
	
}
