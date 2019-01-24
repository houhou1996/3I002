package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {
	List<Case> lettres;
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
}
