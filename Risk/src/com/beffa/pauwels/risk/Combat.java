package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Combat {

	ArrayList<Territoire> listeGagnant = new ArrayList<Territoire>();

	public Combat() {

	}

	// COMBATTRE
	/**
	 * Effectue un combat
	 * 
	 * @param tATT
	 * @param tDEF
	 */
	public void combattre(Territoire tATT, Territoire tDEF) {
		System.out.println("Choisir défense:");

		// L'attaquant choisis ses propres attaquants
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

	/**
	 * Choisis les bonnes unités du territoire defenseur qui vont défendre
	 * 
	 * @param tDEF
	 */
	public void choisirDEF(Territoire tDEF) {
		tDEF.getListeUnitesBataille().addAll(tDEF.getListeUnites()); // On créé une liste clonée de la liste de defense
		Collections.sort(tDEF.getListeUnitesBataille(), Comparator.comparing(Unite::getPrioriteDEF)); // On trie cette
																										// nouvelle
																										// liste en
																										// fonction des
																										// priorités
		if (tDEF.getListeUnitesBataille().size() > 2) { // On prend les 2 premières unités de cette liste triée pour
														// défendre contre les attaquants
			for (int i = tDEF.getListeUnitesBataille().size() - 1; i > 1; i--) {
				tDEF.getListeUnitesBataille().remove(i);
			}
		}
		System.out.println("Nb d'unite en def arene  : " + tDEF.getListeUnitesBataille().size());
	}

	public void lanceDe(ArrayList<Unite> liste) {
		for (int i = 0; i < liste.size(); i++) {

			liste.get(i).setResultatDe((int) (Math.random() * 6 + liste.get(i).getPuissance()));

			System.out.println("Resultats des " + liste.get(i).getResultatDe());
		}
	}

	/**
	 * Permet de trier les résultats des attaquants en fonction de leurs lancé de dé
	 * puis de leurs priorités en cas d'égalité
	 * 
	 * @param t
	 */
	public void trierATT(Territoire t) {
		Collections.sort(t.getListeUnitesBataille(), Comparator.comparing(Unite::getResultatDe)); // On trie en fonction
																									// des résultats des
																									// dés la liste des
																									// attaquants
		Collections.reverse(t.getListeUnitesBataille()); // On inverse cette liste afin d'avoir les scores les plus
															// élevés en premier

		for (int i = t.getListeUnitesBataille().size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (t.getListeUnitesBataille().get(j + 1).getResultatDe() == t.getListeUnitesBataille().get(j)
						.getResultatDe()
						&& t.getListeUnitesBataille().get(j + 1).getPrioriteATT() < t.getListeUnitesBataille().get(j)
								.getPrioriteATT()) {
					Collections.swap(t.getListeUnitesBataille(), j + 1, j); // Si 2 résultats sont identiques, On
																			// compare leurs priorités puis on échange
																			// leurs odre dans la liste si nécessaire
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

	/**
	 * Trie la liste des défenseurs par ordre décroissant La priorité des défenseurs
	 * est faite lors de la sélection des unités qui doivent défendre
	 * 
	 * @param liste
	 */
	public void trierDEF(ArrayList<Unite> liste) {
		if (liste.size() > 1) {
			if (liste.get(0).getResultatDe() < liste.get(1).getResultatDe()) {
				Collections.swap(liste, 0, 1); // On échange les 2 résultats si nécessaire
			}
		}
	}

	/**
	 * Compare les résultats des dés des attaquants et des défenseurs
	 * 
	 * @param tATT
	 * @param tDEF
	 */
	public void resoudre(Territoire tATT, Territoire tDEF) {
		int petiteliste;

		System.out.println("Nb attaquants:" + tATT.getListeUnitesBataille().size());
		System.out.println("Nb defenseurs" + tDEF.getListeUnitesBataille().size());

		if (tATT.getListeUnitesBataille().size() < tDEF.getListeUnitesBataille().size()) {
			petiteliste = tATT.getListeUnitesBataille().size();
		} else {
			petiteliste = tDEF.getListeUnitesBataille().size();
		}
		System.out.println("petite liste :" + petiteliste); // La petite liste correspond au plus faible nombre de
															// combats réalisés par l'attaquant et le défenseur

		for (int i = petiteliste - 1; i >= 0; i--) {
			System.out.println("Resultats des  premier attaquant avant resoudre "
					+ tATT.getListeUnitesBataille().get(0).getResultatDe());

			if (tDEF.getListeUnitesBataille().get(i).getResultatDe() >= tATT.getListeUnitesBataille().get(i)
					.getResultatDe()) {
				tATT.getListeUnites().remove(tATT.getListeUnitesBataille().get(i));
				tATT.getListeUnitesBataille().remove(i); // Si la defense gagne, on enlève l'attaquant de la liste
															// clonée et dans le territoire

				System.out.println("Attaquant perd unite");

			} else {

				tDEF.getListeUnites().remove(tDEF.getListeUnitesBataille().get(i));
				tDEF.getListeUnitesBataille().remove(i); // Si l'attaquant gagne, on enlève le defenseur de la liste
															// clonée et dans le territoire
				System.out.println("Defenseur perd unite");
			}
		}
	}

	public void majCombat(Territoire tATT, Territoire tDEF) {
		for (int i = 0; i < tATT.getListeUnitesBataille().size(); i++) {
			tATT.listeUnitesBataille.get(i).setMouvement(tATT.listeUnitesBataille.get(i).getMouvement() - 1); // On
																												// retire
																												// un
																												// point
																												// de
																												// mouvement
																												// aux
																												// unités
																												// qui
																												// ont
																												// combatu
		}
		if (tDEF.getListeUnites().size() == 0) {
			tDEF.setOccupant(tATT.getOccupant()); // S'il n'y a plus d'unités dans le territoire qui défend, l'attaquant
													// en prend le controle

			tDEF.getListeUnites().addAll(tATT.getListeUnitesBataille()); // Puis on déplace les unités d'attaque qui ont
																			// survécu sur le nouveau térritoire
		} else {
			tATT.getListeUnites().addAll(tATT.getListeUnitesBataille()); // Sinon les unités d'attaque qui ont survécu
																			// retournent dans leurs térritoire de
																			// départ
		}
	}

	public ArrayList<Territoire> getListeGagnant() {
		return listeGagnant;
	}

	public void setListeGagnant(ArrayList<Territoire> listeGagnant) {
		this.listeGagnant = listeGagnant;
	}

}
