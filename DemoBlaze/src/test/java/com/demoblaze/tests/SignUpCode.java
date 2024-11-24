package com.demoblaze.tests;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpCode {
	public static WebDriver driver;
	public static String url="https://www.demoblaze.com/index.html";
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","E:\\Drivers October 2024\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co=new ChromeOptions();
		// Add options for Chrome driver if needed (e.g., headless mode)
		//co.setBinary(".//Drivers//chrome-headless-shell.exe");
		driver=new ChromeDriver(co);
		driver.get(url);
		System.out.println("Launch Application");
		String SignUpId="login2";
		WebElement signupLink=driver.findElement(By.id(SignUpId));
		signupLink.click();
		System.out.println("Clicked on signup Link");
		String signupUserName="//input[@id='loginusername']";
		//Retrieve number of window id's list
				//System.out.println(driver.getWindowHandles());
				//[6119AB21D03FAEF8732E560C33443635, AFC8308403EC973141B539CF8FF96B2A]
				//Retrive Window's ID
				Set<String> WindowID=driver.getWindowHandles();
				Iterator<String> iterator=WindowID.iterator();
				//Stores the values of respective windows
				String Parent=iterator.next();//Main window
				//Displaying parent window id
				System.out.println("Main Window id is :"+Parent);
				String Child=iterator.next();//Child window
				//Displaying child window id
				System.out.println("Child window id is :"+Child);
				
				
				//switching the control to child
				driver.switchTo().window(Child);
				System.out.println("Child Window is Activated");
				driver.manage().window().maximize();
				WebElement Susername=driver.findElement(By.xpath(signupUserName));
				Susername.sendKeys("Bharath@gamail.com");
				System.out.println("Username Enetered");
				//Closing the child window
				driver.close();
				//Switching the control to parent windows 
				driver.switchTo().window(Parent);
				System.out.println("Parent window is activated");

		


		driver.close();
		System.out.println("Window is closed");

	}

}
