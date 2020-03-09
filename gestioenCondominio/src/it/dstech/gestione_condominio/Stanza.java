package it.dstech.gestione_condominio;

public class Stanza {

	private String nome;

	private Esposizione esposizione;

	private double misura;

	public Stanza(String nome, Esposizione esposizione, double misura) {
		super();
		this.nome = nome;
		this.esposizione = esposizione;
		this.misura = misura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Esposizione getEsposizione() {
		return esposizione;
	}

	public void setEsposizione(Esposizione esposizione) {
		this.esposizione = esposizione;
	}

	public double getMisura() {
		return misura;
	}

	public void setMisura(double misura) {
		this.misura = misura;
	}

	public double calcolaMillesimiStanza() {
		if (this.getEsposizione() == Esposizione.NORD || this.getEsposizione() == Esposizione.SUD) {
			// moltiplicata per il 5%
			return this.getMisura() * 1.05;
		}
		if (this.getEsposizione() == Esposizione.OVEST) {
			return this.getMisura() * .95;
		}
		return this.getMisura() * 1.1;
	}

}
