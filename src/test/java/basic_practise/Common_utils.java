package basic_practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Common_utils {
	public void enterValInInputFiledAndVerify(WebElement ele, String valToEnter, String eleName) {
		boolean status = ele.isDisplayed();
		try{
			if(status = true) {
			}
			ele.clear();
			ele.sendKeys(valToEnter);
			String atrVal = ele.getAttribute("value");
			if(atrVal.isEmpty()==true) {
				System.out.println(eleName+" is empty");
			}else {
				System.out.println(eleName+" is not empty");
			}
			System.out.println("Value present in "+eleName+" is "+atrVal);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void verifyAppTitle(WebDriver driver, String expTitle) {
		String actTitle = driver.getTitle();
		if(actTitle.equalsIgnoreCase(expTitle)) {
			System.out.println("Actual title matches the Expected title");
		}else {
			System.out.println("Actual title does not match the expected title");
		}
	}
	public void selectFromDropDown(WebElement ele, String valTOSelect) {
		Select select = new Select(ele);
		select.selectByVisibleText(valTOSelect);
		
	}
	public void selectFromDropDown(WebElement ele , int indexToSelect) {
		Select select = new Select(ele);
		select.selectByIndex(indexToSelect);
		
	}
}
