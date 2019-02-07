package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;
import pobj.motx.tme2.GrillePotentiel;

/**
 * Cette classe represente un objet MotX qui implemente ICSP
 * Elle regroupe l'ensemble des variables du probleme pour permettre
 * de les traiter.
 * Elle a aussi une reference sur la grillepotentiel 
 */
public class MotX implements ICSP{
	
	
	private List<IVariable> dicoVariable;
	private GrillePotentiel gp;
	public MotX(GrillePotentiel gp) {
		this.gp = gp;
		int i = 0;
		dicoVariable =  new ArrayList<IVariable>();
		for (Emplacement e: gp.getPlaces().getPlaces()) {
			if(e.hasCaseVide())
					dicoVariable.add(new DicoVariable(i, gp));
			i++;
			
		}
		
	}
	@Override
	public List<IVariable> getVars() {
		return dicoVariable;
	}

	@Override
	public boolean isConsistent() {
		return !gp.isDead();
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		if(vi instanceof DicoVariable) {
			DicoVariable d = (DicoVariable) vi ;
			return new MotX(gp.fixer(d.getIndex(), val));			
		}
		return null;
	}
	public GrillePotentiel getGp() {
		return gp;
	}
	
	
	
	
	
	
	
}