package com.beffa.pauwels.risk;
import java.util.HashMap;

public class Joueur {
	private String name;
	private int armees;
	
	private boolean suivant;
	
	private HashMap<String, Territoire> territoiresPossedes;
    private HashMap<String, Continent> continentsPossedes;
	
    public Joueur(String name, int armies) {
		this.name = name;
		this.armees = armees;		
		territoiresPossedes = new HashMap<String, Territoire>();
		continentsPossedes = new HashMap<String, Continent>();	
    }
    
    
    
    
    
    public void SwitchPLayer(){
    	
    	suivant = !suivant;	
    }

    
     
    
}
