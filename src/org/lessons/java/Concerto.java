package org.lessons.java;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
	private LocalTime ora;
	private BigDecimal prezzo;
	
	public Concerto(String titolo, String dataEvento, int postiTot, BigDecimal prezzo, String ora ) throws Exception {
		super(titolo, dataEvento, postiTot);
		this.prezzo = prezzo;
		
		LocalTime tCon = LocalTime.parse(ora, DateTimeFormatter.ofPattern("HH:mm")); // Es. formato "00:35"
		this.ora = tCon;
	}

	public String getPrezzoFormat() {
		return String.format("%.2f", this.prezzo) + "€";
	}
	
	public String getDateTimeFormat() {
		return this.getDataFormat() + " " + this.ora;
	}
	
	@Override
	public String toString() {
		return this.getDateTimeFormat() + " - " + this.getTitolo() + " - " + this.getPrezzoFormat();
	}
	
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
	
}
