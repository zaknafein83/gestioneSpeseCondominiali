package it.dstech.gestione_condominio;

import java.util.ArrayList;
import java.util.List;

public class Appartamento {
	
	private String proprietario;
	
	private String id; // regex p\d{2}i\d{2}
	
	private List<Stanza> listaStanze;

	public Appartamento (String proprietario, String id) {
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
	
}
