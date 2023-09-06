package basic_practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basic_utils {
	public static WebDriver driver;
	public WebDriver openBrowser(String bName) {
		if(bName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(bName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			System.out.println("Wrong browser is open");
		}
		driver.manage().window().maximize();
		return driver;
	}
	public void closeApplication(WebDriver driver) {
		driver.close();
		System.out.println("Application is closed successfully");
	}
}
