package com.beffa.pauwels.risk;

public class Unite {
	
	private int puissance;
	private String nom;
	
	public Unite(int parametrePuissance, String nomUnite) {
		
		puissance = parametrePuissance;
		nom = nomUnite;
		
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


	

}