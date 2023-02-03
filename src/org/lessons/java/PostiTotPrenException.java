package org.lessons.java;

public class PostiTotPrenException extends Exception {
	private int postiTot;

	public PostiTotPrenException(int postiTot, String message) {
		super(message);
		this.postiTot = postiTot;
	}

	public int getPostiTot() {
		return postiTot;
	}
	
}
