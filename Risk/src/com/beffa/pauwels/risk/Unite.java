package com.beffa.pauwels.risk;

public class Unite {
	
	private int puissance;
	private int prioriteATQ;
	private int prioriteDEF; 
	private int resultatDe=0;
	private int type;
	private int mouvement;
	private String nom;
	
	public Unite(int puissance, int mouvement,  int type, int prioriteATQ,int prioriteDEF, String nom) {
		this.prioriteDEF = prioriteDEF;
		this.prioriteATQ = prioriteATQ;
		this.puissance = puissance;
		this.mouvement = mouvement;
		this.type = type;
		this.nom = nom;
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}
		
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public int getPrioriteATQ() {
		return prioriteATQ;
	}

	public void setPrioriteATQ(int prioriteATQ) {
		this.prioriteATQ = prioriteATQ;
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