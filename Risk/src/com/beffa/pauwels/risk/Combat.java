package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Combat {

	ArrayList<Territoire> listeGagnant = new ArrayList<Territoire>();
	int resultatDe;

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
		System.out.println("Nb d'unite en def arene  : " + tDEF.getListeUnitesBataille().size());
		if (tDEF.getListeUnitesBataille().size() > 2) {
			for (int i = tDEF.getListeUnitesBataille().size() - 1; i > 1; i--) {
				tDEF.getListeUnitesBataille().remove(i);
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

	public void trierATT(Territoire t) {
		System.out.println("WHahelle Bulle D�but" + t.getListeUnites().get(0).getResultatDe());
		Collections.sort(t.getListeUnitesBataille(), Comparator.comparing(Unite::getResultatDe));
		Collections.reverse(t.getListeUnitesBataille());
		
		for (int i = t.getListeUnitesBataille().size() - 1; i > 0; i--) {
			System.out.println("WHahelle Bulle milieu" + t.getListeUnites().get(i).getResultatDe());
			for (int j = 0; j < i; j++) {
				if (t.getListeUnitesBataille().get(j + 1).getResultatDe() == t.getListeUnitesBataille().get(j) .getResultatDe() && t.getListeUnitesBataille().get(j + 1).getPrioriteATT() < t.getListeUnitesBataille().get(j).getPrioriteATT()) {
					Collections.swap(t.getListeUnitesBataille(), j + 1, j);
					System.out.println("WHahelle Bulle" + t.getListeUnites().get(i).getResultatDe());
				}
			}
		}
	}

	public void resoudre(Territoire tATT, Territoire tDEF) {
		
		System.out.println("WHahelle d�but r�soudre" + tATT.getListeUnites().get(0).getResultatDe());
		
		int petiteliste;
		System.out.println(tATT.getListeUnitesBataille().size());
		System.out.println(tDEF.getListeUnitesBataille().size());
		
		if (tATT.getListeUnitesBataille().size() < tDEF.getListeUnitesBataille().size()) {
			petiteliste = tATT.getListeUnitesBataille().size();
		} else {
			petiteliste = tDEF.getListeUnitesBataille().size();
		}
		System.out.println("petite liste :" + petiteliste);
		for (int i = 0; i < petiteliste; i++) {
			System.out.println("for");
			if (tDEF.getListeUnitesBataille().get(i).getResultatDe() >= tATT.getListeUnites().get(i).getResultatDe()) {
				tATT.getListeUnites().remove(tATT.getListeUnitesBataille().get(i));
				tATT.getListeUnitesBataille().remove(i);

				System.out.println("WHahelle" + tATT.getListeUnites().get(i).getResultatDe());
				System.out.println("Attaquant perd unite");
			} 
			else {
				tDEF.getListeUnites().remove(tDEF.getListeUnitesBataille().get(i));
				tDEF.getListeUnitesBataille().remove(i);
				System.out.println("Defenseur perd unite");
			}
		}
	}

	public void majCombat(Territoire tATT, Territoire tDEF) {
		if (tDEF.getListeUnites().size() == 0) {

			tDEF.setOccupant(tATT.getOccupant());
			tDEF.getListeUnitesBataille().addAll(tATT.getListeUnitesBataille());
		} 
	}

	// COMBATTRE
	public void combattre(Territoire tATT, Territoire tDEF) {
		/*
		 * choisir unit�s défenses lancer les dés trier les dés trier par prio
		 * d'atq déterminer résultats mettre à jour les occupants et armées sur
		 * les territoires réinitialiser les combats
		 */

		choisirDEF(tDEF);
	
		System.out.println("Lancement des dés attaque:");
		lanceDe(tATT.getListeUnitesBataille());
		
		System.out.println("Lancement des dés defense:");
		lanceDe(tDEF.getListeUnitesBataille());

		trierATT(tATT);
		trierDEF(tDEF.getListeUnitesBataille());
		
		System.out.println("ici");
		
		resoudre(tATT, tDEF);
		
		System.out.println("ici");
		
		majCombat(tATT, tDEF);
		
		tATT.getListeUnitesBataille().clear();
		tDEF.getListeUnitesBataille().clear();

	}

	public ArrayList<Territoire> getListeGagnant() {
		return listeGagnant;
	}

	public void setListeGagnant(ArrayList<Territoire> listeGagnant) {
		this.listeGagnant = listeGagnant;
	}

}
