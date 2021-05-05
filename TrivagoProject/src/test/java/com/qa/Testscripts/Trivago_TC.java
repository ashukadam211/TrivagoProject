package com.qa.Testscripts;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.Pages.Trivago_pg;
import com.qa.Utility.ExcelUtility;

public class Trivago_TC extends TestBase {
	
	//WebDriver driver  new ChromeDriver(); 
	Actions act;
	JavascriptExecutor js;
	
	
		@Test(dataProvider = "getData")
		public void SearchItem (String Destination) throws InterruptedException  {
		
		Trivago_pg TrivagoOR = new Trivago_pg(driver);
		driver.manage().window().maximize();
		act = new Actions(driver);
		Thread.sleep(2000);
		TrivagoOR.getEnterDestination().clear();
		Thread.sleep(1000);
		TrivagoOR.getEnterDestination().sendKeys(Destination);
		Thread.sleep(200);
		TrivagoOR.getSubmitButton().click();
		Thread.sleep(2000);
		
		}
		
		
		
		
		@DataProvider(name = "getData")
		public String[][] getData() throws IOException{
		
		String xlPath = "C:\\Users\\kadam\\eclipse-workspace\\TrivagoProject\\src\\test\\java\\com\\qa\\Utility\\TestData.xlsx";
		String xlSheet = "sheet1";
		
		int rowCount = ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount = ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);
		
		String[][] data = new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++) 
		{
			for (int j = 0;j< cellCount;j++) 
			{
				data[i-1][j] = ExcelUtility.getCellData(xlPath, xlSheet, i, j);
			}
		}
		
		return data;
	}	
		@AfterTest
		public void Logout() throws InterruptedException 
		{
			TrivagoOR.getWeekend().click();
			Thread.sleep(2000);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2000)", "");
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2000)", "");
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2000)", "");
			Thread.sleep(1000);
			js.executeScript("window.scrollBy(0,2000)", "");
			Thread.sleep(1000);
			
			
			driver.quit();
		
		}
}

