package com.saucedemo.apps.object;

import com.saucedemo.apps.utils.Constants;
import com.saucedemo.apps.utils.JsonUtils;
import com.saucedemo.apps.utils.PlatformType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriverManager {
    private static final ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<>();

    public static AppiumDriver getDriver() throws MalformedURLException {
        if (DRIVER.get() == null) {
            Constants.PLATFORM_TYPE =
                    PlatformType.valueOf(Constants.getPlatformName().toUpperCase());
            DRIVER.set(getDriver(Constants.PLATFORM_TYPE));
        }
        return DRIVER.get();
    }

    public static void killDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        } else {
            throw new RuntimeException("Driver does not exist");
        }
    }

    private static AppiumDriver getDriver(PlatformType platformType) throws MalformedURLException {
        AppiumDriver driver;
        String url = "http://" + Constants.APPIUM_SERVER_ADDRESS + ":" + Constants.APPIUM_SERVER_PORT;

        if (platformType== PlatformType.ANDROID) {
            driver = getAndroidDriver(url);
        } else if (platformType == PlatformType.IOS) {
            driver = getIOSDriver(url);
        } else {
            throw new RuntimeException("Unsupported Platform Type");
        }

        return driver;
    }

    private static AppiumDriver getAndroidDriver(String url) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAvd(Constants.getDeviceName());
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/" + Constants.APK_FILENAME);
        options.setAppPackage(Constants.PKGNAME);
        options.setAppActivity(Constants.ACTIVITY);

        AppiumDriver driver = new AndroidDriver(new URL(url), options);
        return driver;
    }

    private static AppiumDriver getIOSDriver(String url) throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName(Constants.getDeviceName());
        options.setPlatformVersion(Constants.getPlatformVersion());
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/" + Constants.APP_FILENAME);
        options.setBundleId(Constants.BUNDLEID);

        AppiumDriver driver = new IOSDriver(new URL(url), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}