package com.qa.testscript;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
public class TC_Myntra_TestBase {
	WebDriver driver;
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setup(String Browser, String Url) {
		if(Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Users\\radhikaamma\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		if(Browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\radhikaamma\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
	driver.get(Url);
	driver.manage().window().maximize();
	
	}
public void captureScreenshot(WebDriver driver, String tName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");		
		FileUtils.copyFile(source, target);
		
	}

}
