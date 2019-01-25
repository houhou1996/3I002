package pobj.motx.tme2;

import java.util.*;

public class EnsembleLettre {
	
	List<Character> ensemble;
	
	public EnsembleLettre() {
		ensemble = new ArrayList<Character>();
	}
	public void add(char c) {
		if(!ensemble.contains(c))
			ensemble.add(c);
	}
	public int size() {
		return ensemble.size();
	}
	public boolean contains(char c ) {
		return ensemble.contains(c);
	}
public EnsembleLettre intersection(EnsembleLettre e2){
	EnsembleLettre liste = new EnsembleLettre();
	for (Character c : ensemble) {
		if(e2.contains(c))
			liste.add(c);
		}
	return liste;
}
}
