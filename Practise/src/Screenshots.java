import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.os.WindowsUtils;

import com.google.common.io.Files;

public class Screenshots {

	public static void main(String[] args) throws IOException {
		
		GetDriver get = new GetDriver();
		
		//the following code kills process by name
		//WindowsUtils.killByName("excel.exe");
		
		WebDriver driver = get.loadChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.guru99.com/take-screenshot-selenium-webdriver.html");
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("D:\\sc.png"));
		
		//FileUtils.copyFile(src, new File("D:\\sc.png"));	//requires IO jar from Apache
		
		//the following line kills all driver processes that keep running in the background after test run is complete
		WindowsUtils.killByName("chromedriver.exe");
	
	}

}
