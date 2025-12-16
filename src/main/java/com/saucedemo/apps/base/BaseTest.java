package com.saucedemo.apps.base;

import com.saucedemo.apps.object.AppiumDriverManager;
import com.saucedemo.apps.object.AppiumServiceManager;
import com.saucedemo.apps.utils.Constants;
import com.saucedemo.apps.utils.JsonUtils;
import com.saucedemo.apps.utils.PlatformType;
import com.saucedemo.apps.utils.PropertyUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public abstract class BaseTest {

    @BeforeTest
    public void suiteSetup() {
        try {
            loadTestConfiguration();
            AppiumServiceManager.startAppiumService("4723");
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
        AppiumServiceManager.stopAppiumService();
    }

    private void terminateApp() {
        try {
            if (Constants.PLATFORM_TYPE == PlatformType.ANDROID) {
                if (((AndroidDriver)AppiumDriverManager.getDriver()).queryAppState(Constants.PKGNAME) != ApplicationState.NOT_RUNNING)
                    ((AndroidDriver)AppiumDriverManager.getDriver()).terminateApp(Constants.PKGNAME);
            } else {
                if (((IOSDriver)AppiumDriverManager.getDriver()).queryAppState(Constants.BUNDLEID) != ApplicationState.NOT_RUNNING)
                    ((IOSDriver)AppiumDriverManager.getDriver()).terminateApp(Constants.BUNDLEID);
            }
            uninstallApp();
        } catch (RuntimeException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private void uninstallApp() throws MalformedURLException {
        if (Constants.PLATFORM_TYPE == PlatformType.ANDROID) {
            ((AndroidDriver)AppiumDriverManager.getDriver()).removeApp(Constants.PKGNAME);
        } else {
            ((IOSDriver)AppiumDriverManager.getDriver()).removeApp(Constants.BUNDLEID);
        }
    }

    private void loadTestConfiguration() throws IOException {
        PropertyUtils.loadConfigProperties();
        JsonUtils.loadDeviceProfile(Constants.DEVICE_PROFILE);
    }
}