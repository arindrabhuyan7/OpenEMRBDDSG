package com.sg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sg.base.WebDriverWrapper;

public class DashboardPage {
	private static By logoutLocator=By.xpath("//*[text()='Logout']");
	private static By patientClientLocator=By.xpath("//*[text()='Patient/Client']");
	private static By patientsLocator=By.xpath("//*[text()='Patients']");

    public static void waitForPresenceOfLogout(WebDriver driver)
    {
    	WebDriverWait wait=new WebDriverWait(WebDriverWrapper.driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(logoutLocator));
	}
	
	public static String getCurrentTitle()
	{
		return WebDriverWrapper.driver.getTitle().trim();
	}
	
	public static void mouseHoverOnPatientClient()
	{
		Actions action=new Actions(WebDriverWrapper.driver);
		action.moveToElement(WebDriverWrapper.driver.findElement(patientClientLocator)).perform();
	}
	
	public static void ClickOnPatients()
	{
		WebDriverWrapper.driver.findElement(patientsLocator).click();
	}


	
	public static void clickOnPatients(WebDriver driver)
	{
		WebDriverWrapper.driver.findElement(patientsLocator).click();
	}

}
