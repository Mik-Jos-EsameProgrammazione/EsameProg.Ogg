package com.esame_prog_meteo.meteodati;

/**
 * Classe che Contiene tutte le informazioni relative al vento.
 * 
 * @author Joshua Ciccolini
 * @author Michele Di Renzo
 */
public class Vento extends DatiMeteo {
	/**
	 * Valore della velocità del vento.
	 */
	protected float velocita;

	/**
	 * Valore della direzione del vento.
	 */
	protected int direzione;

	/**
	 * Valore della velocità della raffica.
	 */
	protected float raffica;

	/**
	 * Costruttore della classe con la raffica.
	 * 
	 * @param nome       Nome della città su cui vengono fatte le misurazioni.
	 * @param idCitta    Identificativo della città.
	 * @param cod        Codice della città.
	 * @param timezone   Valore del fusorario.
	 * @param dR         Data di rilevazione delle informazioni.
	 * @param visibilita Valore della visibilità della località.
	 * @param base       Parametro interno.
	 * @param velocita   Valore della velocità del vento.
	 * @param direzione  Valore della direzione del vento.
	 * @param raffica    Valore della velocità della raffica.
	 */
	public Vento(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base, float velocita,
			int direzione, float raffica) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.velocita = velocita;
		this.direzione = direzione;
		this.raffica = raffica;
	}

	/**
	 * Costruttore della classe senza la raffica.
	 * 
	 * @param nome       Nome della città su cui vengono fatte le misurazioni.
	 * @param idCitta    Identificativo della città.
	 * @param cod        Codice della città.
	 * @param timezone   Valore del fusorario.
	 * @param dR         Data di rilevazione delle informazioni.
	 * @param visibilita Valore della visibilità della località.
	 * @param base       Parametro interno.
	 * @param velocita   Valore della velocità del vento.
	 * @param direzione  Valore della direzione del vento.
	 */
	public Vento(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base, float velocita,
			int direzione) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.velocita = velocita;
		this.direzione = direzione;
	}

	/**
	 * Costruttore di default.
	 */
	public Vento() {
		super();
	}

	/**
	 * Restituisce il valore della velocità del vento.
	 * 
	 * @return velocita Valore della velocità.
	 */
	public float getVelocita() {
		return this.velocita;
	}

	/**
	 * Imposta il valore della velocità del vento.
	 * 
	 * @param newVelocita Valore della velocità.
	 */
	public void setVelocita(float newVelocita) {
		this.velocita = newVelocita;
	}

	/**
	 * Restituisce il valore della direzione del vento.
	 * 
	 * @return direzione Valore della direzione.
	 */
	public int getDirezione() {
		return this.direzione;
	}

	/**
	 * Imposta il valore della direzione del vento.
	 * 
	 * @param newDirezione Valore della direzione.
	 */
	public void setDirezione(int newDirezione) {
		this.direzione = newDirezione;
	}

	/**
	 * Restituisce il valore della velocità della raffica.
	 * 
	 * @return raffica Valore della raffica
	 */
	public float getRaffica() {
		return this.raffica;
	}

	/**
	 * Imposta il valore della velocità della raffica.
	 * 
	 * @param newRaffica Valore della raffica
	 */
	public void setRaffica(float newRaffica) {
		this.raffica = newRaffica;
	}

	/**
	 * Restituisce le informazioni del vento sotto forma di stringa (Overriding del
	 * metodo toString() di Object).
	 * 
	 * @return informazioni sotto forma di stringa.
	 */
	public String toString() {
		return ("Velocita: " + velocita + "; Direzione: " + direzione + "; Raffica: " + raffica);
	}

}
