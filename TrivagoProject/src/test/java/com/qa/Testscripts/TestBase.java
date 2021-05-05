package com.qa.Testscripts;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.qa.Pages.Trivago_pg;

public class TestBase {

	WebDriver driver;
	Trivago_pg TrivagoOR;
	JavascriptExecutor js;
	
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setUp(String Browser,String Url) {
		if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\kadam\\Downloads\\driver_executables\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\kadam\\Downloads\\driver_executables\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();	
		}
		
		TrivagoOR   = new Trivago_pg(driver);
		js = (JavascriptExecutor)driver;
		driver.get(Url);	
	}
	public void captureScreenshot (WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(Source, target);
		System.out.println("Screenshot is captured");
	}
}