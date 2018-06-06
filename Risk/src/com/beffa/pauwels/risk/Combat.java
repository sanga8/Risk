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
			if (liste.size() >= 3) {
				// EXCEPTION SI LES TROIS ONT LE MEME RESULTAT DE
				if (liste.get(0).getResultatDe() == liste.get(1).getResultatDe()
						&& liste.get(1).getResultatDe() == liste.get(2).getResultatDe()) {
					Collections.sort(liste, Comparator.comparing(Unite::getPrioriteATT));
				}
			}
		}
	}

	public void choisirDEF(ArrayList<Unite> liste) {
		Collections.sort(liste, Comparator.comparing(Unite::getPrioriteDEF));
		if (liste.size() > 2) {
			for (int i = liste.size() - 1; i > 1; i--) {
				liste.remove(i);
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

	public void resoudre(ArrayList<Unite> liste, Territoire tDEF) {
		for (int i = 0; i < tDEF.listeUnites.size(); i++) {
			if (liste.get(i).getResultatDe() > tDEF.listeUnites.get(i).getResultatDe()) {
				// troupe defenseur meurt
			} else {// troupe attaquant meurt

			}
		}
		if (liste.size() < tDEF.listeUnites.size()) {
			for (int i = 0; i < liste.size(); i++) {
				if (liste.get(i).getResultatDe() > tDEF.listeUnites.get(i).getResultatDe()) {
					// troupe defenseur meurt
				} else {// troupe attaquant meurt

				}
			}
		}
	}

	// COMBATTRE
	public void combattre(Territoire tATT, Territoire tDEF) {
		/*
		 * choisir unités défenses lancer les dés trier les dés trier par prio
		 * d'atq déterminer résultats mettre à jour les occupants et armées sur
		 * les territoires réinitialiser les combats
		 */

		choisirDEF(tDEF.listeUnites);
		lanceDe(tDEF.listeUnites);
		trierDEF(tDEF.listeUnites);

		lanceDe(uniteBatailleATT);
		trierATT(uniteBatailleATT);

	}

}

/*
 * public void resolutionCombat(Territoire TerritoireATT, Territoire
 * TerritoireDEF) { for (int i = 0; i < TerritoireDEF.uniteBataille.size(); i++)
 * {
 * 
 * if (TerritoireATT.uniteBataille.get(i).getResultatDe() >
 * TerritoireDEF.uniteBataille.get(i) .getResultatDe()) {
 * listeGagnant.add(TerritoireATT); }
 * 
 * else {
 * 
 * listeGagnant.add(TerritoireDEF);
 * 
 * }
 * 
 * }
 * 
 * }
 */
/*
 * ArrayList <Integer> attaquants = new ArrayList<Integer>();
 * 
 * attaquants.add(uniteAttaquant1.getPuissance());
 * attaquants.add(uniteAttaquant2.getPuissance());
 * attaquants.add(uniteAttaquant3.getPuissance());
 * 
 * ArrayList <Integer> defenseurs = new ArrayList <Integer>();
 * 
 * defenseurs.add(uniteDefenseur1.getPuissance());
 * defenseurs.add(uniteDefenseur2.getPuissance());
 * 
 * 
 * Collections.sort(attaquants); Collections.reverse(attaquants);
 * 
 * Collections.sort(defenseurs); Collections.reverse(defenseurs);
 * 
 * 
 * System.out.println("D�fenseurs avant combat: " + defenseurs);
 * System.out.println("Attaquants avant combat: " + attaquants);
 * 
 * 
 * for (int i=0; i<defenseurs.size() ; i++) { if (attaquants.get(i) >
 * defenseurs.get(i)) {
 * 
 * defenseurs.remove(i);
 * 
 * 
 * } if (attaquants.get(i) < defenseurs.get(i)) {
 * 
 * attaquants.remove(i);
 * 
 * 
 * }
 * 
 * else if(attaquants.get(i) < defenseurs.get(i)) {
 * 
 * System.out.println("Egalit�, comparez les priorit�s");
 * 
 * 
 * }
 * 
 * 
 * }
 * 
 * 
 * System.out.println("D�fenseurs apr�s combat: " + defenseurs);
 * System.out.println("Attaquants apr�s combat: " + attaquants);
 * 
 */

// int max = (int) Collections.max(Arrays.asList(Attaquants));

// if (unite1.getPuissance() < unite2.getPuissance()) {

// System.out.println("Le " + unite2.getNom() + " bat le " +
// unite1.getNom());
// }
// else if (unite1.getPuissance() > unite2.getPuissance()){
//
// System.out.println("Le " + unite1.getNom() + " bat le " +
// unite2.getNom());

// }

// else if (unite1.getPuissance() == unite2.getPuissance()) {

// System.out.println("comparez les priorit�s");
// }
