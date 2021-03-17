package Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class Day2 {
	
	WebDriver driver;
	
	@Test
	public void Login() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\avina\\OneDrive\\Projects\\Selenium_workspace\\TestNGPractise\\src\\Test\\data.properties");
		prop.load(fis);
		
		System.out.println("Username: " + prop.getProperty("username"));
		
		if(prop.getProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\Testing\\Selenium\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else {
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("URL"));
		
	}
	
	@Test
	public void checkpoint() {
		System.out.println("checkpoint");

	}

}
