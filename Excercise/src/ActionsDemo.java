import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.gecko.driver","D:\\Testing\\Selenium\\geckodriver.exe");
		//WebDriver driver=new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		
		Actions a= new Actions(driver);
		//WebElement move=driver.findElement(By.xpath("//*[@id='nav-link-yourAccount']"));
		//a.moveToElement(move).contextClick().build().perform();
		
		a.moveToElement(driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		
		
	}

}
