package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class MedicalRecordDashboardPage {
	
	private static By patientMedicalRecordLocator=By.xpath("//*[contains(text(),'Medical Record')]");
	
	public static void patientMedicalRecordDetails(WebDriver driver)
	{
		driver.switchTo().frame("pat");
		String actualValue=driver.findElement(patientMedicalRecordLocator).getText();
		System.out.println(actualValue);
		
		Assert.assertEquals(actualValue, "Medical Record Dashboard - Hello2 World2");
        System.out.println(actualValue);
		
		driver.switchTo().defaultContent();
				
	}

}
