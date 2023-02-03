package org.lessons.java;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Evento {
	private String titolo;
	private LocalDate data;
	private int postiTot;
	private int postiPren;
	
	public Evento(String titolo, String dataEvento, int postiTot) throws Exception {
		this.titolo = titolo;
		
		LocalDate dEv = LocalDate.parse(dataEvento, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Es. formato ""03/02/2023""
		this.validateDate(dEv, "La data inserita è passata!");
		this.data = dEv;
		
		this.validatePostiTotPren(postiTot, "Il numero di posti totali deve essere positivo!");
		this.postiTot = postiTot;
		
		this.postiPren = 0;
	}

	public void validateDate(LocalDate data, String message) throws DateException {
		LocalDate adesso = LocalDate.now();
		if (data.isBefore(adesso)) {
			throw new DateException(data, message); 
		}
	}
	
	public void validatePostiTotPren(int postiTotPren, String message) throws PostiTotPrenException {
		if (postiTotPren <= 0) {
			throw new PostiTotPrenException(postiTotPren, message); 
		}
	}
	
	public void prenota() throws PostiDispException, DateException {
		validateDate(this.data, "L'evento è gia passato!");
		if (this.postiTot < this.postiPren+1) {
			throw new PostiDispException();
		}
		this.postiPren++;
	}
	
	public void disdici() throws DateException, PostiDispException, PostiTotPrenException {
		validateDate(this.data, "L'evento è gia passato!");
		validatePostiTotPren(this.postiPren, "Non ci sono prenotazioni da disdire!");
		this.postiPren--;
	}
	
	/*
	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", data=" + data + "]";
	}
	*/

	@Override
	public String toString() {
		return "Evento [titolo=" + titolo + ", data=" + this.getDataFormat() + ", postiTot=" + postiTot + ", postiPren=" + postiPren
				+ "]";
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getData() {
		return data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public String getDataFormat() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
		return this.data.format(formatter);
	}

	public int getPostiTot() {
		return postiTot;
	}

	public int getPostiPren() {
		return postiPren;
	}
	
	/*
	 * Vanno inoltre implementati dei metodi public che svolgono le seguenti funzioni:
		1. prenota : aggiunge uno ai posti prenotati. Se l’evento è già passato o non ha posti
		disponibili deve sollevare un’eccezione.
		
		2. disdici : riduce di uno i posti prenotati. Se l’evento è già passato o non ci sono
		prenotazioni deve sollevare un’eccezione.
		
		3. l’override del metodo toString() in modo che venga restituita una stringa
		contenente: data formattata - titolo

	 */
	
}
