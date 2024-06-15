package com.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;

public class BasePage {
    static Properties mainProp;
    static Properties plateformProp;
    static Properties environmentProp;
    String plateFormName;
    String environmentName;
    static RemoteWebDriver appiumDriver;
    private String APP_PKG = "com.browserstack.sample";
    private String APP_ACT = "com.browserstack.sample.MainActivity";

    public BasePage() {
        try (FileInputStream file = new FileInputStream(".//resources/app.properties")) {
            mainProp = new Properties();
            mainProp.load(file);
            plateFormName = mainProp.getProperty("plateform");
            System.out.println(plateFormName);
            if (plateFormName.equals("mobile"))
                mobileInitialisation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mobileInitialisation() {
        try (FileInputStream file = new FileInputStream(".//resources" + "/" + plateFormName + "/app.properties")) {
            plateformProp = new Properties();
            plateformProp.load(file);
            environmentName = mainProp.getProperty("environment");
            System.out.println(environmentName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DesiredCapabilities capabilities = new DesiredCapabilities();
        // Set your access credentials
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        // Set your access credentials
        browserstackOptions.put("userName", "deepaksatao_KeIvdF");
        browserstackOptions.put("accessKey", "CzWG3ss5YGS3qpXJzAzp");

        capabilities.setCapability("bstack:options", browserstackOptions);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "9.0");
        capabilities.setCapability("deviceName", "Google Pixel 3");

        // Set app_url of the application under test(AUT) which is version v1.0 of app
        capabilities.setCapability("app", "bs://<hashed app-id>");

        // Set app_url obtained after uploading the upgrade version v1.1 of app
        browserstackOptions.put("midSessionInstallApps", new String[] { "bs://<hashed app-id>" });

        AndroidDriver driver;
        try {
            driver = new AndroidDriver(new URL("https://hub.browserstack.com/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //WebDriverWait wait = new WebDriverWait(driver, 10);

       /*  try {

            // Your test goes with v1.0 goes here
            // Close the app under test
            driver.terminateApp(APP_PKG);
            driver.executeScript("mobile:terminateApp", ImmutableMap.of("appId", APP_PKG));

            // Install the upgrade version of the app
            // Specify the app_url of the upgrade version(v1.1) of the app that was passed
            // in "browserstack.midSessionInstallApps" capability

            driver.executeScript("mobile:installApp", ImmutableMap.of("appPath", "bs://<hashed app-id>"));

            // Launch the app using the package and launcher activity of the app
            HashMap<String, String> startActivityArgs = new HashMap<>();
            startActivityArgs.put("intent", APP_ACT);
            startActivityArgs.put("package", APP_PKG);

            driver.executeScript("mobile:startActivity", startActivityArgs);
            // Your test with upgrade version v1.1 goes

        } finally {
            driver.quit();
        }*/
    }

}
