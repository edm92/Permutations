package be.fnord.Sample;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;

import be.fnord.Combinations.CombinationGenerator;
import be.fnord.PartitionedLists.OrderConstrainedPartitionList;
import be.fnord.PartitionedLists.PartitionList;
import be.fnord.PartitionedLists.PartitionListElement;
import be.fnord.PartitionedLists.PartitionListItem;
import be.fnord.Permutations.PermutationController;
import be.fnord.Permutations.PermutationGenerator;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Example 
 *
 */
public class SamplePermutation 
{
	public static boolean TESTMODE = true;
	public static int countedPerms = 0;
	public static int countedListsElements = 0;
    public static void main( String[] args )
    {
    	TESTMODE = false;
//    	runArrayPermutationExample("evan");
//    	runPermutationExample("evan");
//    	checkResult("24");
    	
    	PermutationGenerator cr = new PermutationGenerator(4);
    	
		while(cr.hasMore()){
			int [] i = cr.getNext();
			for(int ii = 0 ; ii < i.length ; ii++)
				System.out.print(i[ii] + " ");
			System.out.println("");
		}

    }
	@When("^I merge two lists I should get \"([^\"]*)\"$")
	public static void runOrderedListExample(String _compareTo) {
		try{
			int compareTo = Integer.parseInt(_compareTo);
			System.out.println("I counded " + countedPerms + " permutations of the string.");

	    	System.out.println("Ordered Lists");    	
			// Example of creating a set and partitioning it:
			System.out
					.println("Starting by creating a partitioned set of 4 elements:");
			PartitionListElement<String> list = new PartitionListElement<String>();
			list.add("one");
			list.add("two");
			list.add("three");
			list.add("four");
			// Call the make partition function to put into all possible partitions
			PartitionList<String> results = OrderConstrainedPartitionList
					.makePartitions(list);
	
			// Display results
			for (PartitionListItem<String> newPartition : results) {
				System.out.println("Partition: " + newPartition.toString());
			}
	
			System.out
					.println("Now creating a second partitioned set of 3 elements.");
	
			// Next we create a second partitioned set
			PartitionListElement<String> list2 = new PartitionListElement<String>();
			list2.add("A");
			list2.add("B");
			list2.add("C");
			PartitionList<String> results2 = OrderConstrainedPartitionList
					.makePartitions(list2);
			// Display results
			for (PartitionListItem<String> newPartition : results2) {
				System.out.println("Partition: " + newPartition);
				
			}
	
			// Join both sets
			PartitionList<String> results3 = OrderConstrainedPartitionList
					.joinSets(results, results2);
			System.out.println("Showing all merged sets:");
			for (PartitionListItem<String> newPartition : results3) {
				System.out.println("Partition: " + newPartition);
				countedListsElements++;
			}
			
			if(TESTMODE)
				org.junit.Assert.assertTrue("Checking if " + compareTo + " -eq " + countedListsElements, ((boolean) (compareTo == countedListsElements)));
			
			System.out
					.println("Now creating a Third partitioned set of 3 elements.");
	
			// Next we create a second partitioned set
			PartitionListElement<String> list3 = new PartitionListElement<String>();
			list3.add("z");
			list3.add("y");
			list3.add("x");
			PartitionList<String> results4 = OrderConstrainedPartitionList
					.makePartitions(list3);
			// Display results
			for (PartitionListItem<String> newPartition : results4) {
				System.out.println("Partition: " + newPartition);
			}
	
			try {
				// Create file
				FileWriter fstream = new FileWriter("out.txt");
				BufferedWriter out = new BufferedWriter(fstream);
	
				// Join all sets
				PartitionList<String> results6 = OrderConstrainedPartitionList
						.joinPartitionedSets(results3, results4);
				System.out.println("Saving all merged sets to out.txt");
				for (PartitionListItem<String> newPartition : results6) {
					// System.out.println("Partition: " + newPartition);
					out.write("Partition: " + newPartition + "\n");
				}
	
				out.close();
	
			} catch (Exception e) {// Catch exception if any
				if(TESTMODE)
					org.junit.Assert.assertTrue("Failed to check results " + e.getMessage(), false);
				else
					e.printStackTrace();
				
			}
			System.out.println("Save is complete. ");
			
		}catch(Exception e){
			if(TESTMODE)
				org.junit.Assert.assertTrue("Failed to check results " + e.getMessage(), false);
			else
				e.printStackTrace();
		}

	}
	
	

	@Then("^I should get \"([^\"]*)\" permutation results$")
	public static void checkResult(String _compareTo){
		try{
			int compareTo = Integer.parseInt(_compareTo);
			System.out.println("I counded " + countedPerms + " permutations of the string.");
			if(TESTMODE)
				org.junit.Assert.assertTrue("Checking if " + compareTo + " -eq " + countedPerms, ((boolean) (compareTo == countedPerms)));
		}catch(Exception e){
			if(TESTMODE)
				org.junit.Assert.assertTrue("Failed to check results " + e.getMessage(), false);
			else
				e.printStackTrace();
		}
	}
	
	@When("^I run a permutation over \"([^\"]*)\"$")
	public static void runPermutationExample(String input) {
		try{
			
			System.out.println("Running permutator");
			// Example
			LinkedList<String> perms = new LinkedList<String>();
			String word = input;
			for(char c : word.toCharArray())
				perms.add("" + c);
			System.out.println("Perms = " + perms);
			PermutationController<String> p = new PermutationController<String>();
			p.permutation(perms);
			while(p.hasNext()){
				System.out.println(p.getNextListItem().toString());
				countedPerms++;
			}
			
			if(countedPerms > 0){
				if(TESTMODE)
					org.junit.Assert.assertTrue("Successfully generated a permutation", true);
			}else
				if(TESTMODE)
					org.junit.Assert.assertTrue("Failed to generate a permutation", false);
			System.out.println("End");
		}catch(Exception e){
			if(TESTMODE)
				org.junit.Assert.assertTrue("Failed to check results " + e.getMessage(), false);
			else
				e.printStackTrace();
		}
	}
	
    public static void runArrayPermutationExample(String input) {
    	System.out.println("Running permutator");
    	Character [] letters2 = toCharacterArray(input);
    	PermutationController<Character> p = new PermutationController<Character>();
		p.permutation(Character.class, letters2, '~');
		while(p.hasNext()){
			System.out.print("Got new one " );
			Character [] res = p.getNextArrayItem();
			for(int i = 0 ; i < res.length ; i++)
				System.out.print(res[i]);
			System.out.println("");
		}
		
	}
    
    public static Character[] toCharacterArray( String s ) {

    	   if ( s == null ) {
    	     return null;
    	   }

    	   int len = s.length();
    	   Character[] array = new Character[len];
    	   for (int i = 0; i < len ; i++) {
    	      array[i] = new Character(s.charAt(i));
    	   }

    	   return array;
    	}


}
