package com.beffa.pauwels.risk;

public class Unite {
	
	private int puissance;
	private int resultatDe;
	private int type;
	private String nom;
	
	public Unite(int puissance, int resultatDe, int type, String nom) {
		
		this.puissance = puissance;
		this.resultatDe = resultatDe;
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


}