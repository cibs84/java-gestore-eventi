package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProgrammaEventi {
	String titolo;
	List<Evento> eventi;
	
	public ProgrammaEventi(String titolo) {
		this.titolo = titolo;
		this.eventi = new ArrayList<>();
	}
	
	public void aggiungiEvento(Evento evento) {
		this.eventi.add(evento);
	}
	
	public List<Evento> getListaEventiPerData(String data) {
		List<Evento> eventDatedList = new ArrayList<>();
		for (Evento evento : this.eventi) {
			if (evento.getData().equals(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy")))) {
				eventDatedList.add(evento);
			}
		}
		return eventDatedList;
	}
	
	public int getTotaleEventi() {
		return this.eventi.size();
	}
	
	public void svuotaListaEventi() {
		this.eventi.clear();
	}
	
	public String toStringProgrammaEventi() {
		Collections.sort(eventi);
		String programmaEventi = this.titolo + "\n";
		
		for (Evento evento : this.eventi) {
			programmaEventi += evento.getDataFormat() + " - " + evento.getTitolo() + "\n";
		}
		return programmaEventi;
	}
	public String toStringProgrammaEventi_02() {
		//Collections.sort(eventi);
		String programmaEventi = this.titolo + "\n";
		
		for (Evento evento : this.eventi) {
			programmaEventi += evento.getDataFormat() + " - " + evento.getTitolo() + "\n";
		}
		return programmaEventi;
	}
}
