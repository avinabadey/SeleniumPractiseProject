import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookxpath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://facebook.com");
		
		/* 	//tagname[@attribute='value'] - syntax of xpath */
	/*	driver.findElement(By.xpath("//*[@name='email']")).sendKeys("testxpath");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		*/
		
		//	tagname[attribute='value'] - syntax of CSS
		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("testcss");
		driver.findElement(By.cssSelector("[value='Log In']")).click();
		
		
	}

}
