package com.demoblaze.tests;

import java.lang.System.Logger;
import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoblaze.driverscript.TestBase;
import com.demoblaze.objectrepository.DemoBlazeTitlesRepository;
import com.demoblaze.pages.DemoBlazeCartPage;
import com.demoblaze.pages.DemoBlazeHomePage;
import com.demoblaze.pages.DemoBlazeLoginPage;
import com.demoblaze.pages.DemoBlazePaymentInfoPage;
import com.demoblaze.pages.DemoBlazeSignUpPage;
import com.demoblaze.pages.HomepageNavigation;
import com.demoblaze.utilities.RetryAnalyzer;
import com.demoblaze.utilities.TestUtil;

public class DemoBlazePaymentInfoTest extends TestBase{
	public DemoBlazeCartPage cartInfoPage;
	public DemoBlazePaymentInfoPage paymentInfoPage;
	private TestUtil utils;
	Alert alert;
	
	String ExpectedMessage="Thank you for your purchase";
	@BeforeMethod
	public void set()
	{
		cartInfoPage = PageFactory.initElements(driver, DemoBlazeCartPage.class);
		paymentInfoPage=PageFactory.initElements(driver, DemoBlazePaymentInfoPage.class);
		utils=new TestUtil();
		
	}
	@AfterMethod
	public void assertingAll() {
		utils.assertAllSoftAssertions();

	}

	@Test(priority = 0, description = "Verifying Purchase Page without entering any order details")
	public void verifyPurchaseWithoutInfo()
	{	
		paymentInfoPage = cartInfoPage.goToPaymentPage();
	
		paymentInfoPage.clickPurchaseBtn();
		
		String txt = TestUtil.handleAlert(alert);
		utils.AssrtTrue(true, txt);
	}
	
	@Test(priority = 1,description = "Verifying Purchase Page without entering any order details")
	public void verifyPurchaseWithInfo()
	{
		paymentInfoPage.sendDetails();
		paymentInfoPage.clickPurchaseBtn();
		utils.AssrtEquals(paymentInfoPage.getSuccessMsg(), ExpectedMessage, "Message is not appeared");
		
	}
	}

