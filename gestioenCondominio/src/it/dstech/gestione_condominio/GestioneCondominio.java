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

				break;
			}
			case 3: {
				// conteggio spese

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
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream stream = new ObjectInputStream(in);
		Condominio condominio = (Condominio) stream.readObject();
		return condominio;
	}

	private static void salvaCondominio(Condominio condominio) throws IOException {
		File file = new File("condomionio.obj");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream out = new FileOutputStream(file);
		ObjectOutputStream stream = new ObjectOutputStream(out);
		stream.writeObject(condominio);
		stream.close();

	}

	private static void menu() {

		System.out.println("Fai la tua scelta");
		System.out.println("1. inserisci appartamento");
		System.out.println("2. inserisci camera");
		System.out.println("3. calcola");
		System.out.println("4. stampa");
		System.out.println("0. ESCI");

	}

}
