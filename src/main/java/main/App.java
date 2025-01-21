package main;

import java.util.Scanner;
import java.util.ArrayList;


class Safe {
	private String pinCode;
	private ArrayList<String> safeFolder;

	public Safe(String pinCode_) {
		pinCode = pinCode_;
		safeFolder = new ArrayList<String>();
	}

	boolean check_pin(String pin_) {
		return pin_.equals(pinCode);
	}

	void change_pin(String new_pin) {
		pinCode = new_pin;
	}

	void add(String value) {
		safeFolder.add(value);
	}

	ArrayList<String> get(String pin) {
		if (pin.equals(pinCode)) {
			return safeFolder;
		} else {
			return null;
		}
	}
}

/**
* Actual implementation
**/
class Impl {
	Scanner in;

	Safe safe;

	Impl(String[] args) {
		in = new Scanner(System.in);
		safe = new Safe("0000");
	}

	void close() {
		in.close();

		System.out.println("Kiitos ohjelman käytöstä.");
	}

	String ask(String promt) {
		System.out.println(promt);

		return in.next().strip();
	}

	void AsetaPinkoodi() {
		safe.change_pin(ask("Anna uusi PIN-koodi:"));
	}

	void LisaaTietojaKansioon() {
		safe.add(ask("Anna kansioon lisättävä tieto:"));
	}

	void ListaaTiedotKansiosta() {
		var values = safe.get(ask("Anna PIN-koodi:"));

		if (values == null) {
			System.out.println("Väärä PIN-koodi!");
		} else {
			for (String value: values) {
				System.out.println(value);
			}
		}
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
