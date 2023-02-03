package org.lessons.java;

import java.util.List;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Random rand = new Random();
		
		ProgrammaEventi programmaEventi = new ProgrammaEventi("Programma Eventi Ex Dogana");
		int numeroEventi = 20;
		Evento[] arrEventi = new Evento[numeroEventi]; 
		for (int i = 0; i < 13; i++) {
			try {
				arrEventi[i] = new Evento("Evento_" + i, "10/03/" + rand.nextInt(2024, 2100), rand.nextInt(100, 1000));
				programmaEventi.aggiungiEvento(arrEventi[i]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int i = 0; i < 7; i++) {
			try {
				arrEventi[i] = new Evento("Evento_" + i, "10/03/2099", rand.nextInt(100, 1000));
				programmaEventi.aggiungiEvento(arrEventi[i]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Tot. Eventi in Programma: " + programmaEventi.getTotaleEventi());
		System.out.println(programmaEventi.toStringProgrammaEventi_02() + "\n");
		System.out.println(programmaEventi.toStringProgrammaEventi());
		System.out.println("Eventi nel 10/03/2099");
		List<Evento> listaDatata = programmaEventi.getListaEventiPerData("10/03/2099");
		
		for (Evento evento : listaDatata) {
			System.out.println(evento.getDataFormat() + " - " + evento.getTitolo());
		}
		
 		programmaEventi.svuotaListaEventi();
 		System.out.println("Tot. Eventi in Programma: " + programmaEventi.getTotaleEventi());
	}

}
