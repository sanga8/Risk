package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.HashMap;

public class Joueur {

	private String nom;
	private int idJoueur;
	private int armees;

	private ArrayList<Territoire> territoiresPossedes = new ArrayList<Territoire>();
	private ArrayList<Continent> continentsPossedes = new ArrayList<Continent>();

	public Joueur(String nom, int idJoueur) {
		this.nom = nom;
		this.idJoueur = idJoueur;
	}

	
	
	
	
	public boolean Perdu() {
		if (this.territoiresPossedes.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Gagne() {
		if (this.territoiresPossedes.size() == 42) {
			return true;
		} else {
			return false;
		}
	}

	public void ajouterTerritoirePossede(Territoire territoire) {
		this.territoiresPossedes.add(territoire);
	}

	public void supprimerTerritoirePossede(Territoire territoire) {
		this.territoiresPossedes.remove(territoire);
	}

	public String getNom() {
		return nom;
	}
	public int getIdJoueur() {
		return idJoueur;
	}


	
	

}
