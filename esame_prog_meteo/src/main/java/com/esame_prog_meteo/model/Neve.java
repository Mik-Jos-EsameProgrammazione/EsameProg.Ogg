package com.esame_prog_meteo.model;

//questa classe corrisponde all'oggetto snow della risposta API

public class Neve extends DatiMeteo{
	protected float neve1h; //in mm (neve nell'ultima ora)
	
	public Neve(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base,
					float neve1h) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.neve1h = neve1h;
	}

	public float getNeve1h() {
		return neve1h;
	}

	public void setNeve1h(float neve1h) {
		this.neve1h = neve1h;
	}

	public String toString() {
		return ("Neve ultima ora: " + neve1h + "mm" );
	}
}
