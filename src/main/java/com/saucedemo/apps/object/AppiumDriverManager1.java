package com.saucedemo.apps.object;

import com.saucedemo.apps.utils.Constants;
import com.saucedemo.apps.utils.PlatformType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AppiumDriverManager1 {

    private static final ThreadLocal<AppiumDriver> DRIVER = new ThreadLocal<>();


    public static AppiumDriver getDriver() throws MalformedURLException {
        if (DRIVER.get() == null) {
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
        if (Constants.PLATFORM_TYPE == PlatformType.ANDROID) {
            //driver = getAndroidDriver();
        	  driver = getAndroidDriver(url);
        } else if (Constants.PLATFORM_TYPE == PlatformType.IOS) {
            // driver = getIOSDriver();
              driver = getIOSDriver(url);
        } else
            throw new RuntimeException("Unsupported Platform Type");

        return driver;
    }

    private static AppiumDriver getAndroidDriver(String url) throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setAvd("Pixel_8");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/" + Constants.APK_FILENAME);
        options.setAppPackage(Constants.PKGNAME);
        options.setAppActivity(Constants.ACTIVITY);
        
        options.setNewCommandTimeout(Duration.ofSeconds(300));
        options.setAvdLaunchTimeout(Duration.ofSeconds(300));
        options.setAutoGrantPermissions(true);

        //AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        AppiumDriver driver = new AndroidDriver(new URL(url), options);
        return driver;
    }

    private static AppiumDriver getIOSDriver(String url) throws MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15");
        options.setPlatformVersion("17.0");
        options.setApp(System.getProperty("user.dir") + "/src/test/resources/apps/" + Constants.APP_FILENAME);
        options.setBundleId(Constants.BUNDLEID);

       // AppiumDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        AppiumDriver driver = new IOSDriver(new URL(url), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}
