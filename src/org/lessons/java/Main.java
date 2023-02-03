package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String titolo;
		String dataEvento;
		int postiTot;
		int postiPren;
		boolean inputOk = true;
		
		LocalDate adesso = LocalDate.now();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Inserisci un nuovo evento");
		System.out.println();
		Evento evento = null;
		Concerto concerto = null;
		boolean isConcert = false;
		
		while (true) {
			try {
				System.out.println("L'evento che vuoi inserire è un concerto?");
				System.out.println("1-SI | 2-NO");
				int eventChoice = Integer.parseInt(scan.nextLine());
				if (eventChoice < 1 || eventChoice > 2) {
					System.out.println("Il valore inserito non è valido! Riprovare...");
					System.out.println();
					break;
				}
				
				System.out.println("Titolo:");
				titolo = scan.nextLine();

				System.out.println("Data nel formato Es.03/02/2023:");
				dataEvento = scan.nextLine();

				System.out.println("Posti totali dell'evento:");
				postiTot = Integer.parseInt(scan.nextLine());

				if (eventChoice == 2) { // Inserisce Evento
					evento = new Evento(titolo, dataEvento, postiTot);
					System.out.println(evento + "\n");
				} else if (eventChoice == 1) { // Inserisce Concerto
					isConcert = true;
					
					System.out.println("Prezzo:");
					BigDecimal prezzo = new BigDecimal(scan.nextLine());
					
					System.out.println("Ora nel formato Es.00:35 :");
					String ora = scan.nextLine();
					
					concerto = new Concerto(titolo, dataEvento, postiTot, prezzo, ora);
				}
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
						if (isConcert) {
							concerto.prenota(Integer.parseInt(scan.nextLine()));
						} else {
							evento.prenota(Integer.parseInt(scan.nextLine()));
						}
						break;
					//Disdici
					case 2:
						System.out.println("Quanti posti vuoi disdire?");
						if (isConcert) {
							concerto.disdici(Integer.parseInt(scan.nextLine()));
						} else {
							evento.disdici(Integer.parseInt(scan.nextLine()));
						}
						break;
					}
				} else {
					System.out.println("Il valore inserito non è valido! Riprovare...");
					System.out.println();
				}
			} catch (NumberFormatException e) {
				System.out.println("Il valore inserito non è un numero! Riprovare...");
				System.out.println();
				inputOk = false;
			} catch (PostiDaDisException e) {
				System.out.println(e.getMessage());
				System.out.println();
				inputOk = false;
			} catch (Exception e) {
				System.out.println(e.getMessage() + " Riprovare...");
				System.out.println();
				inputOk = false;
			}
			
			if (isConcert && inputOk) {
				System.out.println(concerto);
				System.out.println("Posti prenotati: " + concerto.getPostiPren());
				System.out.println("Posti disponibili: " + concerto.getPostiDisp());
				System.out.println();
			} else if (inputOk) {
				System.out.println(evento);
				System.out.println("Posti prenotati: " + evento.getPostiPren());
				System.out.println("Posti disponibili: " + evento.getPostiDisp());
				System.out.println();
			}
		}
	}

}