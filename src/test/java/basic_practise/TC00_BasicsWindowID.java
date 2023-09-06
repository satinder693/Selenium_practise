package basic_practise;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC00_BasicsWindowID {
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		Basic_utils bu = new Basic_utils();
		driver = bu.openBrowser("edge");
		driver.get("https://www.facebook.com");
		driver.findElement(By.linkText("Create new account")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Cookies Policy")).click();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> itr = ids.iterator();
		String firstWindowId = itr.next();
		
		String secondWindowId = itr.next();
		driver.switchTo().window(firstWindowId);
		
		System.out.println(driver.getTitle());
		driver.switchTo().window(secondWindowId);
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("View printable version")).click();
	}
	
}
