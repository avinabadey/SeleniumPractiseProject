import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandleSSL {

	public static void main(String[] args) {
		
		DesiredCapabilities c = new DesiredCapabilities();
		c.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		c.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.merge(c);
		
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		/*FirefoxProfile fp = new FirefoxProfile();
		fp.setAcceptUntrustedCertificates(true);
		fp.setAssumeUntrustedCertificateIssuer(false);
		
		System.setProperty("webdriver.gecko.driver", "D:\\Testing\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();*/
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().fullscreen();	//only applicable for gecko driver 0.17 and above
		driver.navigate().to("https://cacert.org/");		
		
	}

}
