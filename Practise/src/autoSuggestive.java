import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class autoSuggestive {

	public static void main(String[] args) throws InterruptedException {
		
		GetDriver get = new GetDriver();
		WebDriver driver = get.loadChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.ksrtc.in/oprs-web/");
		
		String source = "beng";
		
		driver.findElement(By.xpath("//*[@name='fromPlaceName']")).click();
		driver.findElement(By.xpath("//*[@name='fromPlaceName']")).sendKeys(source);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@name='fromPlaceName']")).sendKeys(Keys.DOWN);
		
		//System.out.println(driver.findElement(By.xpath("//*[@name='fromPlaceName']")).getText());	//this will not work since element is hidden
		
		//Javascript DOM can extract hidden elements
		//because selenium cannot identify hidden elements - (Ajax implementation)
		//investigate the properties of object if it have any hidden text
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"fromPlaceName\").value";
		String ptext = (String) js.executeScript(script);
		
		//List options = document.getElementsByClassName("ui-corner-all");
		
		while(!ptext.equalsIgnoreCase("BENGALURU INTERNATION AIPORT")) {
			driver.findElement(By.xpath("//*[@name='fromPlaceName']")).sendKeys(Keys.DOWN);
			ptext = (String) js.executeScript(script);
			System.out.println(ptext);
			if(ptext.equals(source)) {
				System.out.println("Source not found!");
		        break;
		}
		}
		
		driver.findElement(By.xpath("//*[@name='fromPlaceName']")).sendKeys(Keys.RETURN);
		
	}

}
