import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteTest {

	public static void main(String[] args) throws MalformedURLException {

		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setPlatform(Platform.WINDOWS);
		dc.setBrowserName("chrome");
		
		WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.2:4444/wd/hub"), dc);
		
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
		
	}

}
