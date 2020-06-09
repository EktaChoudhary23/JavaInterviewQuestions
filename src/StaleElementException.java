import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementException {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com");

		List<WebElement> social_buttons = driver.findElements(By.xpath("//div[@class='outer hidden-xs']//div[contains(@class,'social-buttons')]/a"));
	
		for(WebElement social_button: social_buttons) {
			social_button.click();
			System.out.println(driver.getTitle());
			
			Assert.assertTrue(driver.getTitle().contains("OrangeHRM"), "Unexpected page found");
			
			driver.navigate().back();
			social_buttons = driver.findElements(By.xpath("//div[@class='outer hidden-xs']//div[contains(@class,'social-buttons')]/a"));
			
		}
			
	
	}

}
