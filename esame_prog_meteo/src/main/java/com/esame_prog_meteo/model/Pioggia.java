package com.esame_prog_meteo.model;


//questa classe corrisponde all'oggetto rain della risposta API

public class Pioggia extends DatiMeteo{
	protected float pioggia1h; //in mm (pioggia nell'ultima ora)
	
	public Pioggia(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base,
					float pioggia1h) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.pioggia1h = pioggia1h;
	}

	public float getPioggia1h() {
		return pioggia1h;
	}

	public void setPioggia1h(float pioggia1h) {
		this.pioggia1h = pioggia1h;
	}
	
	public String toString() {
		return ("Pioggia ultima ora: " + pioggia1h + "mm");
	}	
}

