package com.demoblaze.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.asserts.SoftAssert;

import com.demoblaze.driverscript.TestBase;

public class TestUtil extends TestBase{
	private Actions actions=new Actions(driver);
	public static String screenshotPath;
	public static String screenshotName;
	public static ExcelReader excel = null;
	public SoftAssert softAssert = new SoftAssert();
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;

	public static void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));
		FileUtils.copyFile(scrFile,
				new File(".\\Reports\\" + screenshotName));

	} 
	
	@DataProvider(name="LoginData")
	public Object[][] getData() {
	    if (excel == null) {
	        excel = new ExcelReader(System.getProperty("user.dir") +"\\TestData\\DemoBlazeLoginData.xlsx");
	    }
	    String sheetName = "LoginCredentials";
	    int rows = excel.getRowCount(sheetName);
	    int cols = excel.getColumnCount(sheetName);
	    if (rows <= 1) {
	        throw new RuntimeException("No data found in sheet: " + sheetName);
	    }

	    Object[][] data = new Object[rows - 1][1];
	    Hashtable<String, String> table=null;

	    for (int rowNum = 2; rowNum <= rows; rowNum++) {
	        table = new Hashtable<String,String>();
	        for (int colNum = 0; colNum < cols; colNum++) {
	            String colName = excel.getCellData(sheetName, colNum, 1);
	            String cellData = excel.getCellData(sheetName, colNum, rowNum);
	            table.put(colName, cellData);
	            
	        }
	        data[rowNum - 2][0] = table;
	        
	    }
	    return data;
	}

	

	public static boolean isTestRunnable(String testName, ExcelReader excel){

		String sheetName="test_suite";
		int rows = excel.getRowCount(sheetName);		

		for(int rNum=2; rNum<=rows; rNum++){			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);			
			if(testCase.equalsIgnoreCase(testName)){				
				String runmode = excel.getCellData(sheetName, "Runmode", rNum);				
				if(runmode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}						
		}
		return false;
	} 




	    /**
	     * Move the mouse to the specified element.
	     *
	     * @param element WebElement to hover over
	     */
	    public void hoverOverElement(WebElement element) {
	        actions.moveToElement(element).perform();
	    }

	    /**
	     * Click on the specified element.
	     *
	     * @param element WebElement to click
	     */
	    public void clickElement(WebElement element) {
	    	actions.moveToElement(element).click().perform();
	    }

	    /**
	     * Double-click on the specified element.
	     *
	     * @param element WebElement to double-click
	     */
	    public void doubleClickElement(WebElement element) {
	        actions.doubleClick(element).perform();
	    }

	    /**
	     * Right-click (context-click) on the specified element.
	     *
	     * @param element WebElement to right-click
	     */
	    public void rightClickElement(WebElement element) {
	        actions.contextClick(element).perform();
	    }

	    /**
	     * Type text into the specified element.
	     *
	     * @param element WebElement to type into
	     * @param text    Text to type
	     */
	    public void typeText(WebElement element, String text) {
	        element.sendKeys(text);
	    }
	    public void performAllActions() {
	        actions.perform();
	    }
	    
	    //=============================
		public void AssrtEquals(String ActualValue, String ExpectedValue, String comments) {
			softAssert.assertEquals(ActualValue,ExpectedValue,comments );
		}
		public void AssertEquals(int i, int j) {
			softAssert.assertEquals(i,j);
		}
		public void AssrtNotEquals(String ActualValue, String ExpectedValue, String comments) {
			softAssert.assertEquals(ActualValue,ExpectedValue,comments);
		}
		public void AssrtTrue(boolean True, String comments) {
			softAssert.assertTrue(True,comments);
		}
		public void AssrtFalse(boolean False,String Comments) {
			softAssert.assertTrue(False,Comments);
		}
		

		public void assertAllSoftAssertions() {
			softAssert.assertAll();
		}
		
		//=============================
		
		
		public static void explicitWait(int Seconds, WebElement ele)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Seconds));
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		
		public static void JSClick(WebElement element)
		{
			TestUtil.explicitWait(10, element);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", element);
			
		}
		
		
		public static void sendKeys(WebElement element, String txt)
		{
			TestUtil.explicitWait(10, element);
			element.clear();
			element.sendKeys(txt);
		}
		
		public static void clickOn(WebElement element)
		{
			TestUtil.explicitWait(10, element);
			element.click();
		}
		
		public static String handleAlert(Alert alert)
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			String alertTxt = alert.getText();
			alert.accept();
			
			return alertTxt;
		}
		
		public static String randomString()
		{
			String generatedString = RandomStringUtils.randomAlphabetic(8);
			return generatedString;
		}

		
}


