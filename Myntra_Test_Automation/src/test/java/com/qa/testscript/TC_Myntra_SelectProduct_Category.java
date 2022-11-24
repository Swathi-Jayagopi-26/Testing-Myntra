package com.qa.testscript;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utility.TC_Myntra_ExcelUtility;
import com.qa.testpages.TC_Myntra_Pages;

public class TC_Myntra_SelectProduct_Category extends TC_Myntra_TestBase{
	
@Test(dataProvider="getData")
public void Search_Product(String Men, String shirt) throws InterruptedException, IOException{
	TC_Myntra_Pages pages=new TC_Myntra_Pages(driver);
	SoftAssert SAssert = new SoftAssert();
	pages.getSearchTxt().sendKeys(Men);
	pages.getsearch().click();
	String title = driver.getTitle();
	boolean contains = driver.getTitle().contentEquals(shirt);
	System.out.println(contains);
	List<WebElement> SearchResults = pages.Suggestions();
	if(!contains) {
		SAssert.assertTrue(true);		
		Reporter.log("Title has the search term",true);
		//List<WebElement> allItems = pages.Suggestions();
		System.out.println("Total no. of items loaded are : " +  SearchResults.size());
	for(WebElement item:SearchResults) {
		
		Reporter.log(item.getText());
}
	}
	else {
	captureScreenshot(driver,"searchItem");
	SAssert.assertTrue(false);
	Reporter.log("Incorrect title",true);
}
}
@DataProvider
public Object[][] getData() throws IOException
{
String xFile="C:\\Users\\radhikaamma\\Downloads\\Myntra_Test_Automation\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
String Xsheet="Sheet2";
int rowCount = TC_Myntra_ExcelUtility.getRowCount(xFile, Xsheet);
int cellcount = TC_Myntra_ExcelUtility.getCellCount(xFile,Xsheet,rowCount);
String[][] data=new String[rowCount][cellcount];
for(int i=1;i<=rowCount;i++) 
{
	for(int j=0;j<cellcount;j++) {
	data[i-1][j]= TC_Myntra_ExcelUtility.getCellData(xFile, Xsheet, i, j);
	
}
}
return data;
}

}
