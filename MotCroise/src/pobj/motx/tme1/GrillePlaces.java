package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {
	private List<Emplacement> places;
	private Grille grille;
	private int nbHoriz;

	public GrillePlaces(Grille grille) {
		places = new ArrayList<Emplacement>();
		this.grille = grille;
		for (int i = 0; i < grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
		}
		nbHoriz = places.size();
		for (int i = 0; i < grille.nbCol(); i++) {
			cherchePlaces(getCol(i));
		}
	}
	public GrillePlaces fixer(int m, String soluce) {
		GrillePlaces g = new GrillePlaces(grille.copy());	
		for (int i = 0; i < soluce.length(); i++) {
			g.getPlaces().get(m).getCase(i).setChar(soluce.charAt(i));
			}
		return g;
	}
	
	
	public List<Emplacement> getPlaces(){
		return places;
	}
	public int getNbHorizontal() {
		return nbHoriz;
	}
	
	public String toString() {
		String str ="";
		for (Emplacement emplacement : places) {
			str+=emplacement.toString()+"\n";
		}
		return str;
	}
	private List<Case> getLig(int lig){
		List<Case> liste = new ArrayList<Case>();
		for (int i = 0; i < grille.nbCol(); i++) 
			liste.add(grille.getCase(lig, i));
		return liste;
	}
	private List<Case> getCol(int col){
		List<Case> liste = new ArrayList<Case>();
		for (int i = 0; i < grille.nbLig(); i++) 
			liste.add(grille.getCase(i, col));
		return liste;
	}
	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for (Case case1 : cases) {
			if(!case1.isPleine())
				e.add(case1);
			else {
				if(e.size()>1)
					places.add(e);
		        e = new Emplacement();
			}
		}
		if(e.size()> 1)
			places.add(e);
	}
	
	}
	
	


