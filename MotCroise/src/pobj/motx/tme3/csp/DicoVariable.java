/**
 * 
 */
package pobj.motx.tme3.csp;

import java.util.List;

import pobj.motx.tme2.GrillePotentiel;

/**
 * C'est un emplacement de la grille
 * 
 * @author ALLOUACHE Yacine
 * @author TAMENE Hocine
 */
public class DicoVariable implements IVariable {

	/**
	 * l'indice de l’emplacement de mot correspondant
	 */
	private int index;
	/**
	 * reference vers une grillePotentiel
	 */
	private GrillePotentiel gp;

	/**
	 * Constructeur avec l'index de l'emplacement mot et une grille
	 * 
	 * @param index l'index de l'emplacement de mot
	 * @param gp    la grille
	 */
	public DicoVariable(int index, GrillePotentiel gp) {
		this.index = index;
		this.gp = gp;
	}

	@Override
	public List<String> getDomain() {
		return this.gp.getMotsPot().get(index).getMots();
	}

	/**
	 * Accede a la grille potentiel
	 * 
	 * @return {@link GrillePotentiel}
	 */
	public GrillePotentiel getGp() {
		return gp;
	}

	/**
	 * l'indice de l'emplacement de mot correspondant
	 * 
	 * @return {@link Integer} l'indice de l'emplacement de mot correspondant
	 */
	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return String.format("l'index de l'emplacement: %d\n l'ensemble des mots: \n%s",
				this.index, this.gp.getMotsPot().get(this.index));
	}

}
