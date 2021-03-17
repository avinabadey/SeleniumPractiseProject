import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class frameTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","D:\\Testing\\Selenium\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.switchTo().frame(0);	//switch to frame by index which starts from 0
		WebElement tframe = driver.findElement(By.cssSelector("iframe[class='demo-frame']"));
		driver.switchTo().frame(tframe);	//switch to frame by web element data
		
		WebElement sourcedrag = driver.findElement(By.id("draggable"));
		WebElement targetdrop = driver.findElement(By.id("droppable"));
		Actions a = new Actions(driver);
		a.dragAndDrop(sourcedrag, targetdrop).build().perform();	//drag and drop by web element details
		a.dragAndDropBy(sourcedrag, -150, 0).build().perform();	//drag and drop the web element by coordinates
		
		driver.switchTo().defaultContent();
				
	}

}
