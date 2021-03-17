import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class rediffE2E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rediff.com/");
		
		System.out.println(driver.getTitle());	//verify page title
		System.out.println(driver.getCurrentUrl());	
		
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click();
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("textxpath");
		driver.findElement(By.cssSelector("#password")).sendKeys("hieeee");
		driver.findElement(By.xpath("//input[contains(@name,'procee')]")).click();
		
		
		
	}

}
