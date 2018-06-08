package com.beffa.pauwels.risk;

import java.util.ArrayList;

/**
 * Classe joueur qui représente les utilisateurs Les joueurs possedents une
 * liste d'unite de renforts à placer au debut de chaque tour Ils possedent
 * aussi une liste de territoire
 * 
 * @author vince
 *
 */
public class Joueur {

	private String nom;
	private int idJoueur;

	private ArrayList<Unite> renforts = new ArrayList<Unite>();


	/**
	 * Instancie le nom et l'id des joueurs
	 * 
	 * @param nom
	 * @param idJoueur
	 */
	public Joueur(String nom, int idJoueur) {
		this.nom = nom;
		this.idJoueur = idJoueur;
	}

	
	// GETTERS ET SETTERS

	public String getNom() {
		return nom;
	}

	public int getIdJoueur() {
		return idJoueur;
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
