package pobj.motx.tme1;

public class Grille {
	private Case[][] grille;

	public Grille(int hauteur, int largeur) {

		grille = new Case[hauteur][largeur];
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				grille[i][j] = new Case(i, j, ' ');
			}
			
		}
	}
	public Case getCase(int lig, int col) {
		return grille[lig][col];
    
	
	}

	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	public int nbLig() {
		return grille.length;
	}
	public int nbCol() {
		return grille[0].length;
	}
	public Grille copy() {
		Grille g = new Grille(nbLig(),nbCol());
		for (int i = 0; i < nbLig(); i++) {
			for (int j = 0; j < nbCol(); j++) {
					g.getCase(i, j).setChar(getCase(i, j).getChar());
				
			}
			
		}
		return g;
	}
	
}
