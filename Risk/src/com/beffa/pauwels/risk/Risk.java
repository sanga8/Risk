package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTextArea;

public class Risk {

	int tour = 0;
	int attribueroccupant;
	boolean premierTour = true;
	boolean peutDeplacer = false;

	public int debug = 0;

	private Territoire d;
	private Territoire a;

	public ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	public ArrayList<Territoire> listeTerritoires = new ArrayList<Territoire>();
	public ArrayList<Continent> listeContinents = new ArrayList<Continent>();

	public Risk() {
		creerTerritoires();
		// attribuerTerritoires();
		// distribuerRenfortsDebut();
		// ajoutAutoRenforts();

	}

	/**
	 * GESTION DE TOUR
	 */
	public void finDeTour() {
		tour++;
		if (tour >= listeJoueurs.size()) {
			tour = 0;
			premierTour = false;
		}
		while (listeJoueurs.get(tour) == null) {
			tour++;
			if (tour >= listeJoueurs.size()) {
				tour = 0;
			}
		}

	}

	public boolean sonTour() {
		for (int j = 0; j < listeJoueurs.size(); j++) {
			if (listeJoueurs.get(j).getIdJoueur() == tour) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public boolean renfortTermine() {
		for (int i = 0; i < listeJoueurs.size(); i++) {
			if (listeJoueurs.get(i).getIdJoueur() == tour) {
				if (listeJoueurs.get(i).getRenforts().size() == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public String changerCouleurTerritoire() {

		for (int i = 0; i < listeTerritoires.size(); i++) {
			for (int j = 0; j < listeJoueurs.size(); j++) {
				if (listeTerritoires.get(i).getOccupant().getIdJoueur() == j) {
					return ("Jeton" + j + ".png");
				}
			}
		}
		return null;
	}

	public void attribuerTerritoires() {
		ArrayList<Integer> listeTerritoiresRandom = new ArrayList<Integer>();
		for (int i = 0; i < listeTerritoires.size(); i++) {
			listeTerritoiresRandom.add(new Integer(i));
		}
		Collections.shuffle(listeTerritoiresRandom);
		int index = 0;
		for (int i = 0; i < listeTerritoires.size(); i++) {
			listeTerritoires.get(listeTerritoiresRandom.get(i)).setOccupant(listeJoueurs.get(index));

			index++;
			if (index >= this.listeJoueurs.size()) {
				index = 0;
			}
		}
	}

	public void distribuerRenfortsDebut() {
		if (listeJoueurs.size() == 2) {
			for (int i = 0; i < 19; i++) {
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
			}
		}
		if (listeJoueurs.size() == 3) {
			for (int i = 0; i < 21; i++) {
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(2).getRenforts());
			}
		}
		if (listeJoueurs.size() == 4) {
			for (int i = 0; i < 19; i++) {
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(2).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(3).getRenforts());
			}
		}
		if (listeJoueurs.size() == 5) {
			for (int i = 0; i < 16; i++) {
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(2).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(3).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(4).getRenforts());
			}
		}
		if (listeJoueurs.size() == 6) {
			for (int i = 0; i < 13; i++) {
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(2).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(3).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(4).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(5).getRenforts());
			}
		}
	}


	public void finPartie() {
		// commentaire
	}

	public void ajoutAutoRenforts() {
		for (int i = 0; i < listeJoueurs.size(); i++) {
			if (listeJoueurs.get(i).getIdJoueur() == tour) {
				for (int j = 0; j < listeJoueurs.get(i).getTerritoiresPossedes().size() / 3; j++) {
					listeJoueurs.get(i).getRenforts().add(new Unite(0));
				}
			}
		}
	}

	// BOUTONS DE L'INTERFACE DE CONVERSION ET TRANSFERE D'UNITE

	public void refreshSelection(JTextArea j) {
		j.setText("Sélectionnez deux territoires");
		d = null;
		a = null;
	}

	// CONVERSION DUNITE
	public void ajouterSoldatRenfort(ArrayList<Unite> l) {
		l.add(new Unite(0));
	}

	public void echangerSoldatContreCavalier(ArrayList<Unite> l) {
		if (sonTour() == true) {
			int c = 0;
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).getType() == 0) {
					c++;
				}
			}
			if (c >= 3) {
				l.removeIf(p -> p.getType() == 0);
				for (int h = 0; h < c - 3; h++) {
					l.add(new Unite(0));
				}
				l.add(new Unite(1));
				return;
			}
		}
	}

	public void echangerSoldatContreCanon(ArrayList<Unite> l) {
		if (sonTour() == true) {
			int c = 0;
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).getType() == 0) {
					c++;
				}
			}
			if (c >= 7) {
				l.removeIf(p -> p.getType() == 0);
				for (int h = 0; h < c - 7; h++) {
					l.add(new Unite(0));
				}
				l.add(new Unite(2));
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

	// TRANSFERER UNITE DUNE LISTE DES RENFORTS A LA LISTE D'UNITE DU TERRITOIRE
	// SELECTIONNE
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

	// DEPLACEMENT DE TROUPES
	public void deplacer(Territoire depart, Territoire destination) {
		if (peutDeplacer == true) {
			while (depart.getListeUnitesAction().size() > 0) {
				for (int i = 0; i < depart.getListeUnitesAction().size(); i++) {
					if (depart.getListeUnitesAction().get(i).getType() == 0) {
						depart.getListeUnitesAction().remove(i);
						destination.listeUnites.add(new Unite(0));
					}
					if (depart.getListeUnitesAction().get(i).getType() == 1) {
						depart.getListeUnitesAction().remove(i);
						destination.listeUnites.add(new Unite(1));
					}
					if (depart.getListeUnitesAction().get(i).getType() == 2) {
						depart.getListeUnitesAction().remove(i);
						destination.listeUnites.add(new Unite(2));
					}
				}
			}
		}
	}

	public boolean peutDeplacer(Territoire depart, Territoire destination) {
		for (int i = 0; i < depart.getTerritoiresAdjacents().length; i++) {
			if (depart.territoiresAdjacents[i].equals(destination.getNom())) {
				if (depart.getOccupant().getIdJoueur() == destination.getOccupant().getIdJoueur()) {
					peutDeplacer = true;
					return peutDeplacer = true;
				}
			}
		}
		peutDeplacer = false;
		return peutDeplacer = false;
	}
	
	
	
	

	public void deplacerSoldat(Territoire depart, Territoire destination) {
		int c = 0;
		for (int i = 0; i < depart.listeUnites.size(); i++) {
			if (depart.listeUnites.get(i).getType() == 0) {
				c++;
			}
		}
		depart.listeUnites.removeIf(p -> p.getType() == 0);
		for (int h = 0; h < c - 1; h++) {
			depart.listeUnites.add(new Unite(0));
		}
		destination.listeUnites.add(new Unite(0));
		return;
	}

	public void deplacerCavalier(Territoire depart, Territoire destination) {

	}

	public void deplacerCanon(Territoire depart, Territoire destination) {

	}

	public int nbTerritoirePossede(Joueur joueur) {
		int conteur = 0;
		for (int i = 0; i < listeTerritoires.size(); i++) {
			if (listeTerritoires.get(i).getOccupant().getIdJoueur() == joueur.getIdJoueur()) {
				conteur++;
			}
		}
		return conteur;

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

		this.listeTerritoires.add(new Territoire("Island", listeIS, 0, "0")); // h1
		this.listeTerritoires.add(new Territoire("Scandinavie", listeSC, 1, "1")); // h2
		this.listeTerritoires.add(new Territoire("Grande-Bretagne", listeGB, 2, "2")); // h3
		this.listeTerritoires.add(new Territoire("Europe de l'Ouest", listeEO, 3, "3")); // h4
		this.listeTerritoires.add(new Territoire("Europe du Sud", listeES, 4, "4")); // h5
		this.listeTerritoires.add(new Territoire("Europe du Nord", listeEN, 5, "5")); // h6
		this.listeTerritoires.add(new Territoire("Ukraine", listeUK, 6, "6")); // h7
		this.listeTerritoires.add(new Territoire("Egypte", listeEG, 7, "7")); // h8
		this.listeTerritoires.add(new Territoire("Afrique du Nord", listeAN, 8, "8")); // h9
		this.listeTerritoires.add(new Territoire("Afrique de l'Est", listeAE, 9, "9")); // h10
		this.listeTerritoires.add(new Territoire("Congo", listeCO, 10, "10")); // h11
		this.listeTerritoires.add(new Territoire("Afrique du Sud", listeAS, 11, "11")); // h12
		this.listeTerritoires.add(new Territoire("Madagascar", listeMA, 12, "12")); // h13
		this.listeTerritoires.add(new Territoire("Moyen-Orient", listeMO, 13, "13")); // h14
		this.listeTerritoires.add(new Territoire("Inde", listeIN, 14, "14")); // h15
		this.listeTerritoires.add(new Territoire("Afganistan", listeAF, 15, "15")); // h16
		this.listeTerritoires.add(new Territoire("Oural", listeOU, 16, "16")); // h17
		this.listeTerritoires.add(new Territoire("Siberie", listeSIB, 17, "17")); // h18
		this.listeTerritoires.add(new Territoire("Siam", listeSI, 18, "18")); // h19
		this.listeTerritoires.add(new Territoire("Chine", listeCH, 19, "19")); // h20
		this.listeTerritoires.add(new Territoire("Yakouti", listeYA, 20, "20")); // h21
		this.listeTerritoires.add(new Territoire("Mongolie", listeMON, 21, "21")); // h22
		this.listeTerritoires.add(new Territoire("Japon", listeJA, 22, "22")); // h23
		this.listeTerritoires.add(new Territoire("Kamchatka", listeKA, 23, "23")); // h24
		this.listeTerritoires.add(new Territoire("Irkutsk", listeIR, 24, "24")); // h25
		this.listeTerritoires.add(new Territoire("Alaska", listeAL, 25, "25")); // h26
		this.listeTerritoires.add(new Territoire("Territoires du Nord", listeTN, 26, "26")); // h27
		this.listeTerritoires.add(new Territoire("Alberta", listeALB, 27, "27")); // h28
		this.listeTerritoires.add(new Territoire("Ontario", listeON, 28, "28")); // h29
		this.listeTerritoires.add(new Territoire("Groenland", listeGR, 29, "29")); // h30
		this.listeTerritoires.add(new Territoire("Quebec", listeQU, 30, "30")); // h31
		this.listeTerritoires.add(new Territoire("Etats de L'Ouest", listeEDO, 31, "31")); // h32
		this.listeTerritoires.add(new Territoire("Etats de L'Est", listeEDE, 32, "32")); // h33
		this.listeTerritoires.add(new Territoire("Amerique Centrale", listeAC, 33, "33")); // h34
		this.listeTerritoires.add(new Territoire("Venezuela", listeVE, 34, "34")); // h35
		this.listeTerritoires.add(new Territoire("Bresil", listeBR, 35, "35")); // h36
		this.listeTerritoires.add(new Territoire("Perou", listePE, 36, "36")); // h37
		this.listeTerritoires.add(new Territoire("Argentine", listeAR, 37, "37")); // h38
		this.listeTerritoires.add(new Territoire("Indonesie", listeIND, 38, "38")); // h39
		this.listeTerritoires.add(new Territoire("Nouvelle Guinee", listeNG, 39, "39")); // h40
		this.listeTerritoires.add(new Territoire("Australie de l'Ouest", listeADO, 40, "40")); // h41
		this.listeTerritoires.add(new Territoire("Australie de l'Est", listeADE, 41, "41")); // h42

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

	public Territoire getD() {
		return d;
	}

	public void setD(Territoire d) {
		this.d = d;
	}

	public Territoire getA() {
		return a;
	}

	public void setA(Territoire a) {
		this.a = a;
	}

}
