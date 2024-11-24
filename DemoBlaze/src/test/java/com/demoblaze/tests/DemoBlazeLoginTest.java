package com.demoblaze.tests;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.driverscript.TestBase;
import com.demoblaze.objectrepository.DemoBlazeTitlesRepository;
import com.demoblaze.pages.DemoBlazeHomePage;
import com.demoblaze.pages.DemoBlazeLoginPage;
import com.demoblaze.pages.DemoBlazeSignUpPage;
import com.demoblaze.pages.HomepageNavigation;
import com.demoblaze.utilities.RetryAnalyzer;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazeLoginTest extends TestBase{
	public HomepageNavigation navigatetohomepage;
	public DemoBlazeHomePage homePage;
	public DemoBlazeLoginPage LoginPage;
	private TestUtil utils;
	Alert alert;
	//Declring Expected titles
	String Expected_Home_PageTitle=DemoBlazeTitlesRepository.HomePageTitle;
	String Expected_Login_PageTitle=DemoBlazeTitlesRepository.LoginPageTitle;


	@BeforeMethod
	public void set()
	{
		//logger=LogManager.getLogger(DemoBlazeHomepageTest.class);
		navigatetohomepage=new HomepageNavigation();
		
		homePage = PageFactory.initElements(driver, DemoBlazeHomePage.class);
		LoginPage=PageFactory.initElements(driver, DemoBlazeLoginPage.class);
		//logger.info("Initiating HomePage Contructor");
		utils=new TestUtil();
		
	}
	@AfterMethod
	public void assertingAll() {
		utils.assertAllSoftAssertions();

	}

	@Test(dataProviderClass = com.demoblaze.utilities.TestUtil.class, dataProvider ="LoginData",retryAnalyzer = RetryAnalyzer.class)
	public void LoginUser(Hashtable<String,String> data) throws Exception{
		try
		{
			navigatetohomepage.LaunchHomepage();
			utils.AssrtEquals(homePage.validateHomePageTitle(), Expected_Home_PageTitle,"Title are not matched!!");



		}
		catch(Exception e)
		{
			e.getMessage();
		}
		String Res=data.get("Result");
		switch (Res) {
		case "Valid":
			LoginPage.enterUserName(data.get("Username"));
			LoginPage.enterPassword(data.get("Password"));	
			LoginPage.clickonLogin();
			utils.AssrtEquals(homePage.validateHomePageTitle(), Expected_Login_PageTitle, "Titles are not matched");
			break;

		case "Invalid":
			LoginPage.enterUserName(data.get("Username"));
			LoginPage.enterPassword(data.get("Password"));
			LoginPage.clickOnClose();
			utils.AssrtEquals(homePage.validateHomePageTitle(), Expected_Home_PageTitle,"Title are not matched!!");
			break;
		}	
		
	}
	}

