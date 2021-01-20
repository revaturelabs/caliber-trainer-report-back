package com.revature.cucumber.steps;

import org.junit.AfterClass;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;

/*features files
"src/test/resources/GraphDoubleClick.feature"
"src/test/resources/OverviewLineGraph.feature"
"src/test/resources/Calendar.feature"
"src/test/resources/pdf.feature"
"src/test/resources/Caliber.feature"
 
glue "com.revature.cucumber.steps"
*/

@Disabled
public class TestRunner {
	
	@AfterClass
	static public void tearDown() {
		CalendarNavigationStep.driver.quit();
		OverviewStepImpl.browser.quit();
		PDFTestImpl.browser.quit();
		PullingCaliberDataStepImpl.driver.quit();
	}
}
