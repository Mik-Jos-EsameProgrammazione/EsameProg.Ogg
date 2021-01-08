package com.esame_prog_meteo.MeteoDati;

/**
 * Questa classe corrisponde all'oggetto wind della risposta API
 * @author Michele Di Renzo
 * @author Joshua Ciccolini
 */

public class Vento extends DatiMeteo{
	protected float velocita;
	protected int direzione;
	protected float raffica;
	protected boolean isRaffica;

	/**
	 * In questo costruttore è presente l'attributo raffica.
	 */
	public Vento (String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base, float velocita, int direzione, float raffica) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.velocita = velocita;
		this.direzione = direzione;
		this.raffica = raffica;
	}
	
	/**
	 * In questo costruttore non è presente l'attributo raffica.
	 */
	public Vento(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base, float velocita, int direzione) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.velocita = velocita;
		this.direzione = direzione;
	}

	/**
	 * @return velocita 
	 */
	public float getVelocita() {
		return this.velocita;
	}

	/** 
	 * @param newVelocita è la nuova velocità 
	 */
	public void setVelocita(float newVelocita) {
		this.velocita = newVelocita;
	}

	/**
	 * @return direzione 
	 */
	public int getDirezione() {
		return this.direzione;
	}

	/**
	 * @param newDirezione è la nuova direzione
	 */
	public void setDirezione(int newDirezione) {
		this.direzione = newDirezione;
	}

	/**
	 * @return raffica 
	 */
	public float getRaffica() {
		return this.raffica;
	}

	/**
	 * @param newRaffica è la nuova raffica.
	 */
	public void setRaffica(float newRaffica) {
		this.raffica = newRaffica;
	}
	
	/**
	 * @return dati del vento
	 */
	public String toString() {
		return ("Velocita: " + velocita + "; Direzione: " + direzione + "; Raffica: " + raffica);
	}

}
