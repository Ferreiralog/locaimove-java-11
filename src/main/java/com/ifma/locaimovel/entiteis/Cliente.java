package com.ifma.locaimovel.entiteis;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_nome;
	private String nome;
	private String cpf;
	private String data_nascimento;

	public Cliente() {

	}

	public Cliente(Integer id_nome, String nome, String cpf, String data_nascimento) {
		super();
		this.id_nome = id_nome;
		this.nome = nome;
		this.cpf = cpf;
		this.data_nascimento = data_nascimento;
	}

	public Integer getId_nome() {
		return id_nome;
	}

	public void setId_nome(Integer id_nome) {
		this.id_nome = id_nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_nome == null) ? 0 : id_nome.hashCode());
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
		Cliente other = (Cliente) obj;
		if (id_nome == null) {
			if (other.id_nome != null)
				return false;
		} else if (!id_nome.equals(other.id_nome))
			return false;
		return true;
	}

}