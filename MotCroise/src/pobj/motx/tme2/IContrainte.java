package pobj.motx.tme2;

/**
 * @author ALLOUACHE Yacine
 * @author TAMENE Hocine
 *
 */
public interface IContrainte {

	/**
	 * Agit en modifiant la grille passée en argument, et rend le nombre total de
	 * mots filtrés par son action (donc potentiellement 0 si elle n’a aucun effet).
	 * 
	 * @param grille la grille a modifier
	 * @return int le nombre des mots filtrés
	 */
	int reduce(GrillePotentiel grille);

}
