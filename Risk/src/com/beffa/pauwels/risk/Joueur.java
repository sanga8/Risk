package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.HashMap;

public class Joueur {

	private String name;
	private int idJoueur;
	private int armees;
	private int nbJoueurs;

	private ArrayList<Territoire> territoiresPossedes = new ArrayList<Territoire>();
	private ArrayList<Continent> continentsPossedes = new ArrayList<Continent>();

	public Joueur(String name, int idJoueur) {
		this.name = name;
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

	public int getNbJoueurs() {
		return nbJoueurs;
	}

	public void setNbJoueurs(int nbJoueurs) {
		this.nbJoueurs = nbJoueurs;
	}

}
