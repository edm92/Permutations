package be.fnord.Permutator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
features = {"features"}
)


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	

	 @BeforeClass
	    public static void doYourOneTimeSetup() {
		 init();
	    }
	  @AfterClass
	    public static void doYourOneTimeTeardown() throws InterruptedException {

	    }   

	  public static void init(){
		  // Nothing
	  }
	  
	public static boolean stillRunning = true;
	
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
}
