package be.fnord.Permutations;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

// http://stackoverflow.com/questions/4240080/generating-all-permutations-of-a-given-string
/**
 * Permutator class to generate permutations of generics
 * @author Evan.Morrison
 *
 * @param <T>
 */
public class PermutationController <T> {
	public static boolean isArray = false; 
	public T [][] permArray;
	public int _permArrayCounter = 0;
	LinkedList<LinkedList<T>> perm = new LinkedList<LinkedList<T>>();
	public int current = 0;
	LinkedList<T> items;
	Class<T> basic;
	T empty;
	
	
	
/**
 * Will return true if there is a next permutation
 * @return
 */
	public boolean hasNext(){
//		System.out.println(current + " " + _permArrayCounter);
		if(!isArray)
			if(current < perm.size()) return true;
		if(isArray)
			if(current < _permArrayCounter) return true;
				
		return false;
	}
	
	/**
	 * Will return the next permutation. 
	 * @return
	 */
	public LinkedList<T> getNextListItem(){
		if(!isArray)
			return perm.get(current++);
		return null;
	}
	public T[] getNextArrayItem(){
		if(isArray)
			return permArray[current++];
		return null;
	}
	
	/**
	 * Create a new permutation of the input list of elements 
	 * @param str
	 */
	public void permutation(LinkedList<T> str) { 
	    permutation(new LinkedList<T>(), str); 
	}
	@SuppressWarnings("unchecked")
	public void permutation(Class<T> clazz, T [] str, T _empty) {
		basic = clazz;
		empty = _empty;
		isArray = true;
		T [] nT = (T[])Array.newInstance(clazz, str.length);
		permArray = (T[][])Array.newInstance(nT.getClass(), factorial(BigInteger.valueOf(str.length)).intValue());
		for(int i = 0; i < str.length ; i++){
			nT[i] = empty;			
		}
		
//		System.out.println(factorial(BigInteger.valueOf(str.length)).intValue());
		
		// Fill permArray with empties
		for(int i = 0; i < factorial(BigInteger.valueOf(str.length)).intValue() ; i++){
			permArray[i] = (T[])Array.newInstance(clazz, str.length);
			try{
				System.arraycopy(nT, 0, permArray[i], 1, str.length-1);
			}catch(Exception e){e.printStackTrace();}
		}
	    permutation(nT , str);     
	    
	}
	
	
//	private static int countdown = 120;
	@SuppressWarnings("unchecked")
	private void permutation(T [] prefix, T [] str) {
		int n = str.length;
		
		
		for(int i = 0 ; i < str.length ; i++)
			if(str[i] == null || str[i] == empty){
				n = i;
				break;
			}
//		for(int ii = 0 ; ii < str.length; ii++)
//        	System.out.print(str[ii] + " ");
//		System.out.println("");
		
		
		
		if (n == 0) { //permArray[_permArrayCounter] =  prefix  ;    		
	    		System.arraycopy(prefix, 0, permArray[_permArrayCounter++], 0, prefix.length);
	    		
//	    		for(int ii = 0 ; ii < prefix.length; ii++){
//	    			permArray[_permArrayCounter][ii] = prefix[ii];
//	    			System.out.print(permArray[_permArrayCounter][ii]);
//	    		}
//	    		System.out.println("");
//	    		_permArrayCounter++;
	    		
	    }
	    else {
	        for (int i = 0; i < n ; i++){
	        	T [] nPrefix = (T[])Array.newInstance(basic, str.length);
	        	for(int _i = 0 ; _i < str.length ; _i++)
	        		nPrefix[_i] = empty;
	        	int _iprefix = 0 ;
	        	
	        	for(int _i = 0 ; _i < prefix.length ; _i++){
	        		nPrefix[_i] = prefix[_i];
	        		if(_iprefix == 0 && prefix[_i] != empty) _iprefix++;
	        		if(i+1 <= prefix.length && prefix[_i+1] != empty)
	        			_iprefix++;
	        		else
	        			break;
	        	}
	        	
	        	
	        	
	    		
	        	T [] c = (T[])Array.newInstance(basic, str.length);
	        	int _ic = 0;
	        	int j = 0;
	        	for(j = 0; j < i; j++)
	        		c[_ic++] = (str[j]);
	        	for(j = i+1; j < str.length; j++)
	        		c[_ic++] = str[j];
	        	if(_iprefix == str.length) {
	        		break;
	        	}
	        	nPrefix[_iprefix] = str[i];
	        	
	            permutation(nPrefix , c);
	            
	            
	        }
	    }
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
	
	public static BigInteger factorial(BigInteger n) {
	    BigInteger factorial = BigInteger.valueOf(1);

	    for (int i = 1; i <= n.intValue(); i++) {
	        factorial = factorial.multiply(BigInteger.valueOf(i));
	    }

	    return factorial;
	} 

	
}
