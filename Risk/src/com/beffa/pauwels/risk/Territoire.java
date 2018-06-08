package com.beffa.pauwels.risk;

import java.util.ArrayList;
/**
 * Classe des territoires. Ils possedent 3 listes :
 * Unite sur le territoire
 * Unite action que l'on veut déplacer ou faire attaquer
 * Unite de bataille,qui sert à effectuer les combats
 * @author vince
 *
 */
public class Territoire {
	private String nom;
	private int id;
	private String id2;
	public String[] territoiresAdjacents;

	private Joueur occupant;
	public  ArrayList<Unite> listeUnites;
	public  ArrayList<Unite> listeUnitesAction;
	public  ArrayList<Unite> listeUnitesBataille;

	/**
	 * Constructeur de la classe territoire.
	 * @param nom
	 * @param territoiresAdjacents
	 * @param id
	 * @param id2
	 */

	public Territoire(String nom, String[] territoiresAdjacents, int id, String id2) {
		this.nom = nom;
		this.id2 = id2;
		this.id = id;
		this.territoiresAdjacents = territoiresAdjacents;


		 ArrayList<Unite> u = new ArrayList<Unite>();
		 this.listeUnites=u;
		 ArrayList<Unite> ua = new ArrayList<Unite>();
		 this.listeUnitesAction=ua;
		 ArrayList<Unite> ub = new ArrayList<Unite>();
		 this.listeUnitesBataille=ub;
			
		//Une unite de base sur tous les territoires
		listeUnites.add(new Unite(0));

	}
	
	
	// GETTERS ET SETTERS DE LA CLASSE TERRITOIRE
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

	public ArrayList<Unite> getListeUnitesAction() {
		return listeUnitesAction;

	}

	public ArrayList<Unite> getListeUnitesBataille() {
		return listeUnitesAction;

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

	public void setListeUnitesBataille(ArrayList<Unite> listeUnitesBataille) {
		this.listeUnitesBataille = listeUnitesBataille;
	}

}
