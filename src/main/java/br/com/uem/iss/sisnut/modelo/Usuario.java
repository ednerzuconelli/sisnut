package br.com.uem.iss.sisnut.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@SuppressWarnings("serial")
@Entity
@Table(name="usuario" )
public class Usuario implements Serializable{

		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		
		@Column
		private String login;
		
		@Column
		private int senha;
		
		@Column
		private String email;
		
		@Column
		private boolean ativo;

		public int getId() {
			return id;
		}


		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public int getSenha() {
			return senha;
		}

		public void setSenha(int senha) {
			this.senha = senha;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}


		public boolean isAtivo() {
			return ativo;
		}


		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		}
		
		
		
		

		
}
