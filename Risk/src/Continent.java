import java.util.ArrayList;

public class Continent {
	private String name;
	private int supply;
	private ArrayList<Territoire> territoires;
	
	public Continent(String name, int bonusArmies, ArrayList<Territoire> memberCountries) {
		this.name = name;
		this.supply = supply;
		territoires = territoires;
		
		System.out.println("Created continent: " + name + "\n Armées bonus: " + bonusArmies);
    }



	public String getName() {
	return name;
	}

	public int getBonusArmies() {
	return supply;
	}

	public ArrayList<Territoire> getMemberCountries() {
	return territoires;
	}
}
