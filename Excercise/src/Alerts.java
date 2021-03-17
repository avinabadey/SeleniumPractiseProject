import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","D:\\Testing\\Selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		
		driver.findElement(By.xpath("//input[@value='Confirmation Alert']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		//to click on accept/yes/done on alert
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().sendKeys("I am typing");
		//to click on no/cancel on alert
		//driver.switchTo().alert().dismiss();
		
	}

}
