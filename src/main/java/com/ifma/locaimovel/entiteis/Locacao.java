package com.ifma.locaimovel.entiteis;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ifma.locaimovel.entiteis.enums.StatusLocacao;

@Entity
@Table(name = "tb_locacao")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data_inicio;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd 'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data_fim;
	
	@Enumerated(EnumType.STRING)
	private StatusLocacao status;

	@ManyToOne
	@JoinColumn(name = "cliente")
	private Cliente cliente;

	@Column(columnDefinition = "text")
	private String observacoes;
	
	@JsonIgnore
	@OneToMany(mappedBy = "locacao")
	private Set<Imoveis> imoveis = new HashSet<>();

	public Locacao() {

	}

	public Locacao(Integer id, Instant data_inicio, Instant data_fim, StatusLocacao status, Cliente cliente, String observacoes) {
		super();
		this.id = id;
		this.data_inicio = data_inicio;
		this.data_fim = data_fim;
		this.status = status;
		this.cliente = cliente;
		this.observacoes = observacoes;
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

	public StatusLocacao getStatus() {
		return status;
	}

	public void setStatus(StatusLocacao status) {
		this.status = status;

	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public Set<Imoveis> getImoveis() {
		return imoveis;
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
