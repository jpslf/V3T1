package main;

import java.util.Scanner;

/**
* Actual implementation
**/
class Impl {
	Scanner in;

	Impl(String[] args) {
		in = new Scanner(System.in);
	}

	void close() {
		in.close();

		System.out.println("Kiitos ohjelman käytöstä.");
	}

	void AsetaPinkoodi() {
		System.out.println("Aseta PIN-koodi");
	}

	void LisaaTietojaKansioon() {
		System.out.println("Lisää tietoja kansioon");
	}

	void ListaaTiedotKansiosta() {
		System.out.println("Listaa tiedot kansiosta");
	}


	boolean run() {
		System.out.println("1) Aseta PIN-koodi");
		System.out.println("2) Lisää tietoja kansioon");
		System.out.println("3) Listaa tiedot kansiosta");

		System.out.println("0) Lopeta ohjelma");

		int selection = in.nextInt();

		if (selection == 0) {
			return false;

		} else if (selection == 1) {
			AsetaPinkoodi();

		} else if (selection == 2) {
			LisaaTietojaKansioon();

		} else if (selection == 3) {
			ListaaTiedotKansiosta();

		} else {
			System.out.println("Tuntematon valinta, yritä uudestaan.");
		}

		return true;
	}
}

/**
* Impl runner, do not edit.
*/
public class App {
	public static void main(String[] args) {
		Impl impl = new Impl(args);

		while (impl.run()) {}

		impl.close();
	}
}
