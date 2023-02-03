package org.lessons.java;

public class PostiDaDisException extends Exception {
	private int postiDaDisException;

	public PostiDaDisException(int postiDaDisException) {
		super("I posti da disdire erano n." + postiDaDisException + " in più rispetto a quelli prenotati.");
		System.out.println("Tutte le prenotazioni sono state disdette!");
		this.postiDaDisException = postiDaDisException;
	}
	
}
