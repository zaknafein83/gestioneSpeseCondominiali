package it.dstech.gestione_condominio;

import java.util.ArrayList;
import java.util.List;

public class Condominio {

	private String nome;

	private String indirizzo;

	private List<Appartamento> listaAppartamenti;

	public Condominio(String nome, String indirizzo) {
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.listaAppartamenti = new ArrayList<>();
	}

	public List<Appartamento> getListaAppartamenti() {
		return listaAppartamenti;
	}

	public void setListaAppartamenti(List<Appartamento> listaAppartamenti) {
		this.listaAppartamenti = listaAppartamenti;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public boolean aggiungiAppartamento(Appartamento appartamento) {
		if (this.listaAppartamenti.contains(appartamento)) {
			return false;
		}
		this.listaAppartamenti.add(appartamento);
		return true;
	}

	public boolean rimuoviAppartamento(Appartamento appartamento) {
		if (!this.listaAppartamenti.contains(appartamento)) {
			return false;
		}
		this.listaAppartamenti.remove(appartamento);
		return true;
	}

}
