package com.ifma.locaimovel.entiteis.enums;

public enum StatusLocacao {

	OCUPADO("Ocupado"), 
	DESOCUPADO("Desocupado");

	private final String status;

	private StatusLocacao(String status) {
		this.status = status;
	}

	public String getTipo() {
		return status;
	}

}
