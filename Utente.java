/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Utente.
 * 
 * @author mikdr
 */

public class Utente {
	/**
	 * Description of the property Nome.
	 */
	protected String nome;
	
	/**
	 * Description of the property Id.
	 */
	protected int id;
	protected static int defaultId = 1000;
	/**
	 * The constructor.
	 */
	public Utente(String nome)
	{
		this.nome = nome;
		defaultId ++;
		this.id = defaultId;
	}
	
	/**
	 * Returns Nome.
	 * @return Nome 
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Sets a value to attribute Nome. 
	 * @param newNome 
	 */
	public void setNome(String newNome) {
		this.nome = newNome;
	}
	
	/**
	 * Description of the method toString.
	 * @return 
	 */
	public String toString() {
		return "Nome: " + nome + "Id Utente: " + id;
	}
}
