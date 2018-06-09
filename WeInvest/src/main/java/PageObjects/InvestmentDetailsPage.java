package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import Utilities.fluentWaits;

public class InvestmentDetailsPage {
	final WebDriver driver ;	
		
	public InvestmentDetailsPage(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 
	 public void verifyPortfolioConstituentValue(String constituentName, String expectedonstituentValue) {
		 String RTD_constituentXpath = "//div[contains(@aria-labelledby,'portfolioConstituent')]//span[contains(text(),'RT_DATA')]/parent::div/following-sibling::div//span[not(contains(text(),'%'))]" ;
		 String constituentXpath = RTD_constituentXpath.replace("RT_DATA", constituentName);
		
		 try{
			 
			 WebElement targetElement = driver.findElement(By.xpath(constituentXpath));
			 
			
			 Assert.assertTrue(targetElement.isDisplayed());
			 
			 String actualConstituentValue = targetElement.getText();
			 
			 if(actualConstituentValue.equals(expectedonstituentValue)) {
				 Assert.assertEquals(actualConstituentValue, expectedonstituentValue);
				System.out.print("The expected Constituent value : " + expectedonstituentValue + " is equal to  actual Constituent value :  " + actualConstituentValue);	
			 }else {
				 System.out.print("The expected Constituent value : " + expectedonstituentValue + " is NOT equal to  actual Constituent value :  " + actualConstituentValue);	
				 Assert.assertEquals(actualConstituentValue, expectedonstituentValue);
					
			 }
			 
			 
			 
			 System.out.println("Test Case Completed");
			 
		 }catch(NoSuchElementException noElementEx) {
			 System.out.println("constituent with Name " + constituentName + "is not found");
			 
			 new fluentWaits(driver).waitUntil("elementToBeVisible", driver.findElement(By.xpath(constituentXpath)));
			 Assert.assertTrue(driver.findElement(By.xpath(constituentXpath)).isEnabled());
 
			 
		}catch(Exception e) {
			System.out.println("Unknown exception found in verifyPortfolioConstituentValue :" + e);
		}
	 }
}
