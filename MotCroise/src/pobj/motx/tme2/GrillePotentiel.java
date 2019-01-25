package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dicoComplet;
	private List<Dictionnaire> motPot;
	private List<IContrainte> contraintes;
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		
		motPot = new ArrayList<Dictionnaire>();
		contraintes = new ArrayList<IContrainte>();
		this.grille = grille;
		this.dicoComplet = dicoComplet;
		int nbEmp = grille.getPlaces().size();
		Dictionnaire d;
		for (int i = 0; i < nbEmp; i++) {
			 d = dicoComplet.copy();
			d.filtreLongueur(grille.getPlaces().get(i).size());
			for (int j = 0; j < grille.getPlaces().get(i).size(); j++) {
				if(!grille.getPlaces().get(i).getCase(j).isPleine() && !grille.getPlaces().get(i).getCase(j).isVide()) {
					d.filtreParLettre(grille.getPlaces().get(i).getCase(j).getChar(), j);
				}		
			}
			motPot.add(d);	
		}
		int m1 = 0;
		for (Emplacement e1 : grille.getPlaces()) {
			int m2=0;
			for (Emplacement e2: grille.getPlaces()) {
				if(e1.estHoriz() && e2.estVertic()) {
					for (int c1 = 0; c1 < e1.size(); c1++) {
						for (int c2 = 0; c2 < e2.size(); c2++) {
						if(e1.getCase(c1) == e2.getCase(c2) && e1.getCase(c1).isVide()) {
								contraintes.add(new CroixContrainte(m1, c1, m2, c2));
							}					
						}
					}
				}
				m2++;
			}
			m1++;		
		}
		propage();

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
	public boolean propage() {
		int cpt = 0;
		while(true) {
			for (IContrainte c : contraintes) {
				cpt += c.reduce(this);
			}
			if(this.isDead())
				return false;
			if(cpt == 0)
				return true;
		}
	}
	public Dictionnaire get(int i) {
		return motPot.get(i);
	}

	public List<Dictionnaire> getMotsPot() {
		return motPot;
		
		
	}
	public List<IContrainte> getContraintes() {
		return contraintes;
	}

}
