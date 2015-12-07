package br.com.uem.iss.sisnut.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="paciente" )
public class Paciente extends Pessoa implements Serializable {
	
}
