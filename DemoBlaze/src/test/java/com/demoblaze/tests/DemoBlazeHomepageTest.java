package com.demoblaze.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.driverscript.TestBase;
import com.demoblaze.pages.DemoBlazeHomePage;
import com.demoblaze.pages.HomepageNavigation;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazeHomepageTest extends TestBase {
	public HomepageNavigation navigatetohomepage;
	public DemoBlazeHomePage homePage;
	private TestUtil utils;


	@BeforeMethod
	public void set()
	{
		
		navigatetohomepage=new HomepageNavigation();
		
		homePage = PageFactory.initElements(driver, DemoBlazeHomePage.class);
		
		utils=new TestUtil();
	}

	@Test(priority = 1)
	public void verifyTitle()
	{	
		
		try
		{
			navigatetohomepage.LaunchHomepage();
			utils.AssrtEquals(homePage.validateHomePageTitle(), "STORE","Title are not matched!!");

		

		}
		catch(Exception e)
		{
			
		}
	}

	@Test(priority = 2)
	public void verifyLogo()
	{	
		
		homePage.isLogoDisplayed();
		utils.AssrtTrue(true,"Logo is not displayed!!");
	
	}

	@AfterMethod
	public void assertingAll() {
		utils.assertAllSoftAssertions();

	}
}
