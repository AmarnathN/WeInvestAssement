package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class fluentWaits {
	public static FluentWait<WebDriver> wait;
	public static WebElement element = null ;
	
	public fluentWaits(WebDriver driver){
		wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(50,  TimeUnit.NANOSECONDS);
		wait.withTimeout(30, TimeUnit.SECONDS);
		wait.ignoring(NoSuchElementException.class);
	}

	static Function<WebDriver, Boolean> pageLoaded = new Function<WebDriver, Boolean>()
		{
			public Boolean apply(WebDriver driver) {
				JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
				
					boolean result =jsDriver.executeScript("return document.readyState").equals("complete");
					
					//	System.out.println("Page Loaded :" + result);
						if(result)
						{
				//			System.out.println("Target element found");
							return true;
							
						}
					

						System.out.println("Waiting for page to load");
				
						return false;
				
			};
		};
		static Function<WebDriver, Boolean> elementToBeVisible = new Function<WebDriver, Boolean>()
		{
			public Boolean apply(WebDriver driverArg) {
				
				boolean res = element.isDisplayed();
				if(res)
				{
					System.out.println("Target element found");
					return true;
					
				}
				System.out.println("Waiting for element to be visible");
				return false;
				}
			};	
			
		public boolean waitUntil(String functionName){
			
			switch (functionName){
			
			
			case "pageLoaded" :{
				wait.withTimeout(100, TimeUnit.SECONDS);
				return wait.until(pageLoaded);
			}
							
			default :
				return false;
			
			}
		}
		
		public boolean waitUntil(String functionName, WebElement webElement){
			
			switch (functionName){
			
			case "elementToBeVisible" :
				element = webElement;
				return wait.until(elementToBeVisible);
				
			default :
				return false;
			
			}
		}
			
	
	
}

