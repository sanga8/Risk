package com.beffa.pauwels.risk;
import java.util.ArrayList;

public class Territoire {
	
	private String name;
	private int armees;
	private ArrayList<Territoire> territoiresAdjacents;
	private Joueur occupant;
	
	public Territoire(String name) {
		
		this.name = name;
		armees = 0;
		System.out.println("Territoire: " + name);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArmees() {
		return armees;
	}

	public void setArmees(int armees) {
		this.armees = armees;
	}

	public ArrayList<Territoire> getTerritoiresAdjacents() {
		return territoiresAdjacents;
	}

	public void setTerritoiresAdjacents(ArrayList<Territoire> territoiresAdjacents) {
		this.territoiresAdjacents = territoiresAdjacents;
	}

	public Joueur getOccupant() {
		return occupant;
	}

	public void setOccupant(Joueur occupant) {
		this.occupant = occupant;
	}
	
	
	
	
	
}
