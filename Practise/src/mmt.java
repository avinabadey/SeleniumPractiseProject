import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

public class mmt {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		GetDriver get = new GetDriver();
		WebDriver driver = get.loadChromeDriver();
		//WebDriver driver = get.loadDriver("chrome");
		//ChromeOptions c = new ChromeOptions();
		//c.addArguments("--disable-notifications");
		//WebDriver driver = new ChromeDriver(c);
		//FirefoxProfile profile = new FirefoxProfile();
		//profile.setPreference("dom.push.enabled",false);
		//WebDriver driver = new FirefoxDriver(profile);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		String depDate = "25";
		String depMonth = "June";
		String retDate = "29";
		String retMonth = "June";
		
		clickDepDate(driver, depDate, depMonth);
		clickRetDate(driver, retDate, retMonth);		
		
		Thread.sleep(3000);
		//driver.close();
	}
	
	private static void clickDepDate(WebDriver driver, String depDate, String depMonth) {
		//click on depart datepicker
		driver.findElement(By.xpath("//*[@id='hp-widget__depart']")).click();
		String calside = "left";
		while(!driver.findElement(By.cssSelector("[class='dateFilter hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-datepicker-month']")).getText().equalsIgnoreCase(depMonth)){
			if(driver.findElement(By.cssSelector("[class='dateFilter hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-last'] [class='ui-datepicker-month']")).getText().equalsIgnoreCase(depMonth)) {
				calside = "right";
				break;
			}
			else {
				//changing month once which will show second/right side month and the next month
				driver.findElement(By.cssSelector("[class='dateFilter hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-last'] [class='ui-icon ui-icon-circle-triangle-e']")).click();
				//changing month again to show both the months after second/right side 
				driver.findElement(By.cssSelector("[class='dateFilter hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-last'] [class='ui-icon ui-icon-circle-triangle-e']")).click();		
			}
		}
		
		if(calside.equals("left")) {
			List<WebElement> dates = driver.findElements(By.cssSelector("[class='dateFilter hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-first'] a[class^='ui-state-default'][href='#']"));
			int count = dates.size();
			for(int i=0;i<count;i++) {
				String dtext = dates.get(i).getText();
				if(dtext.equals(depDate)) {
					dates.get(i).click();
					break;
				}
			}
			
		}
		else {
			List<WebElement> dates = driver.findElements(By.cssSelector("[class='dateFilter hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-last'] a[class^='ui-state-default'][href='#']"));
			int count = dates.size();
			for(int i=0;i<count;i++) {
				String dtext = dates.get(i).getText();
				if(dtext.equals(depDate)) {
					dates.get(i).click();
					break;
				}
			}
		}
		
	}
	
	private static void clickRetDate(WebDriver driver, String retDate, String retMonth) {
		//click on return datepicker
		driver.findElement(By.xpath("//*[@id='hp-widget__return']")).click();
		String calside = "left";
		while(!driver.findElement(By.cssSelector("[class='dateFilterReturn hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-first'] [class='ui-datepicker-month']")).getText().equalsIgnoreCase(retMonth)){
			if(driver.findElement(By.cssSelector("[class='dateFilterReturn hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-last'] [class='ui-datepicker-month']")).getText().equalsIgnoreCase(retMonth)) {
				calside = "right";
				break;
			}
			else {
				//changing month once which will show second/right side month and the next month
				driver.findElement(By.cssSelector("[class='dateFilterReturn hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-last'] [class='ui-icon ui-icon-circle-triangle-e']")).click();
				//changing month again to show both the months after second/right side 
				driver.findElement(By.cssSelector("[class='dateFilterReturn hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-last'] [class='ui-icon ui-icon-circle-triangle-e']")).click();		
			}
		}
		
		if(calside.equals("left")) {
			List<WebElement> dates = driver.findElements(By.cssSelector("[class='dateFilterReturn hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-first'] a[class^='ui-state-default'][href='#']"));
			int count = dates.size();
			for(int i=0;i<count;i++) {
				String dtext = dates.get(i).getText();
				if(dtext.equals(retDate)) {
					dates.get(i).click();
					break;
				}
			}
			
		}
		else {
			List<WebElement> dates = driver.findElements(By.cssSelector("[class='dateFilterReturn hasDatepicker'] [class='ui-datepicker-group ui-datepicker-group-last'] a[class^='ui-state-default'][href='#']"));
			int count = dates.size();
			for(int i=0;i<count;i++) {
				String dtext = dates.get(i).getText();
				if(dtext.equals(retDate)) {
					dates.get(i).click();
					break;
				}
			}
		}
	}

}