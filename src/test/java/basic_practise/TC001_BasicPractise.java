package basic_practise;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC001_BasicPractise {
	public static WebDriver driver;
	//String expTitle = "Facebook log in or sign up";
	
	public static void main(String[] args) throws InterruptedException {
		Basic_utils bu = new Basic_utils();
		driver = bu.openBrowser("edge");
		driver.get("https://www.facebook.com");
		
		String appTitle = driver.getTitle();
		System.out.println("Title of the application is "+appTitle);
		if(appTitle.equalsIgnoreCase("Facebook - log in or sign up")) {
			System.out.println("Actual title matches the Expected title");
		}else {
			System.out.println("Actual title does not match the Expected title");
		}
		String appUrl = driver.getCurrentUrl();
		int valIndex = appUrl.indexOf("facebook");
		System.out.println("Index of facebook is "+valIndex);
		if(appUrl.indexOf("facebook")>=0) {
			System.out.println("Correct application is opened");
		}else {
			System.out.println("Wrong application is opened");
		}
		if(appUrl.contains("facebook")) {
			System.out.println("Facebook is contained in the Url");
		}else {
			System.out.println("Facebook i s not contained in the Url");
		}
		Common_utils cu = new Common_utils();
		
		cu.verifyAppTitle(driver, "Facebook - log in or sign up");
		
		cu.enterValInInputFiledAndVerify(driver.findElement(By.name("email")), "satinder", "Login Field");
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int noOfLinks = links.size();
		
		boolean status = true;
		for( int i = 0; i<noOfLinks; i++) {
			String linkNames = links.get(i).getText();
			
			if(linkNames.equalsIgnoreCase("Cookies")) {
				status = true;
				break;
			}else {
				status = false;
			}
		}
		if (status == true) {
			System.out.println("Expected link is present in the list of links");
		}else {
			System.out.println("Expected link is absent in the list of links");
		}
		System.out.println("Text of the link is "+driver.findElement(By.linkText("Forgot password?")).getText());
		driver.findElement(By.linkText("Create new account")).click();
		Thread.sleep(3000);
		WebElement monthDD = driver.findElement(By.id("month"));
		WebElement dayDD = driver.findElement(By.id("day"));
		
		Select select1 = new Select(monthDD);
		select1.selectByVisibleText("Aug");
		
		Select select2 = new Select(dayDD);
		select2.selectByIndex(9);
		List<WebElement> ddList = select2.getOptions();
		int listSize = ddList.size();
		for(int i=0; i<listSize; i++) {
			String ddNames = ddList.get(i).getText();
			if(ddNames.equalsIgnoreCase("9")) {
				status = true;
				break;
			}else {
				status = false;
			}
		}
		if(status==true) {
			System.out.println("Value present in the drop down");
		}else {
			System.out.println("Value absent in the dropdown");
		}
	//	cu.selectFromDropDown(driver.findElement(By.id("day")), 8);
		bu.closeApplication(driver);
	}

}
