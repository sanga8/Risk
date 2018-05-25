package com.beffa.pauwels.risk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Combat {
	
	public Combat(Unite uniteAttaquant1, Unite uniteAttaquant2, Unite uniteAttaquant3, Unite uniteDefenseur1, Unite uniteDefenseur2) {
		
		
		ArrayList <Integer> attaquants = new ArrayList<Integer>();
		
		attaquants.add(uniteAttaquant1.getPuissance());
		attaquants.add(uniteAttaquant2.getPuissance());
		attaquants.add(uniteAttaquant3.getPuissance());
		
		ArrayList <Integer> defenseurs = new ArrayList <Integer>();
		
		defenseurs.add(uniteDefenseur1.getPuissance());
		defenseurs.add(uniteDefenseur2.getPuissance());
		
		
		Collections.sort(attaquants);
		Collections.reverse(attaquants);
		
		Collections.sort(defenseurs);
		Collections.reverse(defenseurs);
		

		System.out.println("Défenseurs avant combat: " + defenseurs);
		System.out.println("Attaquants avant combat: " + attaquants);
		
		
		for (int i=0; i<defenseurs.size() ; i++) {
			if (attaquants.get(i) > defenseurs.get(i)) {
				
				defenseurs.remove(i);
		
				
			}
			if (attaquants.get(i) < defenseurs.get(i)) {
	
				attaquants.remove(i);
				
				
			}
			
			else if(attaquants.get(i) < defenseurs.get(i)) {
				
				System.out.println("Egalité, comparez les priorités");
				
				
			}

			
		}
		
		
		System.out.println("Défenseurs après combat: " + defenseurs);
		System.out.println("Attaquants après combat: " + attaquants);
		
		
		
		//int max = (int) Collections.max(Arrays.asList(Attaquants));
		
		
		//if (unite1.getPuissance() < unite2.getPuissance()) {
			
		//	System.out.println("Le " + unite2.getNom() + " bat le " + unite1.getNom());
		//}
		//else if (unite1.getPuissance() > unite2.getPuissance()){
		//	
		//	System.out.println("Le " + unite1.getNom() + " bat le " + unite2.getNom());
			
		//}
			
		//else if (unite1.getPuissance() == unite2.getPuissance()) {
			
		//	System.out.println("comparez les priorités");
		//}

	}

}

