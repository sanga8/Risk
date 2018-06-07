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

	// METTRE ARMEE TERRITOIRE ACTION DANS ARMEE COMBAT

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
			if (liste.get(i).getResultatDe() == liste.get(i + 1).getResultatDe()
					&& liste.get(i).getPrioriteATT() > liste.get(i + 1).getPrioriteATT()) {
				Collections.swap(liste, i, i + 1);
			}
			if (liste.size() == 3) {
				// EXCEPTION SI LES TROIS ONT LE MEME RESULTAT DE
				if (liste.get(0).getResultatDe() == liste.get(1).getResultatDe()
						&& liste.get(1).getResultatDe() == liste.get(2).getResultatDe()) {
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
				
				Unite unit = tDEF.listeUnites.get(0);
				tDEF.listeUnites.remove(0);
				uniteBatailleDEF.add(unit);
			}
		}
		if (tDEF.listeUnites.size() == 1) {
			
			System.out.println("Une unite en defense");
			
			Unite unit = tDEF.listeUnites.get(0);
			tDEF.listeUnites.remove(0);
			uniteBatailleDEF.add(unit);
		}
		System.out.println("Nb d'unite en def arene: " + uniteBatailleDEF.size());
	}

	public void choisirATT(Territoire tATT, ArrayList<Unite> uniteBatailleATT) {
		if (tATT.getListeUnitesAction().size() > 0 && tATT.getListeUnitesAction().size() < 4) {
			System.out.println("Nb d'unite en atq : " + tATT.getListeUnitesAction().size());
			for (int i = 0; i < 3; i++) {
				Unite unit = tATT.getListeUnitesAction().get(0);
				tATT.getListeUnitesAction().remove(0);
				uniteBatailleATT.add(unit);
			}
			System.out.println("Nb d'unite en atq arene: " + uniteBatailleATT.size());
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
		int a = listeDEF.size();
		int b = listeATT.size();
		if (a <= b) {
			for (int i = a - 1; i >= 0; i--) {

				if (listeDEF.get(i).getResultatDe() >= listeATT.get(i).getResultatDe()) {
					listeATT.remove(i);
					System.out.println("Attaquant perd unite");
				} else {
					listeDEF.remove(i);
					System.out.println("Defenseur perd unite");
				}
			}
		}
		if (b < a) {
			for (int i = b - 1; i >= 0; i--) {
				if (listeDEF.get(i).getResultatDe() < listeATT.get(i).getResultatDe()) {
					listeDEF.remove(i);
					System.out.println("Defenseur perd unite");
				} else {
					listeATT.remove(i);
					System.out.println("Attaquant perd unite");
				}
			}
		}
	}

	public void majCombat(Territoire tATT, Territoire tDEF) {
		if (tDEF.listeUnites.size() == 0) {
			tDEF.setOccupant(tATT.getOccupant());
			tDEF.getListeUnites().addAll(uniteBatailleATT);
			uniteBatailleATT.clear();
		} else {
			tATT.getListeUnites().addAll(uniteBatailleATT);
			uniteBatailleATT.clear();

			System.out.println(uniteBatailleDEF.size());
			System.out.println(tDEF.getListeUnites().size());

			tDEF.getListeUnites().addAll(uniteBatailleDEF);
			uniteBatailleDEF.clear();

			System.out.println(uniteBatailleDEF.size());
			System.out.println(tDEF.getListeUnites().size());

		}

	}

	// COMBATTRE
	public void combattre(Territoire tATT, Territoire tDEF) {
		/*
		 * choisir unit�s défenses lancer les dés trier les dés trier par prio
		 * d'atq déterminer résultats mettre à jour les occupants et armées sur
		 * les territoires réinitialiser les combats
		 */

		choisirATT(tATT, uniteBatailleATT);
		choisirDEF(tDEF, uniteBatailleDEF);

		lanceDe(uniteBatailleATT);
		lanceDe(uniteBatailleDEF);

		trierATT(uniteBatailleATT);
		trierDEF(uniteBatailleDEF);

		resoudre(uniteBatailleATT, uniteBatailleDEF);

		majCombat(tATT, tDEF);

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
