package pobj.motx.tme3.csp;

import java.util.List;

/**
 * @author ALLOUACHE Yacine
 * @author TAMENE Hocine
 *
 */
public interface IVariable {

	
	/**
	 * l'ensemble des mots que la variable peut prendre
	 * le domaine de la varibale
	 * @return List<String> une liste des mots
	 */
	List<String> getDomain();
}
