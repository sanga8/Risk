package com.beffa.pauwels.risk;

public class Unite {
	
	private int puissance;
	private int prioriteATQ;
	private int prioriteDEF; 
	private int resultatDe=0;
	private int type;
	private int mouvement;
	
	
	public Unite(int type) {
		this.type= type;
		//SOLDAT
		if(type == 0){
			this.puissance = 1;
			this.prioriteATQ = 2;
			this.prioriteDEF = 1;
			this.mouvement = 2;
		
			
		}
		//CAVALIER
		if(type == 1){
			this.puissance = 2;
			this.prioriteATQ = 1;
			this.prioriteDEF = 3;
			this.mouvement = 3;

		}
		//CANON
		if(type == 2){
			this.puissance = 4;
			this.prioriteATQ = 3;
			this.prioriteDEF = 2;
			this.mouvement = 1;

		}

		
		
	}

	public int getPuissance() {
		return puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getResultatDe() {
		return resultatDe;
	}

	public void setResultatDe(int resultatDe) {
		this.resultatDe = resultatDe;
	}

	public int getPrioriteATQ() {
		return prioriteATQ;
	}

	public void setPrioriteATQ(int prioriteATQ) {
		this.prioriteATQ = prioriteATQ;
	}

	public int getPrioriteDEF() {
		return prioriteDEF;
	}

	public void setPrioriteDEF(int prioriteDEF) {
		this.prioriteDEF = prioriteDEF;
	}

	public int getMouvement() {
		return mouvement;
	}

	public void setMouvement(int mouvement) {
		this.mouvement = mouvement;
	}

	
}