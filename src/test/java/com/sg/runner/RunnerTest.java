package com.sg.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@CucumberOptions(

//	    features = {"src/test/resources/Feature/Login.feature", "src/test/resources/Feature/Patient.feature"},
		features = { "src/test/resources/Feature" },
	    glue = {"com.sg.stepdefinitions", "com.sg.base"},
	    publish = true,   //publish is used for report generation
	    monochrome = true,   //it will remove all the special characters in the console and will generate a clear console
//	    dryRun=true,      //it will check if all the steps hv step definition
	    tags="@patient",
	    plugin = {"html:report/index.html"}
//	    plugin = {"pretty"}   //it will give details in the console
//	    tags="not @invalid"    it will not run the invalid scenario
)

@RunWith(Cucumber.class)
public class RunnerTest {

}
