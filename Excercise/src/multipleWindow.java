import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class multipleWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","D:\\Testing\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/sigNup");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());	//verify page title
		System.out.println(driver.getCurrentUrl());	//verify page URL
		
		driver.findElement(By.xpath("//*[@class='Bgzgmd']/li[3]/a")).click();
		Thread.sleep(3000);
		Set<String>ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());	//verify page title
		System.out.println(driver.getCurrentUrl());	//verify page URL
	
		driver.switchTo().window(parentid);
		System.out.println(driver.getTitle());	//verify page title
		System.out.println(driver.getCurrentUrl());	//verify page URL
	}

}
