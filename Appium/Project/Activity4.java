package com.ibm.appiumTraining.AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AppiumPractice");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automatioName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

        // Open page
        driver.get("https://www.training-support.net/selenium");
    }
    
    @Test
    public void scrollIntoViewToDoList() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));

        // Scroll element into view and click it
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollToEnd(5)"));
        
        driver.findElementByXPath("//android.widget.TextView[contains(@text, 'To-Do List')]").click();
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("taskInput")));
        
        MobileElement searchBox1 = driver.findElementById("taskInput");
        // Enter the text in the fields
        searchBox1.sendKeys("Add tasks to list");
        
        driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
        
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text, 'Add tasks to list')]")));
        
        MobileElement task1 = driver.findElementByXPath("//android.view.View[contains(@text, 'Add tasks to list)]");
        // Assertion
        Assert.assertEquals(task1.getText(), "Add tasks to list");
        
        
        driver.findElementByXPath("//android.view.View[contains(@text, 'Add tasks to list')]").click();
        
        MobileElement searchBox2 = driver.findElementById("taskInput");
        // Enter the text in the fields
        searchBox2.sendKeys("Get number of tasks");
        
        driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
        
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text, 'Get number of tasks')]")));
        
        MobileElement task2 = driver.findElementByXPath("//android.view.View[contains(@text, 'Get number of tasks')]");
        // Assertion
        Assert.assertEquals(task2.getText(), "Get number of tasks");
        
        driver.findElementByXPath("//android.view.View[contains(@text, 'Get number of tasks')]").click();
        
        MobileElement searchBox3 = driver.findElementById("taskInput");
        // Enter the text in the fields
        searchBox3.sendKeys("Clear the list");
        
        driver.findElementByXPath("//android.widget.Button[contains(@text, 'Add Task')]").click();
        
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text, 'Clear the list')]")));
        
        MobileElement task3 = driver.findElementByXPath("//android.view.View[contains(@text, 'Clear the list')]");
        // Assertion
        Assert.assertEquals(task3.getText(), "Clear the list");
        
        driver.findElementByXPath("//android.view.View[contains(@text, 'Clear the list')]").click();
        
        driver.findElementByXPath("//android.view.View[contains(@text, 'Clear List')]").click();

    }
    
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
