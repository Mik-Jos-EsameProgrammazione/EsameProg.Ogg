
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
	 * Description of the property isRaffica.
	 */
	protected boolean isRaffica;

	/**
	 * The constructor 1 there is raffica.
	 */
	public Vento(float velocita, int direzione, float raffica) {
		this.velocita = velocita;
		this.direzione = direzione;
		this.raffica = raffica;
	}
	
	/**
	 * The constructor 2 there isn't raffica.
	 */
	public Vento(float velocita, int direzione) {
		this.velocita = velocita;
		this.direzione = direzione;
	}
	
	/**
	 * The constructor 3 isRaffica boolean.
	 */
	public Vento(float velocita, int direzione, boolean isRaffica) {
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
	public void setRaffica(float newisRaffica) {
		this.isRaffica = newisRaffica;
	}
	
	/**
	 * Description of the method toString.
	 * @return 
	 */
	public String toString() {
		return "Velocita: " + velocita + "; Direzione: " + direzione + "; Raffica: " + raffica;
	}

}
