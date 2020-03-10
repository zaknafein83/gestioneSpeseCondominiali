package it.dstech.gestione_condominio;

public class EsempioDebug {

	public static void main(String[] args) {
		Stanza stanza  =new Stanza("salotto", Esposizione.EST, 12);
		System.out.println(stanza);
		stanza.setMisura(22);
		System.out.println(stanza);
	}

}
