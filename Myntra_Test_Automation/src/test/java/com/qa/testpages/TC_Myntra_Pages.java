package com.qa.testpages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TC_Myntra_Pages {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/input")
	WebElement SearchTxt;
	public WebElement getSearchTxt() {
		return SearchTxt;
	
	}
	@FindBy(xpath="//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/div/ul/li")
	List<WebElement> SearchResults;
	public List<WebElement> Suggestions() {
		return SearchResults;}
		
	@FindBy(xpath="//*[@id=\"desktop-header-cnt\"]/div[2]/div[3]/a/span")
	WebElement SearchButton;
	public WebElement getsearch() {
		return SearchButton;
	}
	
  
	public TC_Myntra_Pages(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
}