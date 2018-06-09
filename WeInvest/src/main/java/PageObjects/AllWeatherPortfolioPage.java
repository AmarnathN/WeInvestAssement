package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import Utilities.fluentWaits;

public class AllWeatherPortfolioPage {
	final WebDriver driver ;	
	 @FindBy(how = How.XPATH, using = "//a[.='Customize Portfolio' and contains(@class,'btn-customize-portfolio')]")
	 static WebElement customisePortfolioLink;
	 
	 @FindBy(how = How.XPATH, using = "//a[.='Customise']")
	 static WebElement customiseLink;
	 
	 @FindBy(how = How.XPATH, using = "//a[.='Rebalance']")
	 static WebElement rebalanceLink;
	
	 
	 @FindBy(how = How.XPATH, using = "//a[.='Invest Now']")
	 static WebElement investLink;
	 
	 
	 public AllWeatherPortfolioPage(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public void verifyCustomisePortfolioLinkPresent () {
		 try{
			 Assert.assertTrue(customisePortfolioLink.isEnabled());
			 System.out.println("Verified Customise Portfolio Link Present");
		 }catch(NoSuchElementException noElementEx) {
			 new fluentWaits(driver).waitUntil("elementToBeVisible", customisePortfolioLink);
			 Assert.assertTrue(customisePortfolioLink.isEnabled());
		}catch(Exception e) {
			System.out.println("Unknown exception found in verifyCustomisePortfolioLinkPresent :" + e);
		}
	 }
	 
	 public void startCustomisePortfolio() {
		 try{
			 customisePortfolioLink.click();
			 System.out.println("Clicked on Customise Portfolio Link Present");
			 
			 new fluentWaits(driver).waitUntil("pageLoaded");
			 Assert.assertTrue(customiseLink.isDisplayed());
			 

			 
			 customiseLink.click();
			 
			 System.out.println("Started Customiszation Of Portfolio");
			 
		 }catch(NoSuchElementException noElementEx) {
			 System.out.println("Customise Link is not found");
			 new fluentWaits(driver).waitUntil("elementToBeVisible", customiseLink);
			 Assert.assertTrue(customiseLink.isEnabled());
 
			 customiseLink.click();
		}catch(Exception e) {
			System.out.println("Unknown exception found in verifyCustomisePortfolioLinkPresent :" + e);
		}
	 }
	 
	 
	 public void UpdateEquityAllocationToGivenValue(String allocationItemName, Integer expectedAllocationPercentageValue) {
		 try{
			 
			
			 
			 WebElement targetElement = driver.findElement(By.xpath("//a[.='"+ allocationItemName +"']/ancestor::div[contains(@class,'constituent-row')]//input[@type='range']"));
			 Integer actualAllocationPercentageValue = Integer.parseInt(targetElement.getAttribute("value"));
			 while(!(actualAllocationPercentageValue==expectedAllocationPercentageValue)) {
			
					 System.out.println("Actual Allocation value : " + actualAllocationPercentageValue + "\n" + "Expected Allocation value : " +expectedAllocationPercentageValue );
					 if(actualAllocationPercentageValue>expectedAllocationPercentageValue) {
						 targetElement.sendKeys(Keys.ARROW_LEFT);
					 }else {
						 targetElement.sendKeys(Keys.ARROW_RIGHT);
					 }
					
					 actualAllocationPercentageValue = Integer.parseInt(targetElement.getAttribute("value"));
					 
					 new fluentWaits(driver).waitUntil("pageLoaded");
			 }
			 
			 
			 System.out.println("Updated " + allocationItemName +" Equity Allocation To GivenValue : " + expectedAllocationPercentageValue);
			 
		 }catch(Exception e) {
			System.out.println("Unknown exception found in UpdateEquityAllocationToGivenValue :" + e);
		}
	 }
	 
	 public void RebalanceAndInvestNowPortfolio() {
		 try{
			 rebalanceLink.click();
			 System.out.println("Clicked on ReBalance");
			 new fluentWaits(driver).waitUntil("pageLoaded");
			 
			 investLink.click();
			 new fluentWaits(driver).waitUntil("pageLoaded");
			 
			 System.out.println("Clicked on Invest Now");
			 
		 }catch(Exception e) {
			System.out.println("Unknown exception found in RebalanceAndInvestNowPortfolio :" + e);
		}
	 }
	 
}
