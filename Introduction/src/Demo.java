import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://google.com");	//load URL to browser
				
		System.out.println(driver.getTitle());	//verify page title
		System.out.println(driver.getCurrentUrl());	//verify page URL
		//System.out.println(driver.getPageSource());	//print page source
		
		
		driver.navigate().back();
		driver.close();	//closes current browser
		//driver.quit();	//closes all browsers opened by selenium script
		
		
		
		
	}

}
