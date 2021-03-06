package com.ifma.locaimovel.entiteis;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_contato")
public class Contato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_contato;
	private String telefone1;
	private String telefone2;
	private String email;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Contato() {

	}

	public Contato(Integer id_contato, String telefone1, String telefone2, String email, Cliente cliente) {
		super();
		this.id_contato = id_contato;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.email = email;
		this.cliente = cliente;
	}

	public Integer getId_contato() {
		return id_contato;
	}

	public void setId_contato(Integer id_contato) {
		this.id_contato = id_contato;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_contato == null) ? 0 : id_contato.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (id_contato == null) {
			if (other.id_contato != null)
				return false;
		} else if (!id_contato.equals(other.id_contato))
			return false;
		return true;
	}

}
