package com.beffa.pauwels.risk;

import java.util.ArrayList;
public class Territoire {

	private String nom;
	private int id;
	private String[] territoiresAdjacents;
	private Joueur occupant;
	
	ArrayList<Unite> listeUnites = new ArrayList<Unite>();

	public Territoire(String nom, String[] territoiresAdjacents, int id) {
		this.nom = nom;
		this.id=id;
		this.territoiresAdjacents = territoiresAdjacents;
		
	}

	
	
	public String[] getTerritoiresAdjacents() {
		return territoiresAdjacents;
	}

	public void setTerritoiresAdjacents(String[] territoiresAdjacents) {
		this.territoiresAdjacents = territoiresAdjacents;
	}

	public Joueur getOccupant() {
		return occupant;
	}

	public void setOccupant(Joueur occupant) {
		this.occupant = occupant;
	}
	public void addUnite(Unite u) {
		listeUnites.add(u);
	}

	public ArrayList<Unite> getListeUnites() {
		return listeUnites;

	}
	public int getId() {
		return id;
	}

	

}
