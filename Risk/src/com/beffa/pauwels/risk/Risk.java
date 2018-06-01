package com.beffa.pauwels.risk;

import java.util.ArrayList;

public class Risk {

	int tour = 0;

	public ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();

	public ArrayList<Territoire> listeTerritoires = new ArrayList<Territoire>();
	public ArrayList<Continent> listeContinents = new ArrayList<Continent>();

	public Risk() {
		Menu menu = new Menu();
	}

	/**
	 * GESTION DE TOUR
	 */
	public void finDeTour() {
		tour++;
		if (tour >= listeJoueurs.size()) {
			tour = 0;
		}
		while (listeJoueurs.get(tour) == null) {
			tour++;
			if (tour >= listeJoueurs.size()) {
				tour = 0;
			}
		}
		System.out.println("Tour du joueur" + tour);
	}
	
	public void initialisation(){	
		attribuerTerritoire();
		

	}

	public void attribuerTerritoire() {
		for (int i = 0; i < listeJoueurs.size(); i++) {
			for (int j = 0; j < listeTerritoires.size(); j++) {
				listeTerritoires.get(i).setOccupant(listeJoueurs.get(i));
				listeTerritoires.get(i).addUnite(new Unite(0));
			}
		}
	}

	// Methode avec l'aide d'Eliot Sadrin
	// Création de territoire
	public void creerTerritoires() {
		// Territoires adjacents
		String[] listeIS = { "Scandinavie", "Grande-Bretagne", "Groenland" };
		String[] listeSC = { "Island", "Grande-Bretagne", "Ukraine", "Europe du Nord" };
		String[] listeGB = { "Island", "Scandinavie", "Europe de l'Ouest", "Europe du Nord" };
		String[] listeEO = { "Grande-Bretagne", "Europe du Nord", "Europe du Sud" };
		String[] listeES = { "Europe de l'Ouest", "Europe du Nord", "Ukraine", "Egypte", "Afrique du Nord" };
		String[] listeEN = { "Grande-Bretagne", "Ukraine", "Europe de l'Ouest", "Europe du Sud", "Scandinavie" };
		String[] listeUK = { "Scandinavie", "Europe du Nord", "Europe du Sud", "Oural", "Afganistan", "Moyen-Orient" };
		String[] listeEG = { "Afrique de l'Est", "Afrique du Nord", "Moyen-Orient", "Europe du Sud" };
		String[] listeAN = { "Europe de l'Ouest", "Europe du Sud", "Egypte", "Bresil", "Congo", "Afrique de l'Est" };
		String[] listeAE = { "Egypte", "Moyen-Orient", "Afrique du Nord", "Congo", "Afrique du Sud", "Madagascar" };
		String[] listeCO = { "Egypte", "Afrique du Nord", "Afrique du Sud", "Afrique de l'Est" };
		String[] listeMA = { "Afrique de l'Est", "Afrique du Sud" };
		String[] listeAS = { "Congo", "Afrique de l'Est", "Madagascar" };
		String[] listeMO = { "Egypte", "Afrique de l'Est", "Ukraine", "Europe du Sud", "Afganistan", "Inde" };
		String[] listeIN = { "Moyen-Orient", "Afganistan", "Chine", "Siam" };
		String[] listeAF = { "Ukraine", "Moyen-Orient", "Inde", "Oural", "Chine" };
		String[] listeOU = { "Chine", "Afganistan", "Ukraine", "Siberie" };
		String[] listeSIB = { "Mongolie", "Chine", "Oural", "Irkutsk", "Yakouti" };
		String[] listeSI = { "Inde", "Chine", "Indonesie" };
		String[] listeCH = { "Siberie", "Inde", "Afganistan", "Oural", "Siam", "Mongolie" };
		String[] listeYA = { "Kamchatka", "Irkutsk", "Siberie" };
		String[] listeMON = { "Siberie", "Chine", "Irkutsk", "Kamchatka", "Japon" };
		String[] listeJA = { "Kamchatka", "Mongolie" };
		String[] listeKA = { "Irkutsk", "Yakouti", "Mongolie", "Japon", "Alaska" };
		String[] listeIR = { "Mongolie", "Kamchatka", "Yakouti", "Siberie" };
		String[] listeAL = { "Kamchatka", "Alberta", "Territoires du Nord" };
		String[] listeTN = { "Ontario", "Alberta", "Alaska", "Groenland" };
		String[] listeALB = { "Alaska", "Territoires du Nord", "Ontario", "Etats de L'Ouest" };
		String[] listeON = { "Territoires du Nord", "Alberta", "Etats de L'Ouest", "Etats de L'Est", "Quebec",
				"Groenland" };
		String[] listeGR = { "Ontario", "Territoires du Nord", "Quebec", "Island" };
		String[] listeQU = { "Etats de L'Est", "Ontario", "Groenland" };
		String[] listeEDO = { "Etats de L'Est", "Amerique Centrale", "Ontario", "Alberta" };
		String[] listeEDE = { "Etats de L'Ouest", "Amerique Centrale", "Ontario", "Quebec" };
		String[] listeAC = { "Venezuela", "Etats de L'Est", "Etats de L'Ouest" };
		String[] listeVE = { "Amerique Centrale", "Perou", "Bresil" };
		String[] listeBR = { "Argentine", "Afrique du Nord", "Perou", "Venezuela" };
		String[] listePE = { "Argentine", "Bresil", "Venezuela" };
		String[] listeAR = { "Perou", "Bresil" };
		String[] listeIND = { "Nouvelle Guinee", "Siam", "Australie de l'Ouest" };
		String[] listeNG = { "Indonesie", "Australie de l'Ouest", "Australie de l'Est" };
		String[] listeADO = { "Australie de l'Est", "Nouvelle Guinee", "Indonesie" };
		String[] listeADE = { "Australie de l'Ouest", "Nouvelle Guinee" };

		// Territoires

		this.listeTerritoires.add(new Territoire("Island", listeIS));
		this.listeTerritoires.add(new Territoire("Scandinavie", listeSC));
		this.listeTerritoires.add(new Territoire("Grande-Bretagne", listeGB));
		this.listeTerritoires.add(new Territoire("Europe de l'Ouest", listeEO));
		this.listeTerritoires.add(new Territoire("Europe du Sud", listeES));
		this.listeTerritoires.add(new Territoire("Europe du Nord", listeEN));
		this.listeTerritoires.add(new Territoire("Ukraine", listeUK));
		this.listeTerritoires.add(new Territoire("Egypte", listeEG));
		this.listeTerritoires.add(new Territoire("Afrique du Nord", listeAN));
		this.listeTerritoires.add(new Territoire("Afrique de l'Est", listeAE));
		this.listeTerritoires.add(new Territoire("Congo", listeCO));
		this.listeTerritoires.add(new Territoire("Afrique du Sud", listeAS));
		this.listeTerritoires.add(new Territoire("Madagascar", listeMA));
		this.listeTerritoires.add(new Territoire("Moyen-Orient", listeMO));
		this.listeTerritoires.add(new Territoire("Inde", listeIN));
		this.listeTerritoires.add(new Territoire("Afganistan", listeAF));
		this.listeTerritoires.add(new Territoire("Oural", listeOU));
		this.listeTerritoires.add(new Territoire("Siberie", listeSIB));
		this.listeTerritoires.add(new Territoire("Siam", listeSI));
		this.listeTerritoires.add(new Territoire("Chine", listeCH));
		this.listeTerritoires.add(new Territoire("Yakouti", listeYA));
		this.listeTerritoires.add(new Territoire("Mongolie", listeMON));
		this.listeTerritoires.add(new Territoire("Japon", listeJA));
		this.listeTerritoires.add(new Territoire("Kamchatka", listeKA));
		this.listeTerritoires.add(new Territoire("Irkutsk", listeIR));
		this.listeTerritoires.add(new Territoire("Alaska", listeAL));
		this.listeTerritoires.add(new Territoire("Territoires du Nord", listeTN));
		this.listeTerritoires.add(new Territoire("Alberta", listeALB));
		this.listeTerritoires.add(new Territoire("Ontario", listeON));
		this.listeTerritoires.add(new Territoire("Groenland", listeGR));
		this.listeTerritoires.add(new Territoire("Quebec", listeQU));
		this.listeTerritoires.add(new Territoire("Etats de L'Ouest", listeEDO));
		this.listeTerritoires.add(new Territoire("Etats de L'Est", listeEDE));
		this.listeTerritoires.add(new Territoire("Amerique Centrale", listeAC));
		this.listeTerritoires.add(new Territoire("Venezuela", listeVE));
		this.listeTerritoires.add(new Territoire("Bresil", listeBR));
		this.listeTerritoires.add(new Territoire("Perou", listePE));
		this.listeTerritoires.add(new Territoire("Argentine", listeAR));
		this.listeTerritoires.add(new Territoire("Indonesie", listeIND));
		this.listeTerritoires.add(new Territoire("Nouvelle Guinee", listeNG));
		this.listeTerritoires.add(new Territoire("Australie de l'Ouest", listeADO));
		this.listeTerritoires.add(new Territoire("Australie de l'Est", listeADE));

		// Continents
		ArrayList<Territoire> c1 = new ArrayList<Territoire>();
		for (int i = 0; i < 7; i++) {
			c1.add(this.listeTerritoires.get(i));
		}

		ArrayList<Territoire> c2 = new ArrayList<Territoire>();
		for (int i = 7; i < 13; i++) {
			c2.add(this.listeTerritoires.get(i));
		}

		ArrayList<Territoire> c3 = new ArrayList<Territoire>();
		for (int i = 13; i < 25; i++) {
			c3.add(this.listeTerritoires.get(i));
		}

		ArrayList<Territoire> c4 = new ArrayList<Territoire>();
		for (int i = 25; i < 34; i++) {
			c4.add(this.listeTerritoires.get(i));
		}

		ArrayList<Territoire> c5 = new ArrayList<Territoire>();
		for (int i = 34; i < 38; i++) {
			c5.add(this.listeTerritoires.get(i));
		}

		ArrayList<Territoire> c6 = new ArrayList<Territoire>();
		for (int i = 38; i < 42; i++) {
			c6.add(this.listeTerritoires.get(i));
		}

		this.listeContinents.add(new Continent(0, c1));// Europe
		this.listeContinents.add(new Continent(1, c2));// Afrique
		this.listeContinents.add(new Continent(2, c3));// Asie
		this.listeContinents.add(new Continent(3, c4));// Amerique du Nord
		this.listeContinents.add(new Continent(4, c5));// Amerique du Sud
		this.listeContinents.add(new Continent(5, c6));// Oceanie

	}

}
