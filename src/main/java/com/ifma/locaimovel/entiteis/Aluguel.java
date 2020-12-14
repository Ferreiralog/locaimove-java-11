package com.ifma.locaimovel.entiteis;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_aluguel")
public class Aluguel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double valor_aluguel;
	private double perc_multa;
	private Instant data_vencimento;
	private Instant data_pagamento;
	@Column(columnDefinition = "text")
	private String observacao;
	@JsonIgnore
	@OneToOne
	@MapsId
	private Locacao locacao;

	public Aluguel() {

	}

	public Aluguel(Integer id, double valor_aluguel, double perc_multa, Instant data_vencimento, Instant data_pagamento,
			String observacao, Locacao locacao) {
		super();
		this.id = id;
		this.valor_aluguel = valor_aluguel;
		this.perc_multa = perc_multa;
		this.data_vencimento = data_vencimento;
		this.data_pagamento = data_pagamento;
		this.observacao = observacao;
		this.locacao = locacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor_aluguel() {
		return valor_aluguel;
	}

	public void setValor_aluguel(double valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}

	public double getPerc_multa() {
		return perc_multa;
	}

	public void setPerc_multa(double perc_multa) {
		this.perc_multa = perc_multa;
	}

	public Instant getData_vencimento() {
		return data_vencimento;
	}

	public void setData_vencimento(Instant data_vencimento) {
		this.data_vencimento = data_vencimento;
	}

	public Instant getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Instant data_pagamento) {
		this.data_pagamento = data_pagamento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
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
		Aluguel other = (Aluguel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
