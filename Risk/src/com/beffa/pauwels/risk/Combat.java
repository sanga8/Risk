package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Combat {

	ArrayList<Unite> uniteBatailleATT = new ArrayList<Unite>();
	ArrayList<Unite> uniteBatailleDEF = new ArrayList<Unite>();

	ArrayList<Territoire> listeGagnant = new ArrayList<Territoire>();

	int resultatDe;

	public Combat() {
	}

	// METTRE ARMEE TERRITOIRE DANS ARMEE COMBAT

	public void prendreSoldatATT(Territoire p) {
		int count = 0;
		for (int i = 0; i < p.getListeUnites().size(); i++) {
			if (p.getListeUnites().get(i).getType() == 0 && count == 0 && p.getListeUnites().size() > 0) {
				uniteBatailleATT.add(p.getListeUnites().get(i));
				p.getListeUnites().remove(i);
				count++;
			}
		}
	}

	public void prendreCavalierATT(Territoire p) {
		int count = 0;
		for (int i = 0; i < p.getListeUnites().size(); i++) {
			if (p.getListeUnites().get(i).getType() == 1 && count == 0 && p.getListeUnites().size() > 0) {
				uniteBatailleATT.add(p.getListeUnites().get(i));
				p.getListeUnites().remove(i);
				count++;
			}
		}
	}

	public void prendreCanonATT(Territoire p) {
		int count = 0;
		for (int i = 0; i < p.getListeUnites().size(); i++) {
			if (p.getListeUnites().get(i).getType() == 2 && count == 0 && p.getListeUnites().size() > 0) {
				uniteBatailleATT.add(p.getListeUnites().get(i));
				p.getListeUnites().remove(i);
				count++;
			}
		}
	}

	public void lanceDe(ArrayList<Unite> liste) {
		for (int i = 0; i < liste.size(); i++) {
			liste.get(i).setResultatDe((int) (Math.random() * 6 + liste.get(i).getPuissance()));
			System.out.println("Resultats des " + liste.get(i).getResultatDe());
		}
	}

	public void trierATT(ArrayList<Unite> liste) {
		Collections.sort(liste, Comparator.comparing(Unite::getResultatDe));
		Collections.reverse(liste);

		for (int i = 0; i < liste.size() - 1; i++) {
			if (liste.get(i).getResultatDe() == liste.get(i + 1).getResultatDe() && liste.get(i).getPrioriteATT() > liste.get(i + 1).getPrioriteATT()) {
				Collections.swap(liste, i, i + 1);
			}
			if (liste.size() == 3) {
				// EXCEPTION SI LES TROIS ONT LE MEME RESULTAT DE
				if (liste.get(0).getResultatDe() == liste.get(1).getResultatDe() && liste.get(1).getResultatDe() == liste.get(2).getResultatDe()) {
					Collections.sort(liste, Comparator.comparing(Unite::getPrioriteATT));
				}
			}
		}
	}

	public void choisirDEF(Territoire tDEF, ArrayList<Unite> uniteBatailleDEF) {

		Collections.sort(tDEF.listeUnites, Comparator.comparing(Unite::getPrioriteDEF));
		if (tDEF.listeUnites.size() > 1) {
			System.out.println("Plusieurs unites en defense");
			for (int i = 0; i < 2; i++) {

				if (tDEF.listeUnites.get(i).getType() == 0) {
					tDEF.listeUnites.remove(i);
					uniteBatailleDEF.add(new Unite(0));
				}

				if (tDEF.listeUnites.get(i).getType() == 1) {
					tDEF.listeUnites.remove(i);
					uniteBatailleDEF.add(new Unite(1));
				}

				if (tDEF.listeUnites.get(i).getType() == 2) {
					tDEF.listeUnites.remove(i);
					uniteBatailleDEF.add(new Unite(2));
				}
			}
		}
		if (tDEF.listeUnites.size() == 1) {
			System.out.println("Une seule unite en defense");
			if (tDEF.listeUnites.get(0).getType() == 0) {
				tDEF.listeUnites.remove(0);
				uniteBatailleDEF.add(new Unite(0));
			}

			if (tDEF.listeUnites.get(0).getType() == 1) {
				tDEF.listeUnites.remove(0);
				uniteBatailleDEF.add(new Unite(1));
			}

			if (tDEF.listeUnites.get(0).getType() == 2) {
				tDEF.listeUnites.remove(0);
				uniteBatailleDEF.add(new Unite(2));
			}
		}
	}

	public void trierDEF(ArrayList<Unite> liste) {
		if (liste.size() > 1) {
			if (liste.get(0).getResultatDe() < liste.get(1).getResultatDe()) {
				Collections.swap(liste, 0, 1);
			}
		}
	}

	public void resoudre(ArrayList<Unite> listeATT, ArrayList<Unite> listeDEF) {

		if (listeDEF.size() <= listeATT.size()) {

			for (int i = 0; i < listeDEF.size(); i++) {
				if (listeDEF.get(i).getResultatDe() >= listeATT.get(i).getResultatDe()) {
					listeATT.remove(i);
				} else {
					listeDEF.remove(i);
				}
			}

			if (listeATT.size() < listeDEF.size()) {
				for (int i = 0; i < listeATT.size(); i++) {
					if (listeDEF.get(i).getResultatDe() < listeATT.get(i).getResultatDe()) {
						listeDEF.remove(i);
					} else {
						listeATT.remove(i);
					}
				}
			}
		}
	}


	public void majCombat(Territoire tATT, Territoire tDEF) {
		uniteBatailleATT.addAll(tATT.getListeUnites());
		uniteBatailleATT.clear();
		
		uniteBatailleDEF.addAll(tDEF.getListeUnites());
		uniteBatailleATT.clear();
	
	}

	public void majOccupant(Territoire tATT, Territoire tDEF) {
		if (tDEF.listeUnites.size() == 0) {
			tDEF.setOccupant(tATT.getOccupant());

			for (int i = 0; i < uniteBatailleATT.size(); i++) {

				if (uniteBatailleATT.get(i).getType() == 0) {

					tDEF.listeUnites.add(new Unite(0));
				}
				if (uniteBatailleATT.get(i).getType() == 1) {

					tDEF.listeUnites.add(new Unite(1));
				}
				if (uniteBatailleATT.get(i).getType() == 2) {

					tDEF.listeUnites.add(new Unite(2));
				}
			}
		}
	}

	public void resetCombat(ArrayList<Unite> listeATT, ArrayList<Unite> listeDEF) {

		int a = listeATT.size();
		
		for (int i = 0; i < a; i++) {
			listeATT.remove(0);
		}

		for (int i = 0; i < listeDEF.size(); i++) {
			listeDEF.remove(i);
		}
	}

	// COMBATTRE
	public void combattre(Territoire tATT, Territoire tDEF) {
		/*
		 * choisir unités défenses lancer les dés trier les dés trier par prio
		 * d'atq déterminer résultats mettre à jour les occupants et armées sur
		 * les territoires réinitialiser les combats
		 */


		choisirDEF(tDEF, uniteBatailleDEF);


		lanceDe(uniteBatailleATT);
		lanceDe(uniteBatailleDEF);


		trierATT(uniteBatailleATT);
		trierDEF(uniteBatailleDEF);

		resoudre(uniteBatailleATT, uniteBatailleDEF);
		resoudre(uniteBatailleATT, uniteBatailleDEF);

		//majCombat(tATT, tDEF);
		majOccupant(tATT, tDEF);

		resetCombat(uniteBatailleATT, uniteBatailleDEF);

	}

	public ArrayList<Unite> getUniteBatailleATT() {
		return uniteBatailleATT;
	}

	public void setUniteBatailleATT(ArrayList<Unite> uniteBatailleATT) {
		this.uniteBatailleATT = uniteBatailleATT;
	}

	public ArrayList<Unite> getUniteBatailleDEF() {
		return uniteBatailleDEF;
	}

	public void setUniteBatailleDEF(ArrayList<Unite> uniteBatailleDEF) {
		this.uniteBatailleDEF = uniteBatailleDEF;
	}

	public ArrayList<Territoire> getListeGagnant() {
		return listeGagnant;
	}

	public void setListeGagnant(ArrayList<Territoire> listeGagnant) {
		this.listeGagnant = listeGagnant;
	}

	public int getResultatDe() {
		return resultatDe;
	}

	public void setResultatDe(int resultatDe) {
		this.resultatDe = resultatDe;
	}

}
