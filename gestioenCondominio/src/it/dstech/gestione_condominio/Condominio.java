package it.dstech.gestione_condominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Condominio implements Serializable {

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

	@Override
	public String toString() {
		return "Condominio [nome=" + nome + ", indirizzo=" + indirizzo + ", listaAppartamenti=" + listaAppartamenti
				+ "]";
	}

	public boolean rimuoviAppartamento(Appartamento appartamento) {
		if (!this.listaAppartamenti.contains(appartamento)) {
			return false;
		}
		this.listaAppartamenti.remove(appartamento);
		return true;
	}

	public double calcoloMillesimiCondominio() {
		double somma = 0.0;
		for (Appartamento appartamento : listaAppartamenti) {
			somma += appartamento.calcolaMillesimiAppartamento();
		}
		return somma;

	}
}
