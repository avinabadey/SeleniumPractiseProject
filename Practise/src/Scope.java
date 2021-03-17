import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "D:\\Testing\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.navigate().to("http://www.qaclickacademy.com/practice.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int lcount = driver.findElements(By.tagName("a")).size();
		System.out.println(lcount);
		
		WebElement footerdriver = driver.findElement(By.xpath("//*[@id='gf-BIG']"));
		int flcount = footerdriver.findElements(By.tagName("a")).size();
		System.out.println(flcount);

		WebElement columndriver = driver.findElement(By.xpath("//table/tbody/tr/td/ul"));
		int clcount = columndriver.findElements(By.tagName("a")).size();
		System.out.println(clcount);
		
		for(int i=1;i<clcount;i++) {
			String cntrlclick = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(cntrlclick);
					
		}
		Thread.sleep(5000);	
				
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		
		while(it.hasNext()){
			String wid = it.next();
			driver.switchTo().window(wid);
			Thread.sleep(1000);
			System.out.println(driver.getTitle());
		}
	}

}
