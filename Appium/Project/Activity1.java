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

public class Activity1 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AppiumPractice");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automatioName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }
    
    @Test
    public void createListOfActivities() {
        // Wait for Create new task to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
        
        // Find the Create new task icon and click
        driver.findElementByAccessibilityId("Create new task").click();
        
        // Wait for add task text box to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        // Find text field
        MobileElement addTaskTitle1 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        
        // Enter the text in the fields
        addTaskTitle1.sendKeys("Complete Activity with Google Tasks");
        
        // Save the task
        driver.findElementById("add_task_done").click();
        
        // Wait for Create new task to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
        
        // Find the Create new task icon and click
        driver.findElementByAccessibilityId("Create new task").click();
        
        // Wait for add task text box to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        // Find text field
        MobileElement addTaskTitle2 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        // Enter the text in the fields
        addTaskTitle2.sendKeys("Complete Activity with Google Keep");
        
        // Save the task
        driver.findElementById("add_task_done").click();

        // Wait for Create new task to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Create new task")));
        
        // Find the Create new task icon and click
        driver.findElementByAccessibilityId("Create new task").click();
        
        // Wait for add task text box to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("com.google.android.apps.tasks:id/add_task_title")));
        
        // Find text field
        MobileElement addTaskTitle3 = driver.findElementById("com.google.android.apps.tasks:id/add_task_title");
        // Enter the text in the fields
        addTaskTitle3.sendKeys("Complete the second Activity Google Keep");
        
        // Save the task
        driver.findElementById("add_task_done").click();
        
        // Wait for task to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.widget.TextView[@text='Complete Activity with Google Keep']")));
        
        // Assertion
        MobileElement task1 = driver.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Tasks']");
        System.out.println("Task 1: " + task1.getText() + " added to the list.");
        Assert.assertTrue(task1.isDisplayed());
        MobileElement task2 = driver.findElementByXPath("//android.widget.TextView[@text='Complete Activity with Google Keep']");
        System.out.println("Task 2: " + task2.getText() + " added to the list.");
        Assert.assertTrue(task2.isDisplayed());
        MobileElement task3 = driver.findElementByXPath("//android.widget.TextView[@text='Complete the second Activity Google Keep']");
        System.out.println("Task 3: " + task3.getText() + " added to the list.");
        Assert.assertTrue(task3.isDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
