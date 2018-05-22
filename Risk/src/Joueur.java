import java.util.HashMap;

public class Joueur {
	private String name;
	private int armees;
	
	private HashMap<String, Territoire> territoiresPossedes;
    private HashMap<String, Continent> continentsPossedes;
	
    public Joueur(String name, int armies) {
    	
		this.name = name;
		this.armees = armees;
		
		
		territoiresPossedes = new HashMap<String, Territoire>();
		continentsPossedes = new HashMap<String, Continent>();
		
		//hello
		
		
		
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

	public HashMap<String, Territoire> getTerritoiresPossedes() {
		return territoiresPossedes;
	}

	public void setTerritoiresPossedes(HashMap<String, Territoire> territoiresPossedes) {
		this.territoiresPossedes = territoiresPossedes;
	}

	public HashMap<String, Continent> getContinentsPossedes() {
		return continentsPossedes;
	}

	public void setContinentsPossedes(HashMap<String, Continent> continentsPossedes) {
		this.continentsPossedes = continentsPossedes;
	}
}
