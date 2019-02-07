package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

/**
 * 
 * @author ALLOUACHE Yacine
 * @author TAMENE Hocine
 */
public class GrillePotentiel {

	/**
	 * La grille partiellement remplie
	 */
	private GrillePlaces places;
	/**
	 * Le dictionnaire français complet
	 */
	private Dictionnaire dictionnaire;
	/**
	 * Le domaine de chaque emplacement de la grille, dans le même ordre que la
	 * grille
	 */
	private List<Dictionnaire> motsPot ;
	/**
	 * Les contraintes croisement entre deux mots
	 */
	private List<IContrainte> contraintes;
	/**
	 * true si la grille est realisbale 
	 */
	private boolean estRealisable;
	
	/**
	 * Contructeur d'une instance de GrillePotentiel
	 * 
	 * @param grille      la liste des emplacement des mots dans la grille
	 * @param dicoComplet Le dictionnaire français complet
	 */

	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.places = grille;
		this.dictionnaire = dicoComplet;
		this.contraintes = new ArrayList<>();
		motsPot =new ArrayList<Dictionnaire>();
		filtre(grille,dicoComplet);
		contrainte(grille);
		propage();
	}
public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet, List<Dictionnaire> motsPot) {
	
	this.places = grille;
	this.dictionnaire = dicoComplet;
	this.contraintes = new ArrayList<>();
	this.motsPot = motsPot;
	int i = 0;
		for (Emplacement e : grille.getPlaces()) {
			
			this.motsPot.get(i).filtreLongueur(e.size());
			int j = 0;
			for (Case c : e.getCases()) {
				if (!(c.isPleine() || c.isVide())) 
				   this.motsPot.get(i).filtreParLettre(c.getChar(), j);
				j++;
			
			}
			System.out.println(this.motsPot.get(i).size());
			i++;
			
		}
		
		contrainte(grille);
		propage();
}
	
	
	public List<Dictionnaire> copy(List<Dictionnaire> motsPot){
		List<Dictionnaire> d = new ArrayList<Dictionnaire>();
		for (Dictionnaire dico : motsPot) {
			d.add(dico.copy());
		}
		return d;
	}
	
	
	public void filtre(GrillePlaces grille , Dictionnaire dicoComplet) {
		int j = 0;
		for (Emplacement emplacement : grille.getPlaces()) {
			Dictionnaire dico = dicoComplet.copy();
			dico.filtreLongueur(emplacement.size());
			int i = 0;
			for (Case c : emplacement.getCases()) {
				if (!(c.isPleine() || c.isVide())) {
					dico.filtreParLettre(c.getChar(), i);
				}
				i++;
			}
			motsPot.add(dico);
			j++;
		}
		
	}
	public void contrainte(GrillePlaces grille) {
		for (int i = 0; i < grille.getNbHorizontal(); i++) {
			Emplacement m1 = grille.getPlaces().get(i);
			for (int j = grille.getNbHorizontal(); j < grille.getPlaces().size(); j++) {
				Emplacement m2 = grille.getPlaces().get(j);
				for (int c1 = 0; c1 < m1.getCases().size(); c1++) {
					for (int c2 = 0; c2 < m2.getCases().size(); c2++) {
						if (m1.getCases().get(c1).equals(m2.getCases().get(c2)) && m1.getCases().get(c1).isVide()) {
							IContrainte contrainte = new CroixContrainte(i, c1, j, c2);
							if (!contraintes.contains(contrainte)) {
								contraintes.add(contrainte);
							}
						}
					}
				}
			}
		}
		//this.propage();
		
	}

	/**
	 * Rend vrais si il existe au moin un domaine vides
	 * 
	 * @return boolean true si et seulement si au moins un emplacement a un domaine
	 *         potentiel vide
	 */
	public boolean isDead() {
		boolean b = false;
		for (Dictionnaire dictionnaire : motsPot) {
			b = dictionnaire.size() == 0;
		}
		return b;
	}

	/**
	 * Fais l'affectation de mot "soluce" dans le m iéme emplacment dans une copie
	 * de la grille Renvoie une GrillePotentiel avec le m iéme emlacement qui est
	 * remplie avec le mot soluce
	 * 
	 * @param m      l'index de l'emplacement de mot dans la grille.
	 * @param soluce le mot avec qui remplir le m iém emplacment de la Grille.
	 * @return un nouveau GrillePotentiel avec la grille résultant de l’affectation.
	 */
	public GrillePotentiel fixer(int m, String soluce) {
		return new GrillePotentiel(this.getPlaces().fixer(m, soluce), this.dictionnaire,this.copy(motsPot));
		
	}

	/**
	 * Accede et renvoie la liste des enmplacement dans la grille
	 * 
	 * @return the places une liste des emplacement
	 */
	public GrillePlaces getPlaces() {
		return places;
	}

	/**
	 * Accede et renvoie le dictionnaire general de mot
	 * 
	 * @return the dictionnaire
	 */
	public Dictionnaire getDictionnaire() {
		return dictionnaire;
	}

	/**
	 * Modifier la valeur de domaine complet
	 * 
	 * @param dictionnaire le nouveau domaine to set
	 */
	public void setDictionnaire(Dictionnaire dictionnaire) {
		this.dictionnaire = dictionnaire;
	}

	/**
	 * 
	 * Accede aux domaines des emplacements de la grille
	 *
	 * @return the motsPot liste des Dectionnaires qui representent les domaines des
	 *         emplacements
	 */
	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}

	/**
	 * Accede et renvoie la liste des contraintes de croisement trouvees
	 * 
	 * @return list<IContrainte> c'est la liste des contraintes de croisement
	 */
	public List<IContrainte> getContraintes() {
		return contraintes;
	}

	/**
	 * @return true si le mot croisé est irréalisable false si le nombre de mots
	 *         éliminés est de 0
	 */
	private boolean propage() {
		
		while (true) {

			int nbreDeMotsEliminees = 0;
			for (IContrainte iContrainte : contraintes) {
				nbreDeMotsEliminees += iContrainte.reduce(this);
			}
			if (nbreDeMotsEliminees == 0) {
				return true;
			}
			if (this.isDead()) {
				return false;
			}
		}
	}

	public boolean estRealisable() {
		return estRealisable;
	}
}
