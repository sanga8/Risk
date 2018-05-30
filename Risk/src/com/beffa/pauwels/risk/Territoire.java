package com.beffa.pauwels.risk;

import java.util.ArrayList;

public class Territoire {

	private String nom;

	private int Soldats = 1;
	private int Cavaliers = 0;
	private int Canons = 0;

	private String[] territoiresAdjacents;
	private Joueur occupant;

	public Territoire(String nom, String[] territoiresAdjacents) {
		this.nom = nom;
		this.territoiresAdjacents = territoiresAdjacents;
	}


	
	public Joueur getProprietaire() {
		return occupant;
	}

	public void setProprietaire(Joueur occupant) {
		this.occupant = occupant;
		
		

		
		
		
		
		
		
}

}
