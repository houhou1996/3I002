package pobj.motx.tme3.csp;

import java.util.List;

/**
 * 
 * C'est un probleme de satisfaction de contraintes
 * 
 * @author ALLOUACHE Yacine
 * @author TAMENE Hocine
 */
public interface ICSP {

	/**
	 * Accéder aux variables du problème
	 * 
	 * @return List<Ivaribale> l'ensemble des variables
	 */
	List<IVariable> getVars();

	/**
	 * true si le problème est encore satisfiable false si non
	 * 
	 * @return true si le problème est encore satisfiable false si non
	 */
	boolean isConsistent();

	/**
	 * Affectation de mot val à la varibale vi
	 * 
	 * @param vi IVaribale c'est une variable (c'est un mot de la grille)
	 * @param val String c'est un mot de domaine de la variable vi
	 * @return ICSO un nouveau problème CSP mais avec une varibale de moins.
	 */
	ICSP assign(IVariable vi, String val);
	
}
