package pobj.motx.tme2;

import java.util.*;

public class CroixContrainte implements IContrainte {
	int m1,c1,m2,c2;
	public CroixContrainte(int m1 , int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;	
	}

	@Override
	public int reduce(GrillePotentiel grille) {
		int cpt = 0;
			EnsembleLettre l1 = grille.get(m1).charAt(c1);
			EnsembleLettre l2 = grille.get(m2).charAt(c2);
			EnsembleLettre s = l1.intersection(l2);
			if(l1.size() > s.size()) {
				cpt += grille.getMotsPot().get(m1).filtreParLettre(s, c1);	
			}
			if(l2.size() > s.size()) {
				cpt += grille.getMotsPot().get(m2).filtreParLettre(s, c2);	
			}
		return cpt;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null)
			return false;
		if(obj.getClass() == this.getClass()) {
			CroixContrainte c = (CroixContrainte)obj;
			if(this.m1 == c.m1 && this.c1 == c.c1 && this.m2 == c.m2 && this.c2 == c.c2)
				return true;
		}
		return false;
	}
}
