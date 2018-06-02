package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Risk {

	int tour = 0;
	boolean premierTour = true;

	public ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	public ArrayList<Territoire> listeTerritoires = new ArrayList<Territoire>();
	public ArrayList<Continent> listeContinents = new ArrayList<Continent>();

	public Risk() {

		creerTerritoires();

		initialisation();

		debutDesTours();

		finPartie();
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
	}

	public void initialisation() {

		attribuerTerritoire();

		tourplacementrenforts();

	}

	public void tourplacementrenforts() {

	}

	public void attribuerTerritoire() {
		Collections.shuffle(listeTerritoires);
		for (int i = 0; i < listeJoueurs.size(); i++) {
			for (int j = 0; j < listeTerritoires.size(); j++) {
				listeTerritoires.get(i).setOccupant(listeJoueurs.get(i));
				listeTerritoires.get(i).addUnite(new Unite(0));
			}
		}
	}

	public void debutDesTours() {

	}

	public void finPartie() {

	}

	// BOUTONS DE L'INTERFACE DE CONVERSION ET TRANSFERE D'UNITE
	
	// CONVERSION DUNITE
	public void ajouterSoldatRenfort(ArrayList<Unite> l) {
		for (int j = 0; j < listeJoueurs.size(); j++) {
			if (listeJoueurs.get(j).getIdJoueur() == tour) {
				l.add(new Unite(0));
			}
		}
	}

	public void echangerSoldatContreCavalier(ArrayList<Unite> l) {
		int c = 0;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getType() == 0) {
				c++;
			} else if (c >= 7) {
				Collections.sort(l, Comparator.comparing(Unite::getType));
				for (int j = 0; j < 7; j++) {
					l.remove(j);
				}
				l.add(new Unite(3));
				return;
			}
		}
	}

	public void echangerSoldatContreCanon(ArrayList<Unite> l) {
		int c = 0;
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getType() == 0) {
				c++;
			} else if (c >= 7) {
				for (int j = 0; j < 7; j++) {
					for (int h = 0; h < l.size(); h++) {
						if (l.get(h).getType() == 0) {
							l.remove(h);
						}
					}
				}
				l.add(new Unite(3));
				return;
			}
		}
	}

	public void echangerCavalierContreSoldat(ArrayList<Unite> l) {
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getType() == 1) {
				l.remove(i);
				for (int j = 0; j < 3; j++) {
					l.add(new Unite(0));
				}
				return;
			}
		}

	}

	public void echangerCanonContreSoldat(ArrayList<Unite> l) {
		for (int i = 0; i < l.size(); i++) {
			if (l.get(i).getType() == 2) {
				l.remove(i);
				for (int j = 0; j < 7; j++) {
					l.add(new Unite(0));
				}
				return;
			}
		}
	}

	// TRANSFERER UNITE DUNE LISTE A LAUTRE
	public void transfererSoldat(ArrayList<Unite> depart, ArrayList<Unite> destination) {
		for (int i = 0; i < depart.size(); i++) {
			if (depart.get(i).getType() == 0) {
				depart.remove(i);
				destination.add(new Unite(0));
				return;
			}
		}
	}

	public void transfererCavalier(ArrayList<Unite> depart, ArrayList<Unite> destination) {
		for (int i = 0; i < depart.size(); i++) {
			if (depart.get(i).getType() == 1) {
				depart.remove(i);
				destination.add(new Unite(1));
				return;
			}
		}
	}

	public void transfererCanon(ArrayList<Unite> depart, ArrayList<Unite> destination) {
		for (int i = 0; i < depart.size(); i++) {
			if (depart.get(i).getType() == 2) {
				depart.remove(i);
				destination.add(new Unite(2));
				return;
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

		this.listeTerritoires.add(new Territoire("Island", listeIS, 1)); // h1
		this.listeTerritoires.add(new Territoire("Scandinavie", listeSC, 2)); // h2
		this.listeTerritoires.add(new Territoire("Grande-Bretagne", listeGB, 3)); // h3
		this.listeTerritoires.add(new Territoire("Europe de l'Ouest", listeEO, 4)); // h4
		this.listeTerritoires.add(new Territoire("Europe du Sud", listeES, 5)); // h5
		this.listeTerritoires.add(new Territoire("Europe du Nord", listeEN, 6)); // h6
		this.listeTerritoires.add(new Territoire("Ukraine", listeUK, 7)); // h7
		this.listeTerritoires.add(new Territoire("Egypte", listeEG, 8)); // h8
		this.listeTerritoires.add(new Territoire("Afrique du Nord", listeAN, 9)); // h9
		this.listeTerritoires.add(new Territoire("Afrique de l'Est", listeAE, 10)); // h10
		this.listeTerritoires.add(new Territoire("Congo", listeCO, 11)); // h11
		this.listeTerritoires.add(new Territoire("Afrique du Sud", listeAS, 12)); // h12
		this.listeTerritoires.add(new Territoire("Madagascar", listeMA, 13)); // h13
		this.listeTerritoires.add(new Territoire("Moyen-Orient", listeMO, 14)); // h14
		this.listeTerritoires.add(new Territoire("Inde", listeIN, 15)); // h15
		this.listeTerritoires.add(new Territoire("Afganistan", listeAF, 16)); // h16
		this.listeTerritoires.add(new Territoire("Oural", listeOU, 17)); // h17
		this.listeTerritoires.add(new Territoire("Siberie", listeSIB, 18)); // h18
		this.listeTerritoires.add(new Territoire("Siam", listeSI, 19)); // h19
		this.listeTerritoires.add(new Territoire("Chine", listeCH, 20)); // h20
		this.listeTerritoires.add(new Territoire("Yakouti", listeYA, 21)); // h21
		this.listeTerritoires.add(new Territoire("Mongolie", listeMON, 22)); // h22
		this.listeTerritoires.add(new Territoire("Japon", listeJA, 23)); // h23
		this.listeTerritoires.add(new Territoire("Kamchatka", listeKA, 24)); // h24
		this.listeTerritoires.add(new Territoire("Irkutsk", listeIR, 25)); // h25
		this.listeTerritoires.add(new Territoire("Alaska", listeAL, 26)); // h26
		this.listeTerritoires.add(new Territoire("Territoires du Nord", listeTN, 27)); // h27
		this.listeTerritoires.add(new Territoire("Alberta", listeALB, 28)); // h28
		this.listeTerritoires.add(new Territoire("Ontario", listeON, 29)); // h29
		this.listeTerritoires.add(new Territoire("Groenland", listeGR, 30)); // h30
		this.listeTerritoires.add(new Territoire("Quebec", listeQU, 31)); // h31
		this.listeTerritoires.add(new Territoire("Etats de L'Ouest", listeEDO, 32)); // h32
		this.listeTerritoires.add(new Territoire("Etats de L'Est", listeEDE, 33)); // h33
		this.listeTerritoires.add(new Territoire("Amerique Centrale", listeAC, 34)); // h34
		this.listeTerritoires.add(new Territoire("Venezuela", listeVE, 35)); // h35
		this.listeTerritoires.add(new Territoire("Bresil", listeBR, 36)); // h36
		this.listeTerritoires.add(new Territoire("Perou", listePE, 37)); // h37
		this.listeTerritoires.add(new Territoire("Argentine", listeAR, 38)); // h38
		this.listeTerritoires.add(new Territoire("Indonesie", listeIND, 39)); // h39
		this.listeTerritoires.add(new Territoire("Nouvelle Guinee", listeNG, 40)); // h40
		this.listeTerritoires.add(new Territoire("Australie de l'Ouest", listeADO, 41)); // h41
		this.listeTerritoires.add(new Territoire("Australie de l'Est", listeADE, 42)); // h42

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
