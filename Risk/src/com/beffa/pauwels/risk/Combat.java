package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Combat {

	ArrayList<Unite> uniteBatailleATT = new ArrayList<Unite>();
	ArrayList<Unite> uniteBatailleDEF = new ArrayList<Unite>();

	ArrayList<Integer> listeResultatDepaysATT = new ArrayList<Integer>();
	ArrayList<Integer> listeResultatDepaysDEF = new ArrayList<Integer>();

	ArrayList<Pays> listeGagnant = new ArrayList<Pays>();

	int nombreSoldats;
	int nombreCavaliers;
	int nombreCanons;

	int resultatDe;

	public int determinerNombreATT(Pays p) {
		if (p.nombreSoldats + p.nombreCavaliers + p.nombreCanons == 2) {
			return 1;
		}

		else if (p.nombreSoldats + p.nombreCavaliers + p.nombreCanons == 2) {
			return 2;
		}

		else {
			return 3;
		}
	}

	public void prendreUniteATT(Pays p) {
		p.addSoldat(-1);
		int count = 0;
		for (int i = 0; i < p.getListeUnites().size(); i++) {
			if (p.getListeUnites().get(i).getType() == 0 && count == 0) {

				uniteBatailleATT.add(p.getListeUnites().get(i));
				count++;
			}
		}

	}

	public int determinerNombreDEF(Pays p) {
		if (p.nombreSoldats + p.nombreCavaliers + p.nombreCanons == 1) {
			return 1;
		}

		else {
			return 2;
		}

	}

	public void lanceDe() {
		for (int i = 0; i < Pays.uniteBataille.size(); i++) {
			this.uniteBatailleATT.get(i)
					.setResultatDe((int) (Math.random() * 6 + uniteBatailleATT.get(i).getPuissance()));
			this.uniteBatailleDEF.get(i)
					.setResultatDe((int) (Math.random() * 6 + uniteBatailleDEF.get(i).getPuissance()));

			listeResultatDepaysATT.add(this.uniteBatailleATT.get(i).getResultatDe());
			listeResultatDepaysDEF.add(this.uniteBatailleDEF.get(i).getResultatDe());

		}
	}

	public void actualiserUnitePays(Unite unite) {

		Pays.listeUnites.remove(unite);

		if (unite.getType() == 0) {
			this.addSoldat(-1);
		} else if (unite.getType() == 1) {
			this.addCavalier(-1);
		} else if (unite.getType() == 2) {
			this.addCanon(-1);
		}
	}

	public Combat(Pays paysATT, Pays paysDEF) {

		int nombreDEF = determinerNombreDEF(paysDEF);
		int nombreATT = determinerNombreATT(paysATT);

		lanceDe();

		Collections.sort(listeResultatDepaysATT);
		Collections.sort(listeResultatDepaysDEF);
		
		resolutionCombat(paysATT, paysDEF);

		System.out.println(listeResultatDepaysATT.toString());
		System.out.println(listeResultatDepaysDEF.toString());

		actualiserUnitePays(paysATT);

	}

	public void resolutionCombat(Pays paysATT, Pays paysDEF) {
		for (int i = 0; i < paysDEF.uniteBataille.size(); i++) {

			if (paysATT.uniteBataille.get(i).getResultatDe() > paysDEF.uniteBataille.get(i).getResultatDe()) {
				listeGagnant.add(paysATT);
			}

			else {

				listeGagnant.add(paysDEF);

			}

		}

	}

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
	 * System.out.println("Défenseurs avant combat: " + defenseurs);
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
	 * System.out.println("Egalité, comparez les priorités");
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * System.out.println("Défenseurs après combat: " + defenseurs);
	 * System.out.println("Attaquants après combat: " + attaquants);
	 * 
	 */

	// int max = (int) Collections.max(Arrays.asList(Attaquants));

	// if (unite1.getPuissance() < unite2.getPuissance()) {

	// System.out.println("Le " + unite2.getNom() + " bat le " + unite1.getNom());
	// }
	// else if (unite1.getPuissance() > unite2.getPuissance()){
	//
	// System.out.println("Le " + unite1.getNom() + " bat le " + unite2.getNom());

	// }

	// else if (unite1.getPuissance() == unite2.getPuissance()) {

	// System.out.println("comparez les priorités");
	// }

}


