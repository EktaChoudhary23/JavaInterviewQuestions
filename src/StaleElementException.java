import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaleElementException {

	@Test
	public void validateAllSocialButtons(){
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://orangehrm-demo-6x.orangehrmlive.com");
		driver.manage().window().maximize();
				
		List<WebElement> social_buttons = driver.findElements(By.xpath("//div[@class='col-md-5']//div[contains(@class, 'social-buttons')]/a"));
		
		for(int i=0; i<social_buttons.size(); i++) {
			//System.out.println(social_buttons.get(i).getAttribute("href"));
			
			social_buttons.get(i).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			social_buttons = driver.findElements(By.xpath("//div[@class='col-md-5']//div[contains(@class, 'social-buttons')]/a"));
		}
		
		driver.quit();
		
		}

}
