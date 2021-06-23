package Base;

import static org.junit.Assert.assertTrue;

import java.awt.List;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class TestCarQuoteProcess_NegTest 
{
	// Declare the WebDriver variable
	static WebDriver W2 = null;
	
	@BeforeClass
	public static void Test_a_ChooseBrowser()
	{
		String Browsername = "Edge";
		
		WebDriverManager.edgedriver().setup(); //Importing the EdgeDriver .exe into the project
		if(Browsername.equals("Edge")) 
		{
			W2=new EdgeDriver();
			W2.manage().window().maximize();
			W2.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);// Applied Globally ; Dynamic wait - Let the pageload in the first 10 seconds
			W2.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		}
		
	}
		@SuppressWarnings("deprecation")
		@Test
		public void Test_c_NegativePath() throws InterruptedException
		{
			W2.get("https://car.iselect.com.au/car/compare-car-insurance/gatewayStore");
			
			//Select the Declaration
			WebElement declaration = W2.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]"));// Used Xpath here as 'Declaration' text may change anytime. Eg to 'Proceed'
			declaration.click();
					
			//Check if 'Continue' button is enabled
			WebElement Tocontinue = W2.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]"));// Cant use "Yes" as multiple list boxes have this text and its not unique
			
			//Click on Cotinue
			Tocontinue.click();
			
			//Check any valdiations thrown
			String ValidationText = W2.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/span[1]")).getText();
			System.out.println("Following valdiation is thrown and TC fails :- " + ValidationText);
			Assert.assertFalse("ValidationText", ValidationText.equals("Please select an option"));
			
			//Close the browser
			Thread.sleep(5000);
			W2.quit();
						
		}

}
