package be.fnord.Sample;

import be.fnord.Combinations.CombinationGenerator;

public class SampleCombination {

	public static void main(String [] args){
		CombinationGenerator cr = new CombinationGenerator(15,7);
		while(cr.hasMore()){
			int [] i = cr.getNext();
			for(int ii = 0 ; ii < i.length ; ii++)
				System.out.print(i[ii] + " ");
			System.out.println("");
		}
	}
}
