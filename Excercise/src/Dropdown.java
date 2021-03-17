import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.spicejet.com");
		
		System.out.println(driver.getTitle());	//verify page title
		System.out.println(driver.getCurrentUrl());	
		
		//selecting static dropdown value
		Select s=new Select(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_Adult']")));
		s.selectByValue("2");
		s.selectByIndex(5);
		s.selectByVisibleText("9");
		
		//selecting dynamic dropdown value
		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		driver.findElement(By.cssSelector("a[value='DEL']")).click();
		
	}

}
