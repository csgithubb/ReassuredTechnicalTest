package PageObjects;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareQuotePage 
{
	WebDriver driver;
	
	public CompareQuotePage(WebDriver d)
	{
		this.driver = d;
	}

	public void clickGetQuote()
	{
		WebElement insuranceQuote = driver.findElement(By.id("LifeInsurance_LifeInsurance_LifeHeroBlock_GetAQuoteCTA"));	
		insuranceQuote.click();
	}
	
	public void clickSingleQuote()
	{
		WebElement clickJM = driver.findElement(By.id("LifeInsurance_YourDetails_YourDetails_WhoToCover_JM"));	
		clickJM.click();
	}
	
	public void enterName(String forename, String surname)
	{
		driver.findElement(By.id("LifeInsurance_YourDetails_YourDetails_YourTitle_MR")).click();
		WebElement firstname = driver.findElement(By.id("LifeInsurance_YourDetails_YourDetails_YourFirstName"));
		firstname.sendKeys(forename);
		WebElement lastname = driver.findElement(By.id("LifeInsurance_YourDetails_YourDetails_YourLastName"));
		lastname.sendKeys(surname);
	}
	
	public void selectDOB(String day, String month, String year)
	{
		WebElement selectDay = driver.findElement(By.id("LifeInsurance_YourDetails_YourDetails_YourDateOfBirth_Day"));	
		selectDay.click();
		Select DOBday = new Select(selectDay);
		DOBday.selectByValue(day);
		
		WebElement selectMonth = driver.findElement(By.id("LifeInsurance_YourDetails_YourDetails_YourDateOfBirth_Month"));	
		selectDay.click();
		Select DOBMonth = new Select(selectMonth);
		DOBMonth.selectByValue(month);
		
		WebElement selectYear = driver.findElement(By.id("LifeInsurance_YourDetails_YourDetails_YourDateOfBirth_Year"));	
		selectYear.click();
		Select DOBYear = new Select(selectYear);
		DOBYear.selectByValue(year);
		
	}
	
	public void selectNonSmoker()
	{
		WebElement selectNonSmoker = driver.findElement(By.id("LifeInsurance_YourDetails_YourDetails_YourSmoke_NO"));	
		selectNonSmoker.click();
	}
	
	public void selectLevelTerm(String levelTerm)
	{
		WebElement selectLevelTerm = driver.findElement(By.id("LifeInsurance_YourDetails_YourLifeCover_CoverType_LT"));	
		selectLevelTerm.click();
		WebElement selectLevelYears = driver.findElement(By.id("LifeInsurance_YourDetails_YourLifeCover_TermYears"));	
		selectLevelYears.sendKeys(levelTerm);		
	}
	
	public void enterSumAssured(String value)
	{
		WebElement sumAssured = driver.findElement(By.id("LifeInsurance_YourDetails_YourLifeCover_CoverAmount"));	
		sumAssured.sendKeys(value);
	}
	
	public void selectCriticalIllnessCover(String amountOfCover)
	{
		WebElement clickCriticalCoverYes = driver.findElement(By.id("LifeInsurance_YourDetails_YourLifeCover_CriticalIllnessCover_YES"));	
		clickCriticalCoverYes.click();
		WebElement clickCriticalCoverAdditional = driver.findElement(By.id("LifeInsurance_YourDetails_YourLifeCover_CriticalIllnessCoverType_A"));	
		clickCriticalCoverAdditional.click();
		WebElement enterCriticalCoverAmount = driver.findElement(By.id("LifeInsurance_YourDetails_YourLifeCover_CriticalIllnessAmount"));	
		enterCriticalCoverAmount.sendKeys(amountOfCover);
	}
	
	public void enterEmailAddress(String email)
	{
		WebElement enterEmail = driver.findElement(By.id("LifeInsurance_YourDetails_YourContactDetails_EmailAddress"));	
		enterEmail.sendKeys(email);
	}
	
	public void enterPhoneNumber(String value)
	{
		WebElement enterPhone = driver.findElement(By.id("LifeInsurance_YourDetails_YourContactDetails_PhoneNumber"));	
		enterPhone.sendKeys(value);
	}
	
	public void enterAddress(String houseNo, String postcode)
	{
		WebElement enterHouseNumber = driver.findElement(By.id("LifeInsurance_YourDetails_YourContactDetails_Address_HouseNumberOrName"));	
		enterHouseNumber.sendKeys(houseNo);
		WebElement enterPostCode = driver.findElement(By.id("LifeInsurance_YourDetails_YourContactDetails_Address_Postcode"));	
		enterPostCode.sendKeys(postcode);
		WebElement clickFindAddress = driver.findElement(By.id("Address_FindMyAddress"));	
		clickFindAddress.click();
	}
	
	public void selectDoNotContact()
	{
		WebElement clickDoNotContact = driver.findElement(By.id("LifeInsurance_YourDetails_ContactPreferences_ContactPreferences_doNotContact"));	
		clickDoNotContact.click();
	}
	
	public void confirmGetQuote()
	{
		WebElement clickConfirm = driver.findElement(By.id("LifeInsurance_YourDetails_TheLegalBit_AcceptTermsAndConditions"));	
		clickConfirm.click();
		WebElement clickGetQuote = driver.findElement(By.className("Submitter__actions__button"));	
		clickGetQuote.click();		
	}
	
	public void removeCriticalCover()
	{
		WebElement clickRemoveCriticalCover = driver.findElement(By.id("LifeInsurance_YourQuotes_Filter_CriticalIllnessCover_Remove"));	
		clickRemoveCriticalCover.click();
	}
	
	public void clickUpdateResults()
	{
		WebElement updateResultsNewQuote = driver.findElement(By.id("LifeInsurance_YourQuotes_Filter_FilterResults_UpdateResults"));	
		updateResultsNewQuote.click();		
	}
	
	public void waitForExpectedElementtakeScreenshot()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//H2[text()='Summary of key details']")));	
				
		//Take the screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        //Copying the file to a location and using try catch block to handle exception
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\chris\\eclipse-workspace\\ReassuredTest\\Screenshots\\Quote.png"));         
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
	}
	
	public void closeQuotePage()
	{
		driver.close();
		driver.quit();
	}
	

}
