package com.ibm.appiumTraining.FST_B15_Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalcExample {
    AppiumDriver<MobileElement> driver = null;
    
    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "AppiumPractice");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automatioName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.calculator2");
        caps.setCapability("appActivity", ".Calculator");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
    }

    @Test
    public void multiply() {
        driver.findElementById("digit_7").click();
        driver.findElementById("op_mul").click();
        driver.findElementById("digit_4").click();
        driver.findElementById("eq").click();
        
        //Display Result
        String result = driver.findElementById("result").getText();
        System.out.println("Result is: " + result);
        Assert.assertEquals(result, "28");
    }

    @AfterClass
    public void afterClass() {
    	// Close Appium Driver
        driver.quit();
    }
}
