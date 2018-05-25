package com.beffa.pauwels.risk;
	import java.util.Arrays;
	import java.util.Collections;
	import java.util.Random;

public class De {
	
		private int roll;
		
		private int[] diceArray;
	    private Random die;

	    
	    public De() {}

	    public int[] roll(int numberOfDice) {
		
			diceArray = new int[numberOfDice];
			
			for(int i = 0; i < diceArray.length; i++) {
				//die = new Random();
				//roll = die.nextInt(5) + 1;
				
				roll = (int)(Math.random()*6+1);
				
			}
			
			Arrays.sort(diceArray);
			Collections.reverse(Arrays.asList(diceArray));
			
			System.out.println(Arrays.toString(diceArray));
			return diceArray;
	    }
}


