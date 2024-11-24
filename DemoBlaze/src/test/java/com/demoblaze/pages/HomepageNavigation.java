package com.demoblaze.pages;

import org.testng.annotations.Test;

import com.demoblaze.driverscript.TestBase;
/**
 * This class represents the HomepageNavigation test case for the "mystore" module.
 * It extends the TestBase class, which provides common test setup and teardown functionality.
 */
public class HomepageNavigation extends TestBase  {
	/**
     * This test method launches the homepage of the "mystore" application.
     *
     * It checks the "module" property in the configuration file. If it's equal to "mystore",
     * it navigates to the URL specified in the "DemoBlazeurl" property. Otherwise,
     * it prints an error message indicating an issue with the URL.
     */
  @Test
  public void LaunchHomepage(){
		if(config.getProperty("module").equalsIgnoreCase("DemoBlaze")) {
			  driver.get(config.getProperty("DemoBlazeurl"));
			  System.out.println("Launched targetted website");
			  }else {
				  System.out.println("Issue with the url: "+config.getProperty("DemoBlazeurl"));
	  }
	 
	}

}
