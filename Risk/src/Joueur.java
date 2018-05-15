import java.util.HashMap;

public class Joueur {
	private String name;
	private int armées;
	
	private HashMap<String, Territoire> territoiresPossédés;
    private HashMap<String, Continent> continentsPossédés;
	
    public Joueur(String name, int armies) {
    	
		this.name = name;
		this.armées = armées;
		
		
		territoiresPossédés = new HashMap<String, Territoire>();
		continentsPossédés = new HashMap<String, Continent>();
		
		
		
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getArmées() {
		return armées;
	}

	public void setArmées(int armées) {
		this.armées = armées;
	}

	public HashMap<String, Territoire> getTerritoiresPossédés() {
		return territoiresPossédés;
	}

	public void setTerritoiresPossédés(HashMap<String, Territoire> territoiresPossédés) {
		this.territoiresPossédés = territoiresPossédés;
	}

	public HashMap<String, Continent> getContinentsPossédés() {
		return continentsPossédés;
	}

	public void setContinentsPossédés(HashMap<String, Continent> continentsPossédés) {
		this.continentsPossédés = continentsPossédés;
	}
}
