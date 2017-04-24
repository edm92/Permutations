package be.fnord.Permutator;

import org.junit.Test;

import be.fnord.Combinations.CombinationGenerator;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Testables {

	@Test
	public void testCombinator(){
		CombinationGenerator cr = new CombinationGenerator(15,7);
		while(cr.hasMore()){
			int [] i = cr.getNext();
			for(int ii = 0 ; ii < i.length ; ii++)
				System.out.print(i[ii] + " ");
			System.out.println("");
		}
	}


    @When("^I run a permutation over \"([^\"]*)\"$")
    public void i_run_a_permutation_over(String arg1) throws Throwable {
        assert(true);
    }

    @Then("^I should get \"([^\"]*)\" permutation results$")
    public void i_should_get_permutation_results(String arg1) throws Throwable {
    	assert(true);
    }

    @When("^I merge two lists I should get \"([^\"]*)\"$")
    public void i_merge_two_lists_I_should_get(String arg1) throws Throwable {
    	assert(true);
    }
}
