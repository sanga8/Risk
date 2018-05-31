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
	ArrayList<Territoire> listeGagnant = new ArrayList<Territoire>();

	int resultatDe;
	
	
	
	public Combat() {}
	
	//METTRE ARMEE TERRITOIRE DANS ARMEE COMBAT
	
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

	public void lanceDe(Territoire t) {
		for (int i = 0; i < uniteBatailleATT.size(); i++) {
			
			this.uniteBatailleATT.get(i).setResultatDe((int) (Math.random() * 6 + uniteBatailleATT.get(i).getPuissance()));
			
			t.getListeUnites().get(i).setResultatDe((int) (Math.random() * 6 + t.getListeUnites().get(i).getPuissance()));

		}
	}
	
	
	//COMBATTRE
	public void combattre(Territoire TerritoireATT, Territoire TerritoireDEF){
		
		int nombreDEF = determinerNombreDEF(TerritoireDEF);
		int nombreATT = determinerNombreATT(TerritoireATT);

		lanceDe();

		Collections.sort(listeResultatDeTerritoireATT);
		Collections.sort(listeResultatDeTerritoireDEF);

		resolutionCombat(TerritoireATT, TerritoireDEF);

		System.out.println(listeResultatDeTerritoireATT.toString());
		System.out.println(listeResultatDeTerritoireDEF.toString());

		actualiserUniteTerritoire(TerritoireATT);
		
		
		
		
		
	}
	
	
	
	
	
	

	public void resolutionCombat(Territoire TerritoireATT, Territoire TerritoireDEF) {
		for (int i = 0; i < TerritoireDEF.uniteBataille.size(); i++) {

			if (TerritoireATT.uniteBataille.get(i).getResultatDe() > TerritoireDEF.uniteBataille.get(i)
					.getResultatDe()) {
				listeGagnant.add(TerritoireATT);
			}

			else {

				listeGagnant.add(TerritoireDEF);

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

}
