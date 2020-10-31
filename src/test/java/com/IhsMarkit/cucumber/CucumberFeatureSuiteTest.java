package com.IhsMarkit.cucumber;


import java.util.List;

import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 

@CucumberOptions(features = "features", glue = "com.IhsMarkit.stepdefs", tags="@Test")
public class CucumberFeatureSuiteTest extends AbstractTestNGCucumberTests {
}
