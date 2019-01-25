package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {
	private List<Case> lettres;
	public Emplacement() {
		lettres = new ArrayList<Case>();
	}

	public String toString() {
		String str ="";
		for (Case case1 : lettres) {
//			if(!case1.isPleine() && !case1.isVide())
				str+=case1.getChar();
		}
		return str;
	}
	public List<Case> getLettres() {
		return lettres;
	}
	public Case getCase(int i) {
		if(lettres != null)
			return lettres.get(i);
		return null;
	}
	public int size() {
		return lettres.size();
	}
	public void add(Case c) {
		if(c != null)
			lettres.add(c);
	}
	public boolean estHoriz() {
		return (this.getCase(0).getCol())<(this.getCase(1).getCol());
	}
	public boolean estVertic() {
		 return (this.getCase(0).getLig())<(this.getCase(1).getLig());
	}
}
















