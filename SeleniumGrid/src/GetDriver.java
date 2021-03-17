import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetDriver {

	public WebDriver loadDriver(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			return loadChromeDriver();
		}
		if(browser.equalsIgnoreCase("firefox")) {
			return loadFirefoxDriver();
		}
		return null;
	}
	
	public ChromeDriver loadChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		return new ChromeDriver();
	}
	
	public FirefoxDriver loadFirefoxDriver() {
		System.setProperty("webdriver.gecko.driver", "D:\\Testing\\Selenium\\geckodriver.exe");
		return new FirefoxDriver();
	}

}
