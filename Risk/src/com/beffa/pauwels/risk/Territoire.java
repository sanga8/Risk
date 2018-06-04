package com.beffa.pauwels.risk;

import java.sql.Time;
import java.util.ArrayList;

public class Territoire {



	private String nom;
	private int id;
	private String id2;
	private String[] territoiresAdjacents;
	private Joueur occupant;

	ArrayList<Unite> listeUnites = new ArrayList<Unite>();
	public Territoire(String nom, String[] territoiresAdjacents, int id, String id2) {
		this.nom = nom;
		this.id2=id2;
		this.id = id;
		this.territoiresAdjacents = territoiresAdjacents;
		listeUnites.add(new Unite(0));
		
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
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}
	public String getId2() {
		return id2;
	}



}
