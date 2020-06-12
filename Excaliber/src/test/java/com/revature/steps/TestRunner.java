package com.revature.steps;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

(
		features = {"src/test/resources/CatAppHome.feature", "src/test/resources/PokeAPI.feature"},
		glue = {"com.revature.steps"}
)
@RunWith(value = null)
public class TestRunner extends AbstractTestNGCucumberTests {
	
	}
