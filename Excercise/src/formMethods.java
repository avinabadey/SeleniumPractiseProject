import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class formMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","D:\\Testing\\Selenium\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.spicejet.com");
		
		//isDisplayed() can only be used if the web element is present either in visible or hidden mode in code base/web page
		/*System.out.println(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).isDisplayed());
		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_rbtnl_Trip_2\"]")).click();	
		System.out.println(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).isDisplayed());
		*/
		
		
		
		//
		System.out.println(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).isEnabled());
		driver.findElement(By.xpath("//*[@id=\"ctl00_mainContent_rbtnl_Trip_2\"]")).click();	
		System.out.println(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).isEnabled());
		System.out.println(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).isDisplayed());
		
		driver.findElement(By.xpath("//*[@id='MultiCityModelAlert']")).click();
		
		Thread.sleep(3000L);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_view_date1']")).click();
		driver.findElement(By.xpath(".//*[@class='ui-datepicker-calendar']/tbody/tr[4]/td[4]/a")).click();
		
		System.out.println(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id='ctl00_mainContent_view_date2']")).isEnabled());
		int i=0;
		
		while(i<5) {
			driver.findElement(By.xpath("//*[@id='ctl00_mainContent_ddl_Adult']/option[2]")).click();
			i++;
		}
		
		System.out.println(driver.findElement(By.xpath("//*[@id='subFooter']/div/span[2]/div/p")).getText());
		
		//the following is used to find whether an element exists in code base/web page
		int wecount = driver.findElements(By.xpath("//*[@id=\"ctl00_mainContent_tnl_Trip_2\"]")).size();
		if(wecount==0) {
			System.out.println("There are no such web element on the page");
		}
		
		
		
		
	}

}
