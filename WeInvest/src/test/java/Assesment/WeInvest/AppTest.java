package Assesment.WeInvest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.AllWeatherPortfolioPage;
import PageObjects.InvestmentDetailsPage;
import PageObjects.WeinvestHomePage;
import Utilities.WebDriverManager;
import Utilities.fluentWaits;

public class AppTest 
  
{
	@Test
    public void Testcase() {
    	
		WebDriver driver = new WebDriverManager().getNewWebDriver("Chrome");

		driver.get("http://beta.weinvest.net/model-portfolio");

		new fluentWaits(driver).waitUntil("pageLoaded");
		
		
		WeinvestHomePage homePage = PageFactory.initElements(driver, WeinvestHomePage.class);
		
		AllWeatherPortfolioPage allWeatherPortfolioPage = PageFactory.initElements(driver, AllWeatherPortfolioPage.class);
		
		InvestmentDetailsPage investmentDetailsPage = PageFactory.initElements(driver, InvestmentDetailsPage.class);
		
		homePage.moveToAllWeatherStrategyInvIdeas();
		
		allWeatherPortfolioPage.verifyCustomisePortfolioLinkPresent();
		
		allWeatherPortfolioPage.startCustomisePortfolio();
		
		allWeatherPortfolioPage.UpdateEquityAllocationToGivenValue("SPDR S&P 500 ETF TRUST  SPY US EQUITY",50);
		
		allWeatherPortfolioPage.RebalanceAndInvestNowPortfolio();
		
		investmentDetailsPage.verifyPortfolioConstituentValue("SPDR", "50");
		
    }
}
