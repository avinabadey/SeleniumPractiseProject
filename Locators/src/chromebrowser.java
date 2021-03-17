import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class chromebrowser {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://facebook.com");
		/*driver.findElement(By.className("inputtext")).sendKeys("Hello1");
		driver.findElement(By.className("inputtext")).sendKeys("Hello2");	//will append to Hello1
		*/
		
		System.out.println(driver.getTitle());	//verify page title
		System.out.println(driver.getCurrentUrl());	//verify page URL
		//System.out.println(driver.getPageSource());	//print page source
		
		/*driver.findElement(By.id("email")).sendKeys("first test");
		driver.findElement(By.name("pass")).sendKeys("pwd");
		driver.findElement(By.partialLinkText("Forgotten account?")).click();
		*/
		
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testxpath");
		driver.findElement(By.cssSelector("#pass")).sendKeys("pwdcss");
		driver.findElement(By.cssSelector("#u_0_2")).click();
				
		//driver.navigate().back();
		//driver.close();	//closes current browser
		//driver.quit();	//closes all browsers opened by selenium script
		
	}
}
