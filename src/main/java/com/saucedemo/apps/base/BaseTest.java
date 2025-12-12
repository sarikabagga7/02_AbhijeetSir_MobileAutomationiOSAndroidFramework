package com.saucedemo.apps.base;

import com.saucedemo.apps.object.AppiumDriverManager;
import com.saucedemo.apps.utils.Constants;
import com.saucedemo.apps.utils.PlatformType;
import com.saucedemo.apps.utils.PropertyUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class BaseTest {
    protected AppiumDriver DRIVER = null;

    private static String pkgName = "com.swaglabsmobileapp";
    private static String activity = "com.swaglabsmobileapp.SplashActivity";
    private static String bundleid = "com.saucelabs.SwagLabsMobileApp";

    private AppiumDriverLocalService service = new AppiumServiceBuilder()
            .withAppiumJS(new File("/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
            .usingDriverExecutable(new File("/opt/homebrew/bin/node"))
            .withIPAddress("127.0.0.1")
            .usingPort(4723)
            .build();

    @BeforeTest
    public void suiteSetup() {
        try {
            PropertyUtils.loadConfigProperties();
            service.start();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @BeforeMethod
    public void testSetup() {
        try {
            AppiumDriverManager.getDriver();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    @AfterMethod
    public void testTeardown() {
        terminateApp();
        AppiumDriverManager.killDriver();
    }

    @AfterTest
    public void suiteTeardown() {
        service.stop();
    }

    public void terminateApp() {
        try {
            if (Constants.PLATFORM_TYPE == PlatformType.ANDROID) {
                if (((AndroidDriver)AppiumDriverManager.getDriver()).queryAppState(pkgName) != ApplicationState.NOT_RUNNING)
                    ((AndroidDriver)AppiumDriverManager.getDriver()).terminateApp(pkgName);
            } else {
                if (((IOSDriver)AppiumDriverManager.getDriver()).queryAppState(bundleid) != ApplicationState.NOT_RUNNING)
                    ((IOSDriver)AppiumDriverManager.getDriver()).terminateApp(bundleid);
            }
        } catch (RuntimeException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
