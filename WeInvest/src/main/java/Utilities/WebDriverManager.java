package Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverManager {

	
	
	public WebDriver getNewWebDriver(String browserName) {
		WebDriver driver = null;
		switch(browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("test-type");
//			capabilities.setCapability("chrome.binary", "Artifacts\\resourses\\chromedriver.exe");
//			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			
			System.out.println(driver);
			break;
		default :
			System.out.println("Invalid Browser name");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
	}


	
}
