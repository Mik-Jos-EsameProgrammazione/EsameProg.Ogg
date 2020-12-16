package MeteoDati;

/**
 * Description of Vento.
 * 
 * @author mikdr
 */

//questa classe corrisponde all'oggetto wind della risposta API

public class Vento extends DatiMeteo{
	/**
	 * Description of the property velocita.
	 */
	protected float velocita;

	/**
	 * Description of the property direzione.
	 */
	protected int direzione;

	/**
	 * Description of the property raffica.
	 */
	protected float raffica;
	
	/**
	 * Description of the property isRaffica.
	 */
	protected boolean isRaffica;

	/**
	 * The constructor 1 there is raffica.
	 */
	public Vento (String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base, float velocita, int direzione, float raffica) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.velocita = velocita;
		this.direzione = direzione;
		this.raffica = raffica;
	}
	
	/**
	 * The constructor 2 there isn't raffica.
	 */
	public Vento(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base, float velocita, int direzione) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.velocita = velocita;
		this.direzione = direzione;
	}
	
	/**
	 * The constructor 3 isRaffica boolean.
	 */
	public Vento(String nome, int idCitta, int cod, int timezone, long dR, int visibilita, String base, 
				 float velocita, int direzione, boolean isRaffica) {
		super(nome, idCitta, cod, timezone, dR, visibilita, base);
		this.velocita = velocita;
		this.direzione = direzione;
		this.isRaffica = isRaffica;
	}
	

	/**
	 * Returns velocita.
	 * @return velocita 
	 */
	public float getVelocita() {
		return this.velocita;
	}

	/**
	 * Sets a value to attribute velocita. 
	 * @param newVelocita 
	 */
	public void setVelocita(float newVelocita) {
		this.velocita = newVelocita;
	}

	/**
	 * Returns direzione.
	 * @return direzione 
	 */
	public int getDirezione() {
		return this.direzione;
	}

	/**
	 * Sets a value to attribute direzione. 
	 * @param newDirezione 
	 */
	public void setDirezione(int newDirezione) {
		this.direzione = newDirezione;
	}

	/**
	 * Returns raffica.
	 * @return raffica 
	 */
	public float getRaffica() {
		return this.raffica;
	}

	/**
	 * Sets a value to attribute raffica. 
	 * @param newRaffica 
	 */
	public void setRaffica(float newRaffica) {
		this.raffica = newRaffica;
	}
	
	/**
	 * Returns isRraffica.
	 * @return isRaffica 
	 */
	public boolean getisRaffica() {
		return this.isRaffica;
	}

	/**
	 * Sets a value to attribute isRaffica. 
	 * @param newisRaffica 
	 */
	public void setRaffica(boolean newisRaffica) {
		this.isRaffica = newisRaffica;
	}
	
	/**
	 * Description of the method toString.
	 * @return 
	 */
	public String toString() {
		return ("Velocita: " + velocita + "; Direzione: " + direzione + "; Raffica: " + raffica);
	}

}