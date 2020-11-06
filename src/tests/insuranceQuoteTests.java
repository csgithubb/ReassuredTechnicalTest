package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.CompareQuotePage;

public class insuranceQuoteTests {
	public static String baseURL = "https://comparethemarket.com/life-insurance/";	

	public static void main(String[] compareLifeInsuranceQuote) {	
	
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");	
		
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		
		//Initiating your chromedriver
		WebDriver driver = new ChromeDriver(options); 	

		//Applied wait time
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		
		//open browser with desried URL
		driver.navigate().to(baseURL);
		
		// Get single Quote for life Insurance
		CompareQuotePage quotePage = new CompareQuotePage(driver);
		quotePage.clickGetQuote();		
		quotePage.clickSingleQuote();
		quotePage.enterName();
		quotePage.selectDOB();
		quotePage.selectNonSmoker();
		quotePage.selectLevelTerm();
		quotePage.enterSumAssured();
		quotePage.selectCriticalIllnessCover();
		quotePage.enterEmailAddress();
		quotePage.enterPhoneNumber();
		quotePage.enterAddress();
		quotePage.selectDoNotContact();
		quotePage.confirmGetQuote();
		
		//take screenshot and save Quote
		quotePage.waitForExpectedElementtakeScreenshot();
				
		// Get updated quote
		quotePage.removeCriticalCover();
		quotePage.clickUpdateResults();
		
		//take screenshot and save Updated Quote
		quotePage.waitForExpectedElementtakeScreenshot();

		//closing the browser window
		quotePage.closeQuotePage();
		
}
}
