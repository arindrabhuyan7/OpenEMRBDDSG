package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sg.base.WebDriverWrapper;

public class AddPatientPage {
		
	private static By firstNameLocator=By.id("form_fname");
	private static By lastNameLocator=By.id("form_lname");
	private static By birthDayLocator=By.id("form_DOB");
	private static By selectGenderLocator=By.id("form_sex");
	private static By clickCreateNewPatientLocator=By.id("create");
//	private static By switchToFrameLocator=By.xpath("//iframe[contains(@src,'popup')]");
	private static By confirmPatientDetailsLocator=By.xpath("//*[@value='Confirm Create New Patient']");
	
	public static void addPatientFirstName(String firstname)
	{
		WebDriverWrapper.driver.switchTo().frame("pat");
		WebDriverWrapper.driver.findElement(firstNameLocator).sendKeys(firstname);		
						
	}
	
	public static void addPatientLastName(String lastname)
	{
		WebDriverWrapper.driver.findElement(lastNameLocator).sendKeys(lastname);
	}
	
	public static void addPatientBirthday(String dateofbirth)
	{
		WebDriverWrapper.driver.findElement(birthDayLocator).sendKeys(dateofbirth);
	}
	
	public static void selectGenderByText(String gender)
    {
    	Select selectGender = new Select(WebDriverWrapper.driver.findElement(selectGenderLocator));
		selectGender.selectByVisibleText(gender);
    }
	
	public static void clickCreateNewPatientButton()
	{
		WebDriverWrapper.driver.findElement(clickCreateNewPatientLocator).click();
		WebDriverWrapper.driver.switchTo().defaultContent();
	}
											
//	public static void switchToFrame(WebDriver driver)
//	{
//		driver.findElement(switchToFrameLocator);
//	}
//	
	public static void confirmPatientDetails()
	{
//		WebDriverWrapper.driver.findElement(switchToFrameLocator);
		WebDriverWrapper.driver.switchTo().frame("modalframe");
		WebDriverWrapper.driver.findElement(confirmPatientDetailsLocator).click();
		WebDriverWrapper.driver.switchTo().defaultContent();
	}
	
	public static String handleAlertAndGetAlertText() {
		WebDriverWait wait = new WebDriverWait(WebDriverWrapper.driver, 50);
		wait.until(ExpectedConditions.alertIsPresent());
		String alertText = WebDriverWrapper.driver.switchTo().alert().getText();
		WebDriverWrapper.driver.switchTo().alert().accept();
		return alertText;
	}

}

