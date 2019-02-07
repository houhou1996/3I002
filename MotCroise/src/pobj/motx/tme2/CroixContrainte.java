package pobj.motx.tme2;

/**
 * @author ALLOUACHE Yacine 
 * @author TAMENE Hocine
 */
public class CroixContrainte implements IContrainte {

	/**
	 * l'indice de premier emplacement
	 */
	private int m1;
	/**
	 * l'indice de la case où a lieu le croisement pour le premier emplacement
	 */
	private int c1;

	/**
	 * l'indice de deuxième emplacement
	 */
	private int m2;
	/**
	 * l'indice de la case où a lieu le croisement pour le deuxième emplacement
	 */
	private int c2;

	/**
	 * Construit une contrainte de croisement de l'emplacment m1 a la c1 éme lettre
	 * et l'emplacment m2 a la c2 éme lettre
	 * 
	 * 
	 * @param m1 l'index de premier emplacement
	 * @param c1 l'index de la lettre de croisement de premier emplacment
	 * @param m2 l'index de deuxieme emplacement
	 * @param c2 l'index de la lettre de croisement de deuxieme emplacment
	 */
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		super();
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}

	@Override
	public int reduce(GrillePotentiel grille) {
		EnsembleLettre liste1 = grille.getMotsPot().get(m1).ensembleLettreInPos(c1);

		EnsembleLettre liste2 = grille.getMotsPot().get(m2).ensembleLettreInPos(c2);

		EnsembleLettre s = new EnsembleLettre(liste1);
		
		s.retainAll(liste2);
		
		int nombreDeMotFiltrees = 0;

		if (liste1.size() > s.size()) {
			nombreDeMotFiltrees += grille.getMotsPot().get(m1).filterParEnsembleDeLettrePo(c1, s);
		}

		if (liste2.size() > s.size()) {
			nombreDeMotFiltrees += grille.getMotsPot().get(m2).filterParEnsembleDeLettrePo(c2, s);
		}
		
		return nombreDeMotFiltrees;
	}

	/**
	 * @return the m1
	 */
	public int getM1() {
		return m1;
	}

	/**
	 * @param m1 the m1 to set
	 */
	public void setM1(int m1) {
		this.m1 = m1;
	}

	/**
	 * @return the c1
	 */
	public int getC1() {
		return c1;
	}

	/**
	 * @param c1 the c1 to set
	 */
	public void setC1(int c1) {
		this.c1 = c1;
	}

	/**
	 * @return the m2
	 */
	public int getM2() {
		return m2;
	}

	/**
	 * @param m2 the m2 to set
	 */
	public void setM2(int m2) {
		this.m2 = m2;
	}

	/**
	 * @return the c2
	 */
	public int getC2() {
		return c2;
	}

	/**
	 * @param c2 the c2 to set
	 */
	public void setC2(int c2) {
		this.c2 = c2;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CroixContrainte))
			return false;
		CroixContrainte other = (CroixContrainte) obj;
		if (c1 != other.c1)
			return false;
		if (c2 != other.c2)
			return false;
		if (m1 != other.m1)
			return false;
		if (m2 != other.m2)
			return false;
		return true;
	}

}
