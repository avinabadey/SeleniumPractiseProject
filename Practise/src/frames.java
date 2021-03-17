import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class frames {

	public static void main(String[] args) throws InterruptedException {
		GetDriver get = new GetDriver();
		WebDriver driver = get.loadFirefoxDriver();
		
/*		driver.get("https://www.google.com/recaptcha/api2/demo");
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.xpath("//div[@class='verify-button-holder']/button")).click();
		*/
		
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/iframe-practice-page/");
		/*int fnumber = findFrame(driver, By.xpath("//input[@name='firstname']"));
		if(fnumber!=-1) {
			driver.switchTo().frame(fnumber);
			driver.findElement(By.xpath("//input[@name='firstname']")).click();
		}*/
		
		int f2number = findFrame(driver, By.id("ui-id-4"));
		if(f2number!=-1) {
			System.out.println("Element found in frame " + f2number);
			driver.switchTo().frame(f2number);
			driver.findElement(By.id("ui-id-4")).click();
		}
		
	}

	private static int findFrame(WebDriver driver, By by) {
		int fnum = -1;
		driver.switchTo().defaultContent();
		int totalFrames = driver.findElements(By.tagName("iframe")).size();
		for(int i=0; i<totalFrames; i++) {
			driver.switchTo().defaultContent();
			driver.switchTo().frame(i);
			int fcount = driver.findElements(by).size();
			if(fcount>0) {
				fnum = i;
				break;
			}
		}
		driver.switchTo().defaultContent();
		return fnum;
	}
	
}
