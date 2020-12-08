package com.ifma.locaimovel.entiteis;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Instant data_inicio;
	private Instant data_fim;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Locacao() {

	}

	public Locacao(Integer id, Instant data_inicio, Instant data_fim, Cliente cliente) {
		super();
		this.id = id;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Instant data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Instant getData_fim() {
		return data_fim;
	}

	public void setData_fim(Instant data_fim) {
		this.data_fim = data_fim;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Locacao other = (Locacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}