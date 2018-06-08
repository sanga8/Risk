package com.beffa.pauwels.risk;

import java.util.ArrayList;

public class Joueur {

	private String nom;
	private int idJoueur;

	private ArrayList<Unite> renforts = new ArrayList<Unite>();
	private ArrayList<Territoire> territoiresPossedes = new ArrayList<Territoire>();
	

	public Joueur(String nom, int idJoueur) {
		this.nom = nom;
		this.idJoueur = idJoueur;
	}

	public boolean perdu() {
		if (this.territoiresPossedes.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean gagne() {
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

	public ArrayList<Territoire> getTerritoiresPossedes() {
		return territoiresPossedes;
	}

	public void setTerritoiresPossedes(ArrayList<Territoire> territoiresPossedes) {
		this.territoiresPossedes = territoiresPossedes;
	}

	public ArrayList<Unite> getRenforts() {
		return renforts;
	}

	public void setRenforts(ArrayList<Unite> renforts) {
		this.renforts = renforts;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}
	

}
