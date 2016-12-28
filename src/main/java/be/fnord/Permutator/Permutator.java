package be.fnord.Permutator;

import java.util.LinkedList;
import java.util.List;

// http://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
/**
 * Permutator class to generate permutations of generics
 * @author Evan.Morrison
 *
 * @param <T>
 */
public class Permutator <T> {
	LinkedList<LinkedList<T>> perm = new LinkedList<LinkedList<T>>();
	int current = 0;
	LinkedList<T> items;
	
/**
 * Will return true if there is a next permutation
 * @return
 */
	public boolean hasNext(){
		if(current < perm.size()) return true;
		return false;
	}
	
	/**
	 * Will return the next permutation. 
	 * @return
	 */
	public LinkedList<T> getNext(){
		return perm.get(current++);
	}
	
	/**
	 * Create a new permutation of the input list of elements 
	 * @param str
	 */
	public void permutation(LinkedList<T> str) { 
	    permutation(new LinkedList<T>(), str); 
	}

	private void permutation(LinkedList<T> prefix, List<T> str) {
		
		int n = str.size();
	    if (n == 0) { perm.add( prefix ) ; 
	    		
	    }
	    else {
	        for (int i = 0; i < n; i++){
	        	LinkedList<T> nPrefix = new LinkedList<T>();
	    		nPrefix.addAll(prefix);
	        	
	        	List<T> c = new LinkedList<T>();
	        	int j = 0;
	        	for(j = 0; j < i; j++)
	        		c.add(str.get(j));
	        	for(j = i+1; j < str.size(); j++)
	        		c.add(str.get(j));
	        	nPrefix.add(str.get(i));
	            permutation(nPrefix , c);
	        }
	    }
	}
	
}
