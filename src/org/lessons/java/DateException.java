package org.lessons.java;

import java.time.LocalDate;

public class DateException extends Exception {
	private LocalDate data;

	public DateException(LocalDate data, String message) {
		super(message);
		this.data = data;
	}
	
	public LocalDate getPageNumber() {
		return this.data;
	}
}
