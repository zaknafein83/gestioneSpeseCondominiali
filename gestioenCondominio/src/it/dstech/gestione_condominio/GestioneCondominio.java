package it.dstech.gestione_condominio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestioneCondominio {

	private static final String ID_APPARTAMENTO_REGEX = "p\\d?\\di\\d?\\d";

	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		Condominio condominio = caricaCondominio();

		while (true) {
			menu();
			int scelta = scanner.nextInt();
			scanner.nextLine();

			switch (scelta) {
			case 1: {// creazione appartamento
				Appartamento app = creaAppartamento(scanner);
				condominio.aggiungiAppartamento(app);
				break;
			}
			case 2: {
				// creazione camera
				Stanza stanza = creaStanza(scanner);
				Appartamento appartamento = scegliAppartamento(scanner, condominio);
				appartamento.aggiungiStanza(stanza);
				break;
			}
			case 3: {
				// conteggio spese
				calcoloSpeseMensili(scanner, condominio);

				break;
			}
			case 4: {
				stampa(condominio);
				break;
			}
			default: {
				salvaCondominio(condominio);
				scanner.close();
				System.out.println("Ciao, alla prossima");
				System.exit(0);
				break;
			}
			}

		}

	}

	private static void calcoloSpeseMensili(Scanner scanner, Condominio condominio) {
		System.out.println("Inserisci le spese mensili");
		double speseMensili = scanner.nextDouble();
		double conteggioTotaleCondominio = condominio.calcoloMillesimiCondominio();

		// spese : dimensione = x : dimension

		for (Appartamento app : condominio.getListaAppartamenti()) {
			double speseSingoloAppartamento = (speseMensili * app.calcolaMillesimiAppartamento())
					/ conteggioTotaleCondominio;
			System.out.println("l'appartamento " + app + " deve pagare: " + speseSingoloAppartamento);
		}

		scanner.nextLine();
	}

	private static Appartamento scegliAppartamento(Scanner scanner, Condominio condominio) {
		System.out.println("Indicami a quale appartamento vuoi aggiungere la camera");
		for (Appartamento app : condominio.getListaAppartamenti()) {
			System.out.println(app);
		}
		System.out.println("Indicami l'id:");
		String idAppartamento = scanner.nextLine();
		int posizione = condominio.getListaAppartamenti().indexOf(new Appartamento("", idAppartamento));
		return condominio.getListaAppartamenti().get(posizione);
	}

	private static Stanza creaStanza(Scanner scanner) {
		System.out.println("dammi il nome della stanza");
		String nome = scanner.nextLine();
		System.out.println("Dammi l'esposizione della stanza");

		Esposizione esposizione = null;
		String enumerationLettaDaTastiera = scanner.nextLine();
		Esposizione[] values = Esposizione.values();
		for (Esposizione esp : values) {
			if (Esposizione.valueOf(enumerationLettaDaTastiera).equals(esp)) {
				esposizione = esp;
			}
		}

		System.out.println("Dammi la sua metratura");
		double misura = scanner.nextDouble();
		scanner.nextLine();

		Stanza stanza = new Stanza(nome, esposizione, misura);
		return stanza;
	}

	private static void stampa(Condominio condominio) {
		System.out.println(condominio);
	}

	private static Appartamento creaAppartamento(Scanner scanner) {
		System.out.println("Inserisci il nome del proprietario");
		String proprietario = scanner.nextLine();

		String id = idVerificato(scanner);

		return new Appartamento(proprietario, id);
	}

	private static String idVerificato(Scanner scanner) {
		System.out.println("Inserisci l'identificativo dell'appartamento");
		String id = scanner.nextLine();
		Pattern pattern = Pattern.compile(ID_APPARTAMENTO_REGEX); // p\d?\di\d?\d
		Matcher matcher = pattern.matcher(id);
		while (!matcher.matches()) {
			System.out.println("Attenzione, id non valido");
			System.out.println("Inserisci l'identificativo dell'appartamento");
			id = scanner.nextLine();
			matcher = pattern.matcher(id);
		}

		return id;
	}

	private static Condominio caricaCondominio() throws ClassNotFoundException, IOException {
		File file = new File("condomionio.obj");
		if (!file.exists()) {
			file.createNewFile();
			Condominio condominio = new Condominio("nome", "indirizzo");
			salvaCondominio(condominio);
			return condominio;
		}
		ObjectInputStream stream = new ObjectInputStream(new FileInputStream(file));
		Condominio condominio = (Condominio) stream.readObject();
		return condominio;
	}

	private static void salvaCondominio(Condominio condominio) throws IOException {
		File file = new File("condomionio.obj");
		if (!file.exists()) {
			file.createNewFile();
		}
		ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file));
		stream.writeObject(condominio);
		stream.close();

	}

	private static void menu() {
		System.out.println(new String("Fai la tua scelta"));
		System.out.println("1. inserisci appartamento");
		System.out.println("2. inserisci camera");
		System.out.println("3. calcola");
		System.out.println("4. stampa");
		System.out.println("0. ESCI");
	}

}
