package com.beffa.pauwels.risk;

import java.util.ArrayList;

public class Territoire {

	private String nom;

	private String[] territoiresAdjacents;
	private Joueur occupant;

	ArrayList<Unite> listeUnites = new ArrayList<Unite>();

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

	public void addUnite(Territoire t, Unite u) {
		t.listeUnites.add(u);
	}

	public ArrayList<Unite> getListeUnites() {
		return listeUnites;

	}

}
