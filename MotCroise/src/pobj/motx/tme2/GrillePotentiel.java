package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dicoComplet;
	private List<Dictionnaire> motPot;
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		motPot = new ArrayList<Dictionnaire>();
		this.grille = grille;
		this.dicoComplet = dicoComplet;
		int nbEmp = grille.getPlaces().size();
		for (int i = 0; i < nbEmp; i++) {
			Dictionnaire d = dicoComplet.copy();
			Emplacement e = grille.getPlaces().get(i);
			d.filtreLongueur(e.size());
			for (int j = 0; j < e.size(); j++) {
				if(!e.getCase(j).isPleine() && !e.getCase(j).isVide()) {
					d.filtreParLettre(e.getCase(j).getChar(), j);
				}		
			}
			motPot.add(d);	
		}
	}
public GrillePotentiel fixer(int m, String soluce) {
		return new GrillePotentiel(grille.fixer(m, soluce),dicoComplet);
	}
	public boolean isDead() {
		for (int i = 0; i < grille.getPlaces().size(); i++) {
			if(motPot.get(i).size() == 0)
					return true;
			}
		return false;
	}

	public List<Dictionnaire> getMotsPot() {
		return motPot;
		
		
	}

}
