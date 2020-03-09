package it.dstech.gestione_condominio;

import java.io.Serializable;

public class Stanza implements Serializable {

	@Override
	public String toString() {
		return "Stanza [nome=" + nome + ", esposizione=" + esposizione + ", misura=" + misura + "]";
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((esposizione == null) ? 0 : esposizione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Stanza other = (Stanza) obj;
		if (esposizione != other.esposizione)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	

}
