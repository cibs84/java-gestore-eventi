package org.lessons.java;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String titolo;
		String dataEvento;
		int postiTot;
		int postiPren;
		
		LocalDate adesso = LocalDate.now();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Inserisci un nuovo evento");
		System.out.println();
		Evento evento;
		
		while (true) {
			try {
				System.out.println("Titolo:");
				titolo = scan.nextLine();

				System.out.println("Data nel formato Es.03/02/2023):");
				dataEvento = scan.nextLine();

				System.out.println("Posti totali dell'evento:");
				postiTot = Integer.parseInt(scan.nextLine());

				evento = new Evento(titolo, dataEvento, postiTot);
				System.out.println(evento + "\n");
				break;
			} catch (NumberFormatException e) {
				System.out.println("Il valore inserito non è un numero! Riprovare...");
				System.out.println();
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Riprovare...");
				System.out.println();
			} 
		}
		
		while (true) {
			System.out.println("Scegli l'operazione");
			System.out.println("1-Prenota | 2-Disdici");
			try {
				int operationChoice = Integer.parseInt(scan.nextLine());
				if (operationChoice >= 1 && operationChoice <= 3) {
					switch (operationChoice) {
					//Prenota
					case 1:
						System.out.println("Quanti posti vuoi prenotare?");
						evento.prenota(Integer.parseInt(scan.nextLine()));
						break;
					//Disdici
					case 2:
						System.out.println("Quanti posti vuoi disdire?");
						evento.disdici(Integer.parseInt(scan.nextLine()));
						break;

					default:
						break;
					}
				} else {
					System.out.println("Il valore inserito non è valido! Riprovare...");
					System.out.println();
				}
			} catch (NumberFormatException e) {
				System.out.println("Il valore inserito non è un numero! Riprovare...");
				System.out.println();
			} catch (PostiDaDisException e) {
				System.out.println(e.getMessage());
				System.out.println();
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Riprovare...");
				System.out.println();
			} 
			System.out.println("Posti prenotati: " + evento.getPostiPren());
			System.out.println("Posti disponibili: " + evento.getPostiDisp());
			System.out.println();
		}
	}

}