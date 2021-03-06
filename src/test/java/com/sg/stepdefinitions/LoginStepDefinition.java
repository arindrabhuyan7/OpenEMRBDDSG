package com.sg.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.sg.base.WebDriverWrapper;
import com.sg.pages.DashboardPage;
import com.sg.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStepDefinition {
	
	public static WebDriver driver;	

	@Given("I have {string} browser with OpenEMR page")
	public void i_have_browser_with_open_emr_page(String browser) {
		WebDriverWrapper.launchBrowser(browser);
		WebDriverWrapper.scenario.log("Browser launched");
	}
	@When("I enter username as {string}")
	public void i_enter_username_as(String username) {
		LoginPage.enterUsername(username);
		WebDriverWrapper.scenario.log("username sent "+username);
	    
	}
	@When("I enter password as {string}")
	public void i_enter_password_as(String password) {
		LoginPage.enterPassword(password);
		WebDriverWrapper.scenario.log("password sent "+password);
	   
	}
	@When("I enter language as {string}")
	public void i_enter_language_as(String language) {
		LoginPage.selectLanguageByText(language);
	    
	}
	@When("i click on login")
	public void i_click_on_login() {
		LoginPage.clickonLogin();
	    
	}
	
	@Then("I should get access to the dashboard with the title {string}")
	public void i_should_get_access_to_the_dashboard_with_the_title(String expectedValue) {
		 Assert.assertEquals(expectedValue, DashboardPage.getCurrentTitle());
		
	}
	
	@Then("I should get the error message as {string}")
	public void i_should_get_the_error_message_as(String expectedValue) {	
		Assert.assertEquals(expectedValue, 
				 WebDriverWrapper.driver.findElement
				 (By.xpath("//*[contains(text(),'Invalid')]")).getText().trim());
	}
	
}
