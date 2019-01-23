package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {
	List<Case> lettres;
	public Emplacement() {
		lettres = new ArrayList();
	}

	public String toString() {
		String str ="";
		for (Case case1 : lettres) {
			str+=case1;
		}
		return str;
	}
	public int size() {
		return lettres.size();
	}
	public void add(Case c) {
		if(c != null)
			lettres.add(c);
	}
}
