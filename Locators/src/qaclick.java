import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class qaclick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Testing\\Selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.qaclickacademy.com/interview.php");
		
		System.out.println(driver.getTitle());	//verify page title
		System.out.println(driver.getCurrentUrl());	
		
		driver.findElement(By.xpath("//li[text()=' Selenium ']")).click();	//using text to identify
		//using sibling to traverse xpath
		driver.findElement(By.xpath("//ul[@class='responsive-tabs__list']/li[1]/following-sibling::li[2]")).click();
		//using parent to traverse xpath
		System.out.println(driver.findElement(By.xpath("//li[@id='tablist1-tab2']/parent::ul")).getAttribute("role"));
		
		
		
		
		
	}

}
