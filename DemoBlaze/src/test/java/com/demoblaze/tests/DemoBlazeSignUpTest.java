package com.demoblaze.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.driverscript.TestBase;
import com.demoblaze.pages.DemoBlazeHomePage;
import com.demoblaze.pages.DemoBlazeSignUpPage;
import com.demoblaze.pages.HomepageNavigation;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazeSignUpTest extends TestBase{
	public HomepageNavigation navigatetohomepage;
	public DemoBlazeHomePage homePage;
	public DemoBlazeSignUpPage signUpPage;
	private TestUtil utils;
	Alert alert;
	//public static Logger logger=LogManager.getLogger(DemoBlazeHomepageTest.class);;

	@BeforeMethod
	public void set()
	{
		//logger=LogManager.getLogger(DemoBlazeHomepageTest.class);
		navigatetohomepage=new HomepageNavigation();
		
		homePage = PageFactory.initElements(driver, DemoBlazeHomePage.class);
		signUpPage=PageFactory.initElements(driver, DemoBlazeSignUpPage.class);
		//logger.info("Initiating HomePage Contructor");
		utils=new TestUtil();
		
	}
	@AfterMethod
	public void assertingAll() {
		utils.assertAllSoftAssertions();

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
	public void registerUser()
	{
		
		String Randompwd = utils.randomString();	// Creating random string for username and password
		String Generatedusername = Randompwd+"@gmail.com";
		signUpPage = homePage.goToSignUpPage();
		System.out.println("Registering new user on DemozBlaze "+"User: "+Generatedusername);
		System.out.println("Pass word is ,"+ Randompwd);
		signUpPage.EntersignupUserName(Generatedusername);
		signUpPage.EnterPasword(Randompwd);
		signUpPage.ClickonsignUp();
		
		
		String txt = utils.handleAlert(alert);	// Handling expected alert
		
		try
		{
		utils.AssrtEquals(txt,"Sign up successful.", "Alert message not valid");		// Validating pop up's message
	 	
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	
	}

}
