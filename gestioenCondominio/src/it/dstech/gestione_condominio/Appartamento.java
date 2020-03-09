package it.dstech.gestione_condominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Appartamento implements Serializable{

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
		Appartamento other = (Appartamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appartamento [proprietario=" + proprietario + ", id=" + id + ", listaStanze=" + listaStanze + "]";
	}

	private String proprietario;

	private String id; // regex p\d{2}i\d{2}

	private List<Stanza> listaStanze;

	public Appartamento(String proprietario, String id) {
		this.proprietario = proprietario;
		this.id = id;
		this.listaStanze = new ArrayList<>();
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Stanza> getListaStanze() {
		return listaStanze;
	}

	public void setListaStanze(List<Stanza> listaStanze) {
		this.listaStanze = listaStanze;
	}

	public double calcolaMillesimiAppartamento() {
		double somma = 0.0;
		for (Stanza stanza : listaStanze) {
			somma += stanza.calcolaMillesimiStanza();
		}
		return somma;
	}

	public boolean aggiungiStanza(Stanza stanza) {
		if (this.getListaStanze().contains(stanza)) {
			return false;
		}
		this.listaStanze.add(stanza);
		return true;
	}

	public boolean rimuoviStanza(Stanza stanza) {
		if (!this.getListaStanze().contains(stanza)) {
			return false;
		}
		this.getListaStanze().remove(stanza);
		return true;
	}

}
