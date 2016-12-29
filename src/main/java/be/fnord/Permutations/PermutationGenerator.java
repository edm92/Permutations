package be.fnord.Permutations;

import java.math.BigInteger;

public class PermutationGenerator {
	PermutationController<Integer> p = null;
	int currentNumber = 0;
	public PermutationGenerator(int number){
		currentNumber = number;
		p = new PermutationController<Integer>();
		Integer [] numbers = new Integer[number];
		for(int i = 0 ; i < number ; i++)
			numbers[i] = i;
//		System.out.println(numbers.length);
		
		p.permutation(Integer.class, numbers, null);
		
	}
	
	public boolean hasMore(){
		
		if(p != null)
			return p.hasNext();
		return false;
	}

	public int[] getNext() {
		if(p != null && p.hasNext()){
			int [] result = new int [currentNumber];
			Integer[] otherRes = p.getNextArrayItem();
			for(int i = 0 ; i < otherRes.length ; i++)
				result[i] = otherRes[i];
			return result;
		}
		return null;
	}

	public BigInteger getNumLeft() {
		return BigInteger.valueOf (p._permArrayCounter - p.current);
	}

	public BigInteger getTotal() {
		return BigInteger.valueOf(p._permArrayCounter);
	}
	public void reset() {
		p.current = 0;
	}

	
	

	
}
