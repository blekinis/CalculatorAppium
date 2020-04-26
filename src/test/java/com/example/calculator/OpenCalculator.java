package com.example.calculator;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class OpenCalculator {

    static AppiumDriver<MobileElement> driver;

    public static void main(String[] args){
        try{
            openCalculator();
        }
        catch (Exception ex){
            //System.out.println(ex.getCause());
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void openCalculator() throws  Exception{

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName","Pixel 2" );
        cap.setCapability("udid","emulator-5554" );
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("appPackage", "com.android.calculator2");
        cap.setCapability("appActivity", "com.android.calculator2.Calculator");
        cap.setCapability("automationName", "UiAutomator2");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AppiumDriver<MobileElement>(url, cap);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Application started!");

        MobileElement one = driver.findElement(By.name("2"));
        MobileElement plus = driver.findElement(By.id("com.android.calculator2:id/op_add"));
        MobileElement two = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        MobileElement eq = driver.findElement(By.id("com.android.calculator2:id/eq"));
        MobileElement result = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'result')]"));
        one.click();
        plus.click();
        two.click();
        eq.click();
        String results = result.getText();
        System.out.println("Result is: " + results);

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement clearButton = driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"clear\"]"));
        clearButton.click();
        /*1. comment*/
        /*2. comment*/
        /*3. comment*/
    }
}
