package com.ibm.appiumTraining.AppiumProject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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

public class Activity2 {
    WebDriverWait wait;
    AppiumDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {

        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AppiumPractice");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automatioName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 10);
    }
    
    @Test
    public void createNote() {
        // Wait for Create new note to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("New text note")));
        
        // Find the Create new text note icon and click
        driver.findElementByAccessibilityId("New text note").click();
        
        // Wait for add task text box to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("editable_title")));
        // Find text field
        MobileElement titleName = driver.findElementById("editable_title");
        MobileElement noteText = driver.findElementById("edit_note_text");
        
        // Enter the text in the fields
        titleName.sendKeys("New Note");
        noteText.sendKeys("Note Description");
        
        // click on back icon
        driver.findElementByAccessibilityId("Open navigation drawer").click();
        
        // Wait for content box to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("browse_note_interior_content")));
        
        //Find title and do assertion
        List<MobileElement> titles = driver.findElementsByXPath("//android.widget.LinearLayout/android.widget.TextView[1]");
        for(MobileElement title : titles) {
            System.out.println("Title: " + title.getText());
            if (title.getText() == "New Note") {
            	Assert.assertEquals(title.getText(), "New Note");
            	break;
            }
        }
        //Find description and do assertion
        List<MobileElement> descs = driver.findElementsByXPath("//android.widget.LinearLayout/android.widget.TextView[2]");
        for(MobileElement desc : descs) {
            System.out.println("Description: " + desc.getText());
            if (desc.getText() == "Note Description") {
            	Assert.assertEquals(desc.getText(), "Note Description");
            	break;
            }
        }
        // Find text fields
		/*
		 * MobileElement title =
		 * driver.findElementById("com.google.android.keep:id/index_note_title");
		 * MobileElement desc = driver.findElementById(
		 * "com.google.android.keep:id/index_note_text_description");
		 * System.out.println("Title is: " + title.getText());
		 * System.out.println("Description is: " + desc.getText());
		 * 
		 * // Assertion Assert.assertEquals(title.getText(), "New Note");
		 * Assert.assertEquals(desc.getText(), "Note Description");
		 */
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
