import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class testCase3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//IEDriverServer for IE
		//MicrosoftWebDriver for EDGE
		
		System.setProperty("webdriver.ie.driver", "D:\\Testing\\Selenium\\MicrosoftWebDriver.exe");
		WebDriver driver=new InternetExplorerDriver();
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		

	}

}
