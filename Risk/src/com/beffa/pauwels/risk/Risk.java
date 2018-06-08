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

	private Territoire d;
	private Territoire a;

	public ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
	public ArrayList<Territoire> listeTerritoires = new ArrayList<Territoire>();

	public Risk() {
		creerTerritoires();	//Creer la liste de Territoires

	}
	/**
	 * Attribue les territoires à chaques joueurs au début de la partie
	 */
	public void attribuerTerritoires() {
		ArrayList<Integer> listeTerritoiresRandom = new ArrayList<Integer>();
		for (int i = 0; i < listeTerritoires.size(); i++) {
			listeTerritoiresRandom.add(new Integer(i)); //On créé une liste cloné de la liste de territoires
		}
		Collections.shuffle(listeTerritoiresRandom);	//On mélange la liste cloné
		int index = 0;
		for (int i = 0; i < listeTerritoires.size(); i++) {
			listeTerritoires.get(listeTerritoiresRandom.get(i)).setOccupant(listeJoueurs.get(index));	//On attribu un occupant à chaque territoire

			index++;
			if (index >= this.listeJoueurs.size()) {
				index = 0;
			}
		}
	}

	/**
	 * Methode appelé lorsqu'on appuye sur le bouton fin de tour
	 */
	public void finDeTour() {
		verifVictoire();		//On vérifie si un joueur n'a pas gagné
		tour++;					//On itére le tour
		majMouvement();			//On remet aux troupes leurs nombre correcte de points de mouvement
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
	/**
	 * Méthode qui vérifie si un joueur n'a pas gagné
	 */
	public void verifVictoire() {
		int counter = 0;
		for (int i = 0; i < listeJoueurs.size(); i++) {
			if (listeJoueurs.get(i).getIdJoueur() == tour) {
				for (int j = 0; j < listeTerritoires.size(); j++) {
					if (listeTerritoires.get(j).getOccupant().getIdJoueur() == listeJoueurs.get(i).getIdJoueur()) {
						counter++;			//On ajoute +1 au counter à chaque fois qu'un même joueur countrole un territoire
					}
					if (counter == 42) {	//Si un joueur possède 42 territoires, il gagne la partie
						System.out.println("Joueur " + listeJoueurs.get(i).getIdJoueur() + " a gagné");
						System.exit(0);
					}
				}
			}
		}

	}
	/**
	 * Pour chaque Unite dans chaque territoire, on remet au bon chiffre leurs nombre de points de mouvements.
	 */
	public void majMouvement() {
		for (int i = 0; i < listeTerritoires.size(); i++) {
			for (int j = 0; j < listeTerritoires.get(i).getListeUnites().size(); j++) {
				if (listeTerritoires.get(i).getListeUnites().get(j).getType() == 0) {
					listeTerritoires.get(i).getListeUnites().get(j).setMouvement(2);
					if (listeTerritoires.get(i).getListeUnites().get(j).getType() == 1) {
						listeTerritoires.get(i).getListeUnites().get(j).setMouvement(3);
						if (listeTerritoires.get(i).getListeUnites().get(j).getType() == 2) {
							listeTerritoires.get(i).getListeUnites().get(j).setMouvement(1);
						}
					}
				}
			}
		}
	}
	/**
	 * Methode qui renvoie true si c'est le bien au tour du joueur en cours
	 * @return
	 */
	public boolean sonTour() {
		for (int i = 0; i < listeJoueurs.size(); i++) {
			if (listeJoueurs.get(i).getIdJoueur() == tour) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Methode qui renvoie true s'il n'y a plus de renforts à placer
	 * @return
	 */
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

	/**
	 * Change la couleur de la pastille du territoire
	 * @return
	 */
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

	/**
	 * Distribue un nombre fixe de renforts selon le nombre de joueurs
	 */
	public void distribuerRenfortsDebut() {
		if (listeJoueurs.size() == 2) {		
			for (int i = 0; i < 19; i++) {		//19 renforts par joueurs pour 2 joueurs
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
			}
		}
		if (listeJoueurs.size() == 3) {
			for (int i = 0; i < 21; i++) {		//21 renforts par joueur pour 3 joueurs
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(2).getRenforts());
			}
		}
		if (listeJoueurs.size() == 4) {
			for (int i = 0; i < 19; i++) {		//19 renforts par joueur pour 4 joueurs
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(2).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(3).getRenforts());
			}
		}
		if (listeJoueurs.size() == 5) {
			for (int i = 0; i < 16; i++) {		//16 renforts par joueur pour 5 joueurs
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(2).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(3).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(4).getRenforts());
			}
		}
		if (listeJoueurs.size() == 6) {
			for (int i = 0; i < 13; i++) {		//13 renforts par joueur pour 6 joueurs
				ajouterSoldatRenfort(listeJoueurs.get(0).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(1).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(2).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(3).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(4).getRenforts());
				ajouterSoldatRenfort(listeJoueurs.get(5).getRenforts());
			}
		}
	}
	/**
	 * Cette méthode rajoute à chaque joueur les renforts qu'ils en mérite méritent
	 */
	public void ajoutAutoRenforts() {
		int counter = 0;
		if (premierTour == false) {		//On ne fait pas le calcul et le rajout au premier tour (les renforts sont fixes au premier tour)
			for (int i = 0; i < listeJoueurs.size(); i++) {
				if (listeJoueurs.get(i).getIdJoueur() == tour) {
					for (int j = 0; j < listeTerritoires.size(); j++) {
						if (listeTerritoires.get(j).getOccupant().getIdJoueur() == listeJoueurs.get(i).getIdJoueur()) {
							counter++; 	//Counter du nombre de territoires appartenant à un même joueur
						}
					}
				}
				System.out.println(counter);
				for (int k = 0; k < counter / 3; k++) {
					listeJoueurs.get(i).getRenforts().add(new Unite(0));	//On ajoute 1 renfort pour 3 territoires possédés
				}
				counter = 0;
			}
		}
	}

	// BOUTONS DE L'INTERFACE DE CONVERSION ET TRANSFERE D'UNITE

	/**
	 * Cette méthode remet la sélection des territoires à 0
	 * @param j
	 */
	public void refreshSelection(JTextArea j) {
		j.setText("Sélectionnez deux territoires");
		d = null;
		a = null;
	}

	// CONVERSION DUNITE
	/**
	 * Méthode ajoutant un soldat aux renforts
	 * @param l
	 */
	public void ajouterSoldatRenfort(ArrayList<Unite> l) {
		l.add(new Unite(0));
	}
	/**
	 * Permet d'échanger un soldat contre un cavalier
	 * @param l
	 */
	public void echangerSoldatContreCavalier(ArrayList<Unite> l) {
		if (sonTour() == true) {
			int c = 0;
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).getType() == 0) {
					c++;
				}
			}
			if (c >= 3) {		//Un cavalier coûte 3 soldats
				l.removeIf(p -> p.getType() == 0);
				for (int h = 0; h < c - 3; h++) {
					l.add(new Unite(0));
				}
				l.add(new Unite(1));
				return;
			}
		}
	}

	/**
	 * Permet d'échanger un soldat contre un canon
	 * @param l
	 */
	public void echangerSoldatContreCanon(ArrayList<Unite> l) {
		if (sonTour() == true) {	//On vérifie c'est c'est au tour du bon joueur
			int c = 0;
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).getType() == 0) {
					c++;
				}
			}
			if (c >= 7) {	//Un canon coûte 7 soldats
				l.removeIf(p -> p.getType() == 0);
				for (int h = 0; h < c - 7; h++) {
					l.add(new Unite(0));
				}
				l.add(new Unite(2));
				return;
			}
		}
	}
	
	/**
	 * Permet d'échanger un cavalier contre un soldat
	 * @param l
	 */
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

	/**
	 * Permet d'échanger un canon contre un soldat
	 * @param l
	 */
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

	// TRANSFERER UNITE DUNE LISTE DES RENFORTS A LA LISTE D'UNITE DU TERRITOIRE ELECTIONNE
	
	/**
	 * Méthode transférant un soldat d'une liste de départ à une liste d'arrivé
	 * @param depart
	 * @param destination
	 */
	public void transfererSoldat(ArrayList<Unite> depart, ArrayList<Unite> destination) {
		for (int i = 0; i < depart.size(); i++) {
			if (depart.get(i).getType() == 0) {	//Si c'est un soldat et que l'unité a asser de points de mouvements
				Unite unite = depart.get(i);
				destination.add(unite);
				depart.remove(i);
				return;
			}
		}
	}

	/**
	 * Méthode transférant un cavalier d'une liste de départ à une liste d'arrivé
	 * @param depart
	 * @param destination
	 */
	public void transfererCavalier(ArrayList<Unite> depart, ArrayList<Unite> destination) {
		for (int i = 0; i < depart.size(); i++) {
			if (depart.get(i).getType() == 1) {
				Unite unite = depart.get(i);
				destination.add(unite);
				depart.remove(i);
				return;
			}
		}
	}

	/**
	 * Méthode transférant un canon d'une liste de départ à une liste d'arrivé
	 * @param depart
	 * @param destination
	 */
	public void transfererCanon(ArrayList<Unite> depart, ArrayList<Unite> destination) {
		for (int i = 0; i < depart.size(); i++) {
			if (depart.get(i).getType() == 2) {
				Unite unite = depart.get(i);
				destination.add(unite);
				depart.remove(i);
				return;
			}
		}
	}

	/**
	 * 
	 * @param depart
	 * @param destination
	 */
	public void transfererSoldatAction(ArrayList<Unite> depart, ArrayList<Unite> destination) {
		for (int i = 0; i < depart.size(); i++) {
			if (depart.get(i).getType() == 0 && peutMouvement(depart)) {
				Unite unite = depart.get(i);
				destination.add(unite);
				depart.remove(i);
				return;
			}
		}
	}

	public void transfererCavalierAction(ArrayList<Unite> depart, ArrayList<Unite> destination) {
		for (int i = 0; i < depart.size(); i++) {
			if (depart.get(i).getType() == 1 && peutMouvement(depart)) {
				System.out.println("Point de mouvement des cavaliers :" + depart.get(i).getMouvement());
				Unite unite = depart.get(i);
				destination.add(unite);
				depart.remove(i);
				return;
			}
		}
	}

	public void transfererCanonAction(ArrayList<Unite> depart, ArrayList<Unite> destination) {
		for (int i = 0; i < depart.size(); i++) {
			if (depart.get(i).getType() == 2 && peutMouvement(depart)) {
				System.out.println("Point de mouvement des canons :" + depart.get(i).getMouvement());
				Unite unite = depart.get(i);
				destination.add(unite);
				depart.remove(i);
				return;
			}
		}
	}

	// DEPLACEMENT DE TROUPES
	/**
	 * Cette méthode déplace une liste d'unité d'un territoire départ à une destination
	 * @param depart
	 * @param destination
	 */
	public void deplacer(Territoire depart, Territoire destination) {

		if (peutDeplacer(depart, destination) == true) {	//Vérifie si l'on peut déplace de ce départ à cette destination
			for (int j = 0; j < depart.getListeUnitesAction().size(); j++) {
				depart.getListeUnitesAction().get(j).setMouvement(depart.getListeUnitesAction().get(j).getMouvement() - 1);		//L'unite perd un point de mouvement
			}
			destination.listeUnites.addAll(depart.listeUnitesAction);
			depart.listeUnitesAction.clear();
		}
	}

	/**
	 * Return true si l'on peut déplacer de départ à destination
	 * @param depart
	 * @param destination
	 * @return
	 */
	public boolean peutDeplacer(Territoire depart, Territoire destination) {
		for (int i = 0; i < depart.getTerritoiresAdjacents().length; i++) {
			if (depart.territoiresAdjacents[i].equals(destination.getNom())) {							//Si les territoires sont adjacents
				if (depart.getOccupant().getIdJoueur() == destination.getOccupant().getIdJoueur()) {	//Si les territoires appartiennent bien au joueur
					return true;
				}
			}
		}
		return false;
	}
	// CONDITION DEPLACEMENT
	/**
	 * Return true s'il reste des points de mouvement à une unité
	 * @param liste
	 * @return
	 */
	public boolean peutMouvement(ArrayList<Unite> liste) {
		for (int i = 0; i < liste.size(); i++) {
			if (liste.get(i).getMouvement() > 0) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return true si l'on peut attaquer la destination depuis le départ
	 * @param depart
	 * @param destination
	 * @return
	 */
	public boolean peutAttaquer(Territoire depart, Territoire destination) {
		for (int i = 0; i < depart.getTerritoiresAdjacents().length; i++) {
			if (depart.territoiresAdjacents[i].equals(destination.getNom())) {	//Si les territoires sont adjacents
				if (depart.getOccupant().getIdJoueur() != destination.getOccupant().getIdJoueur()) { ///Si le territoire destination appartient à un adversaire
					return true;
				}
			}
		}
		return true;
	}

	/**
	 * Renvoie un entier correstpondant au nombre de territoires possédés par le joueur entré en argument
	 * @param joueur
	 * @return
	 */
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
		String[] listeON = { "Territoires du Nord", "Alberta", "Etats de L'Ouest", "Etats de L'Est", "Quebec","Groenland" };
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
