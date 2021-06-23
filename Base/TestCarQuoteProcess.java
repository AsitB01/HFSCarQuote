package Base;

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

public class TestCarQuoteProcess
{
	
		
	//Declare the webdriver variable globally
	static WebDriver W1 = null;
	static String Browsername = "Edge";
	
	@BeforeClass
	public static void Test_a_ChooseBrowser()
	{
		
		WebDriverManager.edgedriver().setup(); //Importing the EdgeDriver .exe into the project
		if(Browsername.equals("Edge")) 
		{
			W1=new EdgeDriver();
			W1.manage().window().maximize();
			W1.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);// Applied Globally ; Dynamic wait - Let the pageload in the first 10 seconds
			W1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);// Applied Globally - Applicable for all WebElements on the page
			
		}
		else if(Browsername.equals("Chrome")) 
		{
			W1=new ChromeDriver();
			W1.manage().window().maximize();
			W1.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);// Applied Globally ; Dynamic wait - Let the pageload in the first 10 seconds
			W1.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		
	}
	
	@Test
	public void Test_b_HappyPath() throws InterruptedException
	{
		//Get the URL		
		W1.get("https://car.iselect.com.au/car/compare-car-insurance/gatewayStore");
		
		//Locate the Make and click on the first drop-down
		WebElement Make = W1.findElement(By.xpath("//div[.='Make']"));
		Make.click();
		
		//WebElement SelectMake = W1.findElement(By.xpath("//li[2]/div[@class='bw b9']"));
		WebElement SelectMake = W1.findElement(By.xpath("//div[.='Ford']"));
		SelectMake.click();
		
		//Select Model
		WebElement SelectModel = W1.findElement(By.xpath("//div[.='Bronco']"));
		SelectModel.click();
		
		//Select Year
		WebElement SelectYear = W1.findElement(By.xpath("//div[.='1987']"));
		SelectYear.click();
		
		//Select Colour
		WebElement Colour = W1.findElement(By.xpath("//div[contains(text(),'Beige')]"));//(By.xpath("xpath = //div[.='Beige']"));
		Colour.click();
		
		//Select Cover Type
		WebElement CoverType = W1.findElement(By.xpath("//span[.='Comprehensive']"));//(By.xpath("xpath = //div[.='Beige']"));
		CoverType.click();
						
		//Select Cover Reason
		WebElement CoverReason = W1.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/span[1]/div[1]"));// Cant use "Please select" as multiple list boxes have this text and its not unique
		CoverReason.click();
		WebElement CoverReasonSelect = W1.findElement(By.xpath("//div[.='Just want to compare']"));
		CoverReasonSelect.click();
		
		//Select Anti-theft option
		WebElement Antitheft = W1.findElement(By.xpath("//div[@class='j2']//div[@class='ep fq hc hd fr g7 he gv hf hg h9 ha hb gf']"));// Cant use "Please select" as multiple list boxes have this text and its not unique
		Antitheft.click();
		WebElement AntitheftSelect = W1.findElement(By.xpath("//div[contains(text(),'Alarm and Immobiliser')]"));
		AntitheftSelect.click();
		
		//Select Fitted Options
		WebElement fittedoptionsbutton = W1.findElement(By.xpath("//div[4]//div[2]//div[1]//div[1]//button[1]"));// Cant use "Yes" as multiple list boxes have this text and its not unique
		fittedoptionsbutton.click();
		WebElement selectfittedoptions = W1.findElement(By.xpath("//div[contains(text(),'Select factory options, if any')]"));
		selectfittedoptions.click();
		WebElement selectfittedvalue = W1.findElement(By.xpath("//div[contains(text(),'Tracker Tyres')]"));
		selectfittedvalue.click();
		
		//Select Non-Standard accessories
		WebElement selectnonstdaccessories = W1.findElement(By.xpath("//body/div[@id='root']/div/section/div/div/div/button[2]"));// Cant use "Yes" as multiple list boxes have this text and its not unique
		selectnonstdaccessories.click();
		
		//Select Damage
		WebElement selectdamage = W1.findElement(By.xpath("//body/div[@id='root']/div/section/div/div[9]/div[2]/div[1]/div[1]/button[1]"));// Cant use "Yes" as multiple list boxes have this text and its not unique
		selectdamage.click();
		WebElement selectdamagetype = W1.findElement(By.xpath("//span[contains(text(),'Accident')]"));// Cant use "Yes" as multiple list boxes have this text and its not unique
		selectdamagetype.click();
		
		//Select current insurance
		WebElement currentinsurance = W1.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/section[2]/div[1]/div[11]/div[1]/div[1]/div[1]/span[1]/div[1]"));// Cant use "Yes" as multiple list boxes have this text and its not unique
		currentinsurance.click();
		WebElement currentinsurancestate = W1.findElement(By.xpath("//div[contains(text(),'No, never been insured')]"));
		currentinsurancestate.click();
		
		//Select the Declaration
		WebElement declaration = W1.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[1]/div[1]/div[1]/label[1]/span[1]"));// This Declaration may change to 'Acceptance'. Text is prone to change hence Xpaths used.
		declaration.click();
		
		//Check if 'Continue' button is enabled
		WebElement Tocontinue = W1.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/section[3]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]"));// Cant use "Yes" as multiple list boxes have this text and its not unique
		if(Tocontinue.isEnabled())	
			System.out.println("Continue button is enabled ; Positive flow verified");
		else
			System.out.println("Revaldiate inputs");
		
		//Close the browser after 10 secs. 
		Thread.sleep(10000);
		W1.close();
		
	}
		
}
