package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Combat {

	ArrayList<Territoire> listeGagnant = new ArrayList<Territoire>();

	public Combat() {

	}

	public void lanceDe(ArrayList<Unite> liste) {
		for (int i = 0; i < liste.size(); i++) {
			liste.get(i).setResultatDe((int) (Math.random() * 6 + liste.get(i).getPuissance()));
			System.out.println("Resultats des " + liste.get(i).getResultatDe());
		}
	}

	public void choisirDEF(Territoire tDEF) {
		System.out.println("Nb d'unite en def arene  : " + tDEF.getListeUnitesBataille().size());
		tDEF.getListeUnitesBataille().addAll(tDEF.getListeUnites());
		Collections.sort(tDEF.getListeUnitesBataille(), Comparator.comparing(Unite::getPrioriteDEF));
		if (tDEF.getListeUnitesBataille().size() > 2) {
			for (int i = tDEF.getListeUnitesBataille().size() - 1; i > 1; i--) {
				tDEF.getListeUnitesBataille().remove(i);
			}
		}
		System.out.println("Nb d'unite en def arene  : " + tDEF.getListeUnitesBataille().size());
	}

	public void trierDEF(ArrayList<Unite> liste) {
		// System.out.println("Resultats des premier attaquant avant trier def " +
		// liste.get(0).getResultatDe());
		if (liste.size() > 1) {
			if (liste.get(0).getResultatDe() < liste.get(1).getResultatDe()) {
				Collections.swap(liste, 0, 1);
			}
		}
		System.out.println("ok");
	}

	public void trierATT(Territoire t) {
		Collections.sort(t.getListeUnitesBataille(), Comparator.comparing(Unite::getResultatDe));
		Collections.reverse(t.getListeUnitesBataille());

		for (int i = t.getListeUnitesBataille().size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (t.getListeUnitesBataille().get(j + 1).getResultatDe() == t.getListeUnitesBataille().get(j)
						.getResultatDe()
						&& t.getListeUnitesBataille().get(j + 1).getPrioriteATT() < t.getListeUnitesBataille().get(j)
								.getPrioriteATT()) {
					Collections.swap(t.getListeUnitesBataille(), j + 1, j);
					System.out.println("WHahelle Bulle" + t.getListeUnites().get(i).getResultatDe());
					if (t.getListeUnitesBataille().get(j + 1).getResultatDe() == t.getListeUnitesBataille().get(j)
							.getResultatDe()
							&& t.getListeUnitesBataille().get(j + 1).getPrioriteATT() < t.getListeUnitesBataille()
									.get(j).getPrioriteATT()) {
						Collections.swap(t.getListeUnitesBataille(), j + 1, j);
					}
				}
			}
		}
	}

	public void resoudre(Territoire tATT, Territoire tDEF) {
		int petiteliste;

		System.out.println("Nb attaquants:" + tATT.getListeUnitesBataille().size());
		System.out.println("Nb defenseurs" + tDEF.getListeUnitesBataille().size());
		if (tATT.getListeUnitesBataille().size() < tDEF.getListeUnitesBataille().size()) {
			petiteliste = tATT.getListeUnitesBataille().size();
		} else {
			petiteliste = tDEF.getListeUnitesBataille().size();
		}
		System.out.println("petite liste :" + petiteliste);

		for (int i = petiteliste - 1; i >= 0; i--) {
			System.out.println("Resultats des  premier attaquant avant resoudre "
					+ tATT.getListeUnitesBataille().get(0).getResultatDe());
			if (tDEF.getListeUnitesBataille().get(i).getResultatDe() >= tATT.getListeUnitesBataille().get(i)
					.getResultatDe()) {
				tATT.getListeUnites().remove(tATT.getListeUnitesBataille().get(i));
				tATT.getListeUnitesBataille().remove(i);

				System.out.println("Attaquant perd unite");

			} else {

				tDEF.getListeUnites().remove(tDEF.getListeUnitesBataille().get(i));
				tDEF.getListeUnitesBataille().remove(i);
				System.out.println("Defenseur perd unite");
			}
		}
	}

	public void majCombat(Territoire tATT, Territoire tDEF) {
		for (int i = 0; i < tATT.getListeUnitesBataille().size(); i++) {
			tATT.listeUnitesBataille.get(i).setMouvement(tATT.listeUnitesBataille.get(i).getMouvement() - 1);
		}
		for (int j = 0; j < tDEF.getListeUnitesBataille().size(); j++) {
			tDEF.listeUnitesBataille.get(j).setMouvement(tDEF.listeUnitesBataille.get(j).getMouvement() - 1);
		}
		if (tDEF.getListeUnites().size() == 0) {
			tDEF.setOccupant(tATT.getOccupant());

			tDEF.getListeUnites().addAll(tATT.getListeUnitesBataille());
		} else {
			tATT.getListeUnites().addAll(tATT.getListeUnitesBataille());
		}
	}

	// COMBATTRE
	public void combattre(Territoire tATT, Territoire tDEF) {
		System.out.println("Choisir défense:");

		choisirDEF(tDEF);
		System.out.println("Lancement des dés attaque:");

		lanceDe(tATT.getListeUnitesBataille());
		System.out.println("Lancement des dés defense:");
		lanceDe(tDEF.getListeUnitesBataille());
		System.out.println("Trier attaque:");

		trierATT(tATT);
		System.out.println("Trier défense:");
		trierDEF(tDEF.getListeUnitesBataille());
		System.out.println("Resoudre:");

		resoudre(tATT, tDEF);
		System.out.println("MajCombat:");

		majCombat(tATT, tDEF);
		System.out.println("Clear");

		tATT.getListeUnitesBataille().clear();
		tDEF.getListeUnitesBataille().clear();
		System.out.println("Combat termine");

	}

	public ArrayList<Territoire> getListeGagnant() {
		return listeGagnant;
	}

	public void setListeGagnant(ArrayList<Territoire> listeGagnant) {
		this.listeGagnant = listeGagnant;
	}

}
