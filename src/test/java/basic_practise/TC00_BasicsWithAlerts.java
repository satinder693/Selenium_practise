package basic_practise;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC00_BasicsWithAlerts {
	public static WebDriver driver;
	public static void main(String[] args) {
		Basic_utils bu = new Basic_utils();
		driver = bu.openBrowser("edge");
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		driver.findElement(By.name("proceed")).click();
		Alert alert = driver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println("Error message in the alert is "+alertMsg);
		if(alertMsg.equalsIgnoreCase("Please enter a valid user name")) {
			System.out.println("Alert text matches");
		}else {
			System.out.println("Alert text does not match");
		}
		alert.accept();
		bu.closeApplication(driver);
	}

}
