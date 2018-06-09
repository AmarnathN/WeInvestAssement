package PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;



public class WeinvestHomePage {
	
	final WebDriver driver ;	
	 @FindBy(how = How.XPATH, using = "//div[.='All Weather Strategy']/ancestor::div[@class='model-portfolio-container']//a[contains(text(),'Explore Investment Ideas')]")
	 
	 static WebElement ExploreInvestmentIdeas_WeatherLink;
	 
	
	 public WeinvestHomePage(WebDriver driver) {
		 this.driver = driver;
	 }
	 
	 public void moveToAllWeatherStrategyInvIdeas() {
		
		try {

			 ExploreInvestmentIdeas_WeatherLink.click();
			 System.out.println("Clicked on ExploreInvestmentIdeas_WeatherLink");
		}catch(Exception e) {
			System.out.println("Exception In clicking ExploreInvestmentIdeas_WeatherLink");
			Assert.assertTrue(false);
		}
			
	 }
	 
	
	 
	 
}
