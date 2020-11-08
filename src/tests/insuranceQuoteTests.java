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
		quotePage.enterName("Insurance", "Quote");
		quotePage.selectDOB("6","1","1980");
		quotePage.selectNonSmoker();
		quotePage.selectLevelTerm("20");
		quotePage.enterSumAssured("250000");
		quotePage.selectCriticalIllnessCover("15000");
		quotePage.enterEmailAddress("widecem309@mailreds.com");
		quotePage.enterPhoneNumber("07812120038");
		quotePage.enterAddress("7", "RG1 6NY");
		quotePage.selectDoNotContact();
		quotePage.confirmGetQuote();
		
		//take screenshot and save Quote
		quotePage.waitForExpectedElementtakeBeforeScreenshot();
				
		// Get updated quote
		quotePage.removeCriticalCover();
		quotePage.clickUpdateResults();
		
		//take screenshot and save Updated Quote
		quotePage.waitForExpectedElementtakeAfterScreenshot();

		//closing the browser window
		quotePage.closeQuotePage();
		
}
}
