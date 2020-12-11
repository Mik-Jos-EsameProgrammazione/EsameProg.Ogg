
/**
 * Description of Vento.
 * 
 * @author mikdr
 */
public class Vento {
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
	 * The constructor 1.
	 */
	public Vento(float velocita, int direzione, float raffica) {
		this.velocita = velocita;
		this.direzione = direzione;
		this.raffica = raffica;
	}
	
	/**
	 * The constructor 2.
	 */
	public Vento(float velocita, int direzione) {
		this.velocita = velocita;
		this.direzione = direzione;
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
	 * Description of the method toString.
	 * @return 
	 */
	public String toString() {
		// Start of user code for method toString
		String toString = "";
		return toString;
		// End of user code
	}

}
