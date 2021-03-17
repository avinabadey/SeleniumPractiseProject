import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class calendar {

	public static void main(String[] args) throws InterruptedException {
		
		GetDriver s = new GetDriver();
		WebDriver driver = s.loadDriver("chrome");

		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("travel_date")).click();
		WebElement month = driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']"));
		String travelmonth = "May 2019";
		String travelday = "30";
		
		while(!month.getText().contains(travelmonth)) {
			if(travelmonth.contains("2018")) {
				driver.findElement(By.cssSelector("[class='datepicker-days'] [class='prev']")).click();
			}
			else {
				driver.findElement(By.cssSelector("[class='datepicker-days'] [class='next']")).click();	
			}
		}
		
		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = dates.size();
		
		for(int i=0;i<count; i++) {
			String dtext = driver.findElements(By.cssSelector("[class^='day']")).get(i).getText();
			if(dtext.equals(travelday)) {
				driver.findElements(By.cssSelector("[class^='day']")).get(i).click();
				break;
			}
		}
		Thread.sleep(10000);
		driver.quit();
				
	}

}
