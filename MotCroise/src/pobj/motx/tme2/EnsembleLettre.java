package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author ALLOUACHE Yacine
 * @author TAMENE Hocine
 */

/**
 * C'est une liste de Caractere
 * 
 */
public class EnsembleLettre extends ArrayList<Character> {

	private static final long serialVersionUID = 1L;

	
	
	/**
	 *Construit une liste vide qui prend des caractere  
	 */
	public EnsembleLettre() {
		
	}

	/**
	 * 
	 * Construit une liste qui contient la collection de character passe en parametre
	 * 
	 * @param c c'est une collection de caractere 
	 */
	EnsembleLettre(Collection<? extends Character> c) {
		super(c);
	}
	
	/**
	 * Ajouter un caractere dans la liste sans doublon
	 */
	@Override
	public boolean add(Character e) {
		if (!this.contains(e)) {
			return super.add(e);
		} else
			return false;
	}
	

}
