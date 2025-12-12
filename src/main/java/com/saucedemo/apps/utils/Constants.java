package com.saucedemo.apps.utils;

import static com.saucedemo.apps.utils.PropertyUtils.Config;

public class Constants {
    // iOS App Details
    public static String BUNDLEID = Config.getProperty("app.bundle.id").trim();
    public static String APP_FILENAME = Config.getProperty("app.file.path").trim();

    // Android App Details
    public static String PKGNAME = Config.getProperty("apk.app.package").trim();
    public static String ACTIVITY = Config.getProperty("apk.app.activity").trim();
    public static String APK_FILENAME = Config.getProperty("apk.file.path").trim();

    // Appium Server Details
    public static String APPIUMJS_FILEPATH = Config.getProperty("appium.js.path").trim();
    public static String NODE_FILEPATH = Config.getProperty("appium.node.path").trim();
    public static String APPIUM_SERVER_ADDRESS = Config.getProperty("appium.ip.address").trim();
    public static int APPIUM_SERVER_PORT = Integer.parseInt(Config.getProperty("appium.port").trim());
    public static String APPIUM_LOG_FILEPATH = Config.getProperty("appium.log.path").trim();

    // Remote Server Details
    public static boolean ENABLE_REMOTE = Boolean.parseBoolean(Config.getProperty("remote.enable").trim());
    public static String REMOTE_USERNAME = Config.getProperty("remote.username").trim();
    public static String REMOTE_ACCESSKEY = Config.getProperty("remote.accessKey").trim();

    // Test Configuration
    public static PlatformType PLATFORM_TYPE = PlatformType.valueOf(
            Config.getProperty("platform.type").trim().toUpperCase());
    public static String DEVICE_PROFILE = Config.getProperty("device.profile").trim();
}
