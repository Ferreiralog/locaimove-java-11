package com.ifma.locaimovel.entiteis.enums;

public enum ImovelTipo {
	
	CASA("Casa"),	
	APARTAMENTO("Apartamento"),
	SITIO("Sitio"),
	FAZENDA("Fazenda"),
	COMERCIAL("Comercial");
	private final String tipoImovel;

	private ImovelTipo(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}
	
	

}


