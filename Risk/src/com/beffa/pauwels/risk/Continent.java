package com.beffa.pauwels.risk;

import java.util.ArrayList;

public class Continent {

	public int idContinent;

	private ArrayList<Territoire> territoiresDuContinent;

	public Continent(int idContinent, ArrayList<Territoire> territoiresDuContinent) {
		this.idContinent = idContinent;
		this.territoiresDuContinent = territoiresDuContinent;
	}

	public boolean estControlePar(Joueur joueur, int rangTerritoire) {
		for (int i = 0; i < this.territoiresDuContinent.size(); i++) {
			if (this.territoiresDuContinent.get(i).getOccupant() != joueur) {
				return false;
			}
		}

		return true;
	}

	public ArrayList<Territoire> getTerritoiresDuContinent() {
		return territoiresDuContinent;
	}

}