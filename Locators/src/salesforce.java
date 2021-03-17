import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class salesforce {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://login.salesforce.com/");
		
		System.out.println(driver.getTitle());	//verify page title
		System.out.println(driver.getCurrentUrl());	//verify page URL
		//System.out.println(driver.getPageSource());	//print page source
		
		//driver.findElement(By.id("username")).sendKeys("test");
		//driver.findElement(By.name("pw")).sendKeys("pwd");
		//driver.findElement(By.className("button r4 wide primary")).click();	//invalid selector: Compound class names not permitted
		
		//below is xpath sample
		/*driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("pwd");
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		*/
		//below is CSS selector sample
		driver.findElement(By.cssSelector("#username")).sendKeys("testcss");
		driver.findElement(By.cssSelector("#password")).sendKeys("pwdcss");
		driver.findElement(By.cssSelector("#Login")).click();
		System.out.println(driver.findElement(By.cssSelector("#error")).getText());
		
		//driver.navigate().back();
		//driver.close();	//closes current browser
		//driver.quit();	//closes all browsers opened by selenium script
		
	}
}
