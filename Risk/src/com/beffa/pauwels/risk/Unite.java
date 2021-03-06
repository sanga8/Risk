package com.beffa.pauwels.risk;

/**
 * Cette classe permet de créer les unités et leurs arguments.
 *
 */
public class Unite {

	private int puissance;
	private int prioriteATT;
	private int prioriteDEF;
	private int resultatDe = 0;
	private int type;
	private int mouvement;

	public Unite(int type) {
		this.type = type;
		// SOLDAT
		if (type == 0) {
			this.puissance = 1; // La puissance de l'unité
			this.prioriteATT = 2; // La priorité d'attaque de l'unité
			this.prioriteDEF = 1; // La priorité de défense de l'unité
			this.mouvement = 2; // Le nombre de points de mouvement de l'unité

		}
		// CAVALIER
		if (type == 1) {
			this.puissance = 2;
			this.prioriteATT = 1;
			this.prioriteDEF = 3;
			this.mouvement = 3;

		}
		// CANON
		if (type == 2) {
			this.puissance = 4;
			this.prioriteATT = 3;
			this.prioriteDEF = 2;
			this.mouvement = 1;

		}

	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getResultatDe() {
		return resultatDe;
	}

	public void setResultatDe(int resultatDe) {
		this.resultatDe = resultatDe;
	}

	public int getPrioriteATT() {
		return prioriteATT;
	}

	public void setPrioriteATT(int prioriteATQ) {
		this.prioriteATT = prioriteATQ;
	}

	public int getPrioriteDEF() {
		return prioriteDEF;
	}

	public void setPrioriteDEF(int prioriteDEF) {
		this.prioriteDEF = prioriteDEF;
	}

	public int getMouvement() {
		return mouvement;
	}

	public void setMouvement(int mouvement) {
		this.mouvement = mouvement;
	}

}