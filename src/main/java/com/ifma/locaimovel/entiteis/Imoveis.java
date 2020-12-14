package com.ifma.locaimovel.entiteis;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ifma.locaimovel.entiteis.enums.ImovelTipo;

@Entity
@Table(name = "tb_imovel")
public class Imoveis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_imovel;
	private double metragem;
	private Integer dormitorio;
	private Integer banheiro;
	private Integer vag_garagem;
	private double valor_sugerido;
	@Enumerated(EnumType.STRING)
	private ImovelTipo tipoImovel;

	@OneToOne(mappedBy = "imovel", cascade = CascadeType.ALL)
	private Endereco endereco;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "locacao_id")
	private Locacao locacao;

	public Imoveis() {

	}

	public Imoveis(Integer id_imovel, double metragem, Integer dormitorio, Integer banheiro, Integer vag_garagem,
			double valor_sugerido, ImovelTipo tipoImovel, Locacao locacao) {
		super();
		this.id_imovel = id_imovel;
		this.metragem = metragem;
		this.dormitorio = dormitorio;
		this.banheiro = banheiro;
		this.vag_garagem = vag_garagem;
		this.valor_sugerido = valor_sugerido;
		this.tipoImovel = tipoImovel;
		this.locacao = locacao;
	}

	public Integer getId_imovel() {
		return id_imovel;
	}

	public void setId_imovel(Integer id_imovel) {
		this.id_imovel = id_imovel;
	}

	public double getMetragem() {
		return metragem;
	}

	public void setMetragem(double metragem) {
		this.metragem = metragem;
	}

	public Integer getDormitorio() {
		return dormitorio;
	}

	public void setDormitorio(Integer dormitorio) {
		this.dormitorio = dormitorio;
	}

	public Integer getBanheiro() {
		return banheiro;
	}

	public void setBanheiro(Integer banheiro) {
		this.banheiro = banheiro;
	}

	public Integer getVag_garagem() {
		return vag_garagem;
	}

	public void setVag_garagem(Integer vag_garagem) {
		this.vag_garagem = vag_garagem;
	}

	public double getValor_sugerido() {
		return valor_sugerido;
	}

	public void setValor_sugerido(double valor_sugerido) {
		this.valor_sugerido = valor_sugerido;
	}

	public ImovelTipo getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(ImovelTipo tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_imovel == null) ? 0 : id_imovel.hashCode());
		return result;
	}

	public Locacao getLocacao() {
		return locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Imoveis other = (Imoveis) obj;
		if (id_imovel == null) {
			if (other.id_imovel != null)
				return false;
		} else if (!id_imovel.equals(other.id_imovel))
			return false;
		return true;
	}

}
