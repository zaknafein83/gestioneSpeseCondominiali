package it.dstech.gestione_condominio;

public enum Esposizione {

	NORD("NORD"), SUD("SUD"), EST("EST"), OVEST("OVEST");

	private String value;

	Esposizione(String value) {
		this.value = value;
	}
}
