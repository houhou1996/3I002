package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Un Emplacement est une liste de taille superieur à 2 de case vide de la meme ligne ou de colonne
 * on peut les remplir avec des lettre pour avoir un mot 
 * 
 * @author ALLOUACHE Yacine
 * @author TAMENE Hocine
 */
public class Emplacement {

	/** Une liste de Case*/
	private List<Case> lettres = new ArrayList<Case>();

	

	/**
	 * Obtenir la taille de l'emplacement 
	 * @return la taille de la liste des Cases
	 */
	public int size() {
		return this.lettres.size();
	}

	/**
	 * Ajouter une Case à l'emplacement 
	 * 
	 * @param c une case à ajouter dans l'emplacement
	 * @return <tt>true</tt> (as specified by {@link Collection#add})
	 */
	public boolean add(Case c) {
		return this.lettres.add(c);
	}
	
	/**
	 * Accède a la liste des cases de l'emplacement
	 * 
	 * @return liste des lettres de l'emplacement
	 */
	public List<Case> getCases(){
		return this.lettres;
	}
	
	/**
	 * Vide la liste des cases
	 * 
	 * La liste des cases devient vide apre avoir appeler a cette methode
	 */
	public void vider() {
		this.lettres.clear();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Case l : lettres) {
			sb.append(l.getChar()+";");
		}
		return sb.toString();
	}
	
	/**
	 * Parcour la liste des cases de l'emplacement et renvoit true si il a une case vide false sinon
	 * 
	 * @return true si l'emplacement a une case vide false sinon
	 */
	public boolean hasCaseVide() {
		for (Case case1 : lettres) {
			if (case1.isVide()) {
				return true;
			}
		}
		return false;
	}
	public Case getCase(int i) {
		return lettres.get(i);

	}
	
}
