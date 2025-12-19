Without paralleization

1. https://www.awesomescreenshot.com/my_items
2. sarikamobileclass2025@gmail.com
3. Sir Drive: https://drive.google.com/drive/u/1/folders/1Havx0BRWov8pMaYrLPZ4bithqqQhPi_F
4. Youtube: https://www.youtube.com/playlist?list=PLKHJvLumPy2TL6sv2_qVCHQ4H8QkM4mqn
5. Sir github: https://github.com/automationworldindia/AppiumDemo
6. MyGithub - sarikabagga7@gmail.com, tdsarika786@gmail.com
7. https://github.com/sarikabagga7/01_Appium_AbhijeetSirClass_MyCode_Peerji_2025
   
================================================================================================================================================
Framework without parallelization
Appium Class
----------------

AVD: Android Virtual Device - Emulator
=========================================
PS C:\Users\Dev> emulator -list-avds
Pixel_8

ADB: Android Debug Bridge
=================================
PS C:\Users\Dev> adb devices
List of devices attached
emulator-5554   device

PS C:\Users\Dev> adb shell
emu64xa:/ $ dumpsys window windows

emu64xa:/ $ dumpsys window windows | grep -E 'Window #'
  Window #0 Window{f9ebc9 u0 ScreenDecorOverlayBottom}:
  Window #1 Window{9275446 u0 ScreenDecorOverlay}:
  Window #2 Window{31e5788 u0 EdgeBackGestureHandler0}:
  Window #3 Window{335b985 u0 Taskbar}:
  Window #4 Window{e379dc1 u0 NotificationShade}:
  Window #5 Window{b622725 u0 StatusBar}:
  Window #6 Window{3796b65 u0 ShellDropTarget}:
  Window #7 Window{979c39b u0 InputMethod}:
  Window #8 Window{4730a8e u0 io.appium.android.apis/io.appium.android.apis.ApiDemos}:
  Window #9 Window{68b3161 u0 com.google.android.apps.nexuslauncher/com.google.android.apps.nexuslauncher.NexusLauncherActivity}:
  Window #10 Window{f3fdc67 u0 com.android.systemui.wallpapers.ImageWallpaper}:
emu64xa:/ $

EXIT
============
130|emu64xa:/ $ exit


CTRL+Shift+O = Import Packages

PS C:\Users\Dev> Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass


START AAPIUM
===================
PS C:\Users\Dev> appium
[Appium] Welcome to Appium v3.1.1
[Appium] The autodetected Appium home path: C:\Users\Dev\.appium
[Appium] Attempting to load driver uiautomator2...
[Appium] Requiring driver at C:\Users\Dev\.appium\node_modules\appium-uiautomator2-driver\build\index.js
[Appium] AndroidUiautomator2Driver has been successfully loaded in 7.070s
[Appium] Appium REST http interface listener started on http://0.0.0.0:4723
[Appium] You can provide the following URLs in your client code to connect to this server:
        http://10.5.0.2:4723/
        http://192.168.2.30:4723/
        http://127.0.0.1:4723/ (only accessible from the same host)
[Appium] Available drivers:
[Appium]   - uiautomator2@6.2.1 (automationName 'UiAutomator2')
[Appium] No plugins have been installed. Use the "appium plugin" command to install the one(s) you want to use.
[Appium] Received SIGINT - shutting down
[AppiumDriver@7dbc] There are no active sessions for cleanup

Window #8 Window{4730a8e u0 io.appium.android.apis/io.appium.android.apis.ApiDemos}:
===========================================================
io.appium.android.apis/io.appium.android.apis.ApiDemos

io.appium.android.apis -> Package

io.appium.android.apis.ApiDemos -> Activity


STEPS For Maven Project
=======================
1. Go to maven project
2. add artifact id and maven is strat skeltion
3. pom.xml - appium dependencies
https://mvnrepository.com/artifact/io.appium/java-client/9.4.0
<!-- https://mvnrepository.com/artifact/io.appium/java-client -->
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>10.0.0</version>
</dependency>
4. Run As -> Maven Test


5. Right click properties -> Java Build Path -> Add Library -> Alteratre (Installed JRE) -> JDK 17

6. Appium Server Keep and running

7. Stop and Start the Device

Appium Inspector for Android
============================
appium:deviceName   =  Pixel 8

platformName =  android

appium:automationName = UiAutomator2

Now start Sesssion

{
  "appium:deviceName": "appium:deviceName",
  "platformName": "android",
  "appium:automationName": "UiAutomator2"
}
******************************************************************************************************************************************

CLASS - 2
=================

Locator Strategies
=======================
-> Always take id and accessibility Id - Its can be used by same ios and android

-> ID mapped with resource-id
   Accessibility Id mapped with content-desc


CLASS 3
===========
Wait Strategies:
------------------
Implict Wait
==================
//poll for 500ms for a max of 5secs and then throw NoSuchElementException, its applicable to all where I put driver.findelement implicit wait 
 // if does not find throws NoSuchElementException           
    //Implicit wait
            //poll for 500ms for a max of 5secs and then throw NoSuchElementException, its applicable to all where I put driver.findelement implicit wait 
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


Explicit Wait
============
// wait for particular element
WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(3));
wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\\\"android:id/month_view\\\").childSelector(new UiSelector().description(\\\"10 November 2025\\\"))")));

			
Fluent Wait
==============
//if element not found within max time period, it will throw TimeoutException
//Fluent wait: Poll for 1 seconds till 3 seconds, in fluent you change polling wait

        FluentWait<AppiumDriver> wait = new FluentWait<>(driver)
                    .pollingEvery(Duration.ofSeconds(1))
                    .withTimeout(Duration.ofSeconds(3)) // maximum timeout 3 times it will check, wait for 1 second and check, waint for 1 second and check, wait for 1 second and check
                    .ignoring(NoSuchElementException.class)
                    .withMessage("Element not found");
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath("//android.widget.TwoLineListItem")));


findElement/findElements
====================================
//WebElement element = driver.findElement(AppiumBy.xpath(("//android.widget.TwoLineListItem/android.widget.TextView[")))
            /*
             Difference:
             findElement - find first element, no element throws no such element exception,
             findElements - find list of elements, no element shows size 0 empty list, 
             */
            
            //List<WebElement> elements = driver.findElements(AppiumBy.xpath("//android.widget.TwoLineListItem/android.widget.TextView[@resource-id='android:id/text1']"));
            List<WebElement> elements = driver.findElements(AppiumBy.xpath("//android.widget.TwoLineListItem/android.widget.TextView[starts-with(@text, 'Child')]"));
            for (int i=0; i<elements.size(); i++) {
                System.out.println(elements.get(i).getAttribute("text"));
            }
    

STEPS TO INSTALL SAUCE LABS APP
=======================================
1. get the application
2. Drag abd Drop to Android stusio Pixel 8
3. CLI Steps to get Pkgname and activity
PS C:\Users\Dev> adb devices
List of devices attached
emulator-5554   device

PS C:\Users\Dev> adb shell
emu64xa:/ $ dumpsys window windows | grep -E 'Window #'
  Window #0 Window{f9ebc9 u0 ScreenDecorOverlayBottom}:
  Window #1 Window{9275446 u0 ScreenDecorOverlay}:
  Window #2 Window{31e5788 u0 EdgeBackGestureHandler0}:
  Window #3 Window{335b985 u0 Taskbar}:
  Window #4 Window{e379dc1 u0 NotificationShade}:
  Window #5 Window{b622725 u0 StatusBar}:
  Window #6 Window{3796b65 u0 ShellDropTarget}:
  Window #7 Window{979c39b u0 InputMethod}:
  Window #8 Window{68b3161 u0 com.google.android.apps.nexuslauncher/com.google.android.apps.nexuslauncher.NexusLauncherActivity}:
  Window #9 Window{f3fdc67 u0 com.android.systemui.wallpapers.ImageWallpaper}:
emu64xa:/ $ dumpsys window windows | grep -E 'Window #'
  Window #0 Window{f9ebc9 u0 ScreenDecorOverlayBottom}:
  Window #1 Window{9275446 u0 ScreenDecorOverlay}:
  Window #2 Window{31e5788 u0 EdgeBackGestureHandler0}:
  Window #3 Window{335b985 u0 Taskbar}:
  Window #4 Window{e379dc1 u0 NotificationShade}:
  Window #5 Window{b622725 u0 StatusBar}:
  Window #6 Window{3796b65 u0 ShellDropTarget}:
  Window #7 Window{979c39b u0 InputMethod}:
  Window #8 Window{aaf5e1d u0 com.swaglabsmobileapp/com.swaglabsmobileapp.MainActivity}:
  Window #9 Window{68b3161 u0 com.google.android.apps.nexuslauncher/com.google.android.apps.nexuslauncher.NexusLauncherActivity}:
  Window #10 Window{f3fdc67 u0 com.android.systemui.wallpapers.ImageWallpaper}:
emu64xa:/ $


CLASS 24-11-2025
=========================

PS C:\Users\Dev> Set-ExecutionPolicy -Scope Process -ExecutionPolicy Bypass

Mobile Gestures
==================
- I can tap on the application
- press and hold this
- You can mimic the gesture
- Click gesture
- Double Click gesture
- Long Click gesture
- Drag and drop gesture
- Scroll gesture

Code: Click gesture by Id
=================
  WebElement element = driver.findElement(AppiumBy.xpath("//android.widget.TextV"))
  HashMap<String,Object> params = new HashMap<String,Object>();
  params.put("elementId",((RemoteWebElement)menuOption).getId());
  driver.executeScript("mobile: clickGesture",params);

Code: click gesture {coordinates option} ==> clickable property should be true
======================
 WebElement element =driver.findElement(AppiumBy.accessibilityId("Buttons"));
 int x= element.getLocation().getX();
 int y= element.getLocation().getY();
 int width = element.getSize().getWidth();
 int height = eleemnt.getSize().getHeight();
 int centerX=x+width/2;
 int centerY=y+height/2;

 hashMap<String,Object> params = new HashMap<>();
 params.put("x",centerX);
 params.put("y",centerY);
 driver.exceuteScript("mobile: clickGesture", params)

int -> Integer {wrapper class, super parent of every class is Object}
float - Float {}

 Scroll Gesture = scrollable property = true
 =====================
 Till you see the target element
 
 Hashmap<String,Object> params = new HashMap<>();
 params.put("elementId",(RemoteWebElement)driver.findElement(AppiumBy.id(""))).getId();
 params.put("direction","down");
 params.put("percent",0.3);
 if(!isElementDisplayed(driver,targetLoactor)){
 driver.executeScript("")
 }


public static boolean isElementDisplayed(AppiumDriver driver, By locator){
  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
  try{
  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  return true;
} 
catch (TimeoutException e){
return false;
}
}
 
CLASS Nov 27
==========
WebDriver ->(implements) RemoteWebDriver ->(extends) Chrome Driver
Appium Drver -> AndroidDriver,iOS Driver

Hybrid Apps
-------------
Native Apps - Code written with Android Libraries

Web View - Code written with normal Web Applications

DEC 01, 2025
=============
- Mobile Browser automation
- XCode install from appstore, Add simulator device


DEC 02, 2025
=============
Program:
----------
1. Start Appium service
2. XCUITestOptions
3. BundleId like in Android having -> package name and activity
4. 

Dec 03, 2025
===========
Locator Find way - predicate String
iOS Class Chain or predicate String better than Xpath
First Go with ID -> iOS Class Chain -> Xpath {Faster}
Accessible attribute Flase - canot click
Predicate STring - canot use child parent hirarchy


Dec 04, 2025
==============
Tap gesture Demo
------------------
Scroll Gesture
----------------


Appium Inspector for iOS
=========================
1. platformName = iOS
2. appium:automationName: XCUITest
3. appium:deviveName = iPhone 15
4. appium.platforName = iOS 26.1

{
  "platformName": "ios",
  "appium:automationName": "XCUITest",
  "appium:deviceName": "iPhone 15",
  "appium:platformVersion": "17.0"
}

Dec 05, 2025
===============
1. Scroll Gestures
2. Swipe Gesture

Dec 08, 2025
============
1.Install Robot app on iphone and get bundleID
2. Drag Gesture Demo - Robot App ios
3. Picker Wheel - UI Cart App ios PickerWheelGesture
4. TapAndHoldGesture Demo {Pressed for 4 seconds}
5. 

Dec 08, 2025
============
1. Screen Rotation
2. Hybrid App Native WebView - iOS
3. 


simctl not found
------------------------
✅ 1. Find your Xcode location
mdfind "kMDItemCFBundleIdentifier == 'com.apple.dt.Xcode'"

✅ 2. (After it prints a path)

Copy the first path and run this — replace the path if different:

sudo xcode-select --switch /Applications/Xcode.app/Contents/Developer

(If your path is different, replace /Applications/Xcode.app with what you got in step 1.)

✅ 3. Confirm developer path
xcode-select -p

✅ 4. Accept license
sudo xcodebuild -license


Type: agree and press Enter

✅ 5. Check simctl exists
ls $(xcode-select -p)/usr/bin/simctl

✅ 6. Test simctl
xcrun simctl list

✅ 7. Check simctl path
which simctl

✅ 8. Your original command
xcrun simctl listapps booted | grep CFBundleIdentifier

simctl exists but is NOT in your PATH (environment variable).
--------------------------------------
We’ll fix that now.

Run these commands exactly in order:

✅ 1. Confirm simctl exists inside Xcode
ls $(xcode-select -p)/usr/bin/simctl

If it prints the file path → continue
If it says "No such file" → stop and paste it here
✅ 2. Add Xcode tools to your PATH (zsh shell)
echo 'export PATH="$(xcode-select -p)/usr/bin:$PATH"' >> ~/.zshrc

✅ 3. Reload terminal config
source ~/.zshrc

✅ 4. Test again
which simctl

Expected:
/Applications/Xcode.app/Contents/Developer/usr/bin/simctl

✅ 5. Final test
xcrun simctl list

✅ 6. Retry your original command
xcrun simctl listapps booted | grep CFBundleIdentifier

sarika@Sarikas-MacBook-Pro-14-inch ~ % vim ~/.zshrc
-----------------
sarika@Sarikas-MacBook-Pro-14-inch ~ % vim ~/.zshrc

export PATH=/opt/homebrew/bin:$PATH
alias python=/usr/bin/python3
# Maven Config Options
export M2_HOME=/Users/sarika/Downloads/apache-maven-3.9.4
export M2=$M2_HOME/bin
export PATH=$M2:$PATH
export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-17.jdk/Contents/Home
export PATH=$JAVA_HOME/bin:$PATH
# Android
export ANDROID_HOME=/Users/sarika/Library/Android/sdk
export PATH=$ANDROID_HOME/emulator:$ANDROID_HOME/tools:$ANDROID_HOME/tools/bin:$ANDROID_HOME/platform-tools:$PATH
export PATH="$(xcode-select -p)/usr/bin:$PATH"


NOTES
==============
1. WHen running appium script, you have quit appium inspector and start session again
2. ID mapped with resource-id
   Accessibility Id mapped with content-desc
3. Appium Inspector : -> Search can find the loctaors
4. In Android stusio close the application in the emulator     
5. .instance() = index last elemet
.instance(10) = index 10th element
6. Native Apps
   Web Apps
   Hybrid Apps
7. iOS - Simulator
Android - Emulator
8. In iOS not using resourceID part
9. In IOS name use as accessibility Id
10. In Android content desc as accessibilty Id
11. -> For Android: Always take id and accessibility Id - Its can be used by same ios and android
-> ID mapped with resource-id
   Accessibility Id mapped with content-desc
12. iOS Class Chain or predicate String better than Xpath
First Go with ID -> iOS Class Chain -> Xpath {Faster}
13. WebDriver ->(implements) RemoteWebDriver ->(extends) Chrome Driver
14. iOS appium inspector
{
  "platformName": "ios",
  "appium:automationName": "XCUITest",
  "appium:deviceName": "iPhone 15",
  "appium:platformVersion": "17.0"
}
15. Android appium inspector
{
  "appium:deviceName": "appium:deviceName",
  "platformName": "android",
  "appium:automationName": "UiAutomator2"
}
16. Locator Find way - predicate String
iOS Class Chain or predicate String better than Xpath
First Go with ID -> iOS Class Chain -> Xpath {Faster}
Accessible attribute Flase - canot click
Predicate STring - canot use child parent hirarchy

17.  AppiumBy.accessibilityId("...");
content-desc (in android)
name (in ios)
This is the fastest. 
To be used when the element is same in both android and ios.

18. Sometime you will get the error WebDriver Agent will not get installed in your simulator
    sarika@Sarikas-MacBook-Pro-14-inch ~ % cd /Users/sarika/.appium/node_modules/appium-xcuitest-driver/node_modules/appium-webdriveragent
	sarika@Sarikas-MacBook-Pro-14-inch appium-webdriveragent % open WebDriverAgent.xcodeproj
    -> When it get open -> On the top Select Any iOS Simulator Device -> and Integration App -> Click on Product- Clean Folder and also Click on Product- Build
                        -> On the top Select Any iOS Simulator Device -> and WebDriverAgentLib -> Click on Product- Clean Folder and also Click on Product- Build
                        -> On the top Select Any iOS Simulator Device -> and WebDriverAgentRunner -> Click on Product- Clean Folder and also Click on Product- Build

	
LINKS:
============
1. Github 
https://github.com/automationworldindia/AppiumDemo

2. Appium Capabilities
https://appium.io/docs/en/2.0/guides/caps/

3. Appium Inspector
appium:deviceName =Pixel 8
platformName = android
appium:automationName = UiAutomator2

iOS Android Inspector
"platformName": "ios",
  "appium:automationName": "XCUITest",
  "appium:deviceName": "iPhone 15",
  "appium:platformVersion": "17.0"

5. Maven Dependency Link:
https://mvnrepository.com/artifact/io.appium/java-client/9.4.0

6. Download appium inspector
https://github.com/appium/appium-inspector/releases

7. Node js download
https://nodejs.org/en/download

8. Java Jdk
   https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

9. Gestures Android
   https://appium.github.io/appium.io/docs/en/writing-running-appium/android/android-mobile-gestures/

10. ChromeDriver Downloads: -> click on JSON endpoints
   https://developer.chrome.com/docs/chromedriver/downloads




CLI Commands
===============
1. PS C:\Users\Dev> emulator -list-avds
   -------
Pixel_8

2. PS C:\Users\Dev> adb devices
   -----------
List of devices attached
emulator-5554   device

3. PS C:\Users\Dev> adb shell
   ------
emu64xa:/ $ dumpsys window windows

4. emu64xa:/ $ dumpsys window windows | grep -E 'Window #'
    ------

5. PS C:\Users\Dev> appium
   -------
[Appium] Welcome to Appium v3.1.1

6. Real DEvice
   --------
sarika@Sarikas-MacBook-Pro-14-inch AppiumDemo_MyClassNOtes % adb devices
List of devices attached
RZ8R40GCL6F	device
emulator-5554	device

sarika@Sarikas-MacBook-Pro-14-inch AppiumDemo_MyClassNOtes % adb -s RZ8R40GCL6F shell
a72q:/ $ dumpsys window windows | grep -E 'Window #'

7. Run Appium
   ---------
   sarika@Sarikas-MacBook-Pro-14-inch ~ % appium

8. BundelId for iOS
   ---------------
   sarika@Sarikas-MacBook-Pro-14-inch ~ % xcrun simctl listapps booted | grep -E 'CFBundleIdentifier'
        CFBundleIdentifier = "com.apple.shortcuts";
        CFBundleIdentifier = "com.apple.webapp";
        CFBundleIdentifier = "com.nsoojin.BookStore";

9. ios xcuitest install
    ---------------
   sarika@Sarikas-MacBook-Pro-14-inch ~ % appium driver install xcuitest
✔ Checking if 'appium-xcuitest-driver' is compatible
✔ Installing 'xcuitest'
ℹ Driver xcuitest@10.9.0 successfully installed
- automationName: XCUITest
- platformNames: ["iOS","tvOS"]
sarika@Sarikas-MacBook-Pro-14-inch ~ % appium driver list --installed
✔ Listing installed drivers
- uiautomator2@4.2.9 [installed (npm)]
- xcuitest@10.9.0 [installed (npm)]
sarika@Sarikas-MacBook-Pro-14-inch ~ % 

10. Open eclipse terminal
    -------------
    open /Applications/Eclipse.app

11. WebDriverAgent
    ---------------
sarika@Sarikas-MacBook-Pro-14-inch ~ % cd /Users/sarika/.appium/node_modules/appium-xcuitest-driver/node_modules/appium-webdriveragent
sarika@Sarikas-MacBook-Pro-14-inch appium-webdriveragent % open WebDriverAgent.xcodeproj 

12. iPhone Simulator Devices
    -------------
    sarika@Sarikas-MacBook-Pro-14-inch appium-webdriveragent % xcrun xctrace list devices
== Devices ==
Sarika’s MacBook Pro 14 inch (88E11EC6-24CC-588A-B5FE-F78840742FD1)
== Devices Offline ==
iPhone (26.1) (00008120-001C395001C0201E)
== Simulators ==
iPhone 15 Simulator (17.0) (04131198-3DFA-4F51-96CA-C3963AA1F985)
iPhone 17 Simulator (26.1) (1B7481F8-7B0B-454B-87C0-88DF090FADC2)

11. Command: iOS get listed apps
    ------
sarika@Sarikas-MacBook-Pro-14-inch ~ % xcrun simctl listapps booted | grep -E 'CFBundleIdentifier'
        CFBundleIdentifier = "com.apple.webapp";
        CFBundleIdentifier = "com.example.apple-samplecode.UICatalog";
        CFBundleIdentifier = "com.facebook.WebDriverAgentRunner.xctrunner";
        CFBundleIdentifier = "com.nsoojin.BookStore";

12. Node
    -----
sarika@Sarikas-MacBook-Pro-14-inch ~ % where node
/opt/homebrew/bin/node

13. Appium
    --------
sarika@Sarikas-MacBook-Pro-14-inch ~ % where appium
/opt/homebrew/bin/appium

14. Android Shell, listed apps
    --------------------------
    PS C:\Users\Dev> adb shell
emu64xa:/ $ dumpsys window windows | grep -E 'Window #'

15. How to get your simulator details?
    -------------------
$ xcrun simctl list devices available  #returns a list of simulators created using XCode

$ xcrun simctl list devices booted       #returns a list of UDIDs of running simulators

sarika@Sarikas-MacBook-Pro-14-inch ~ % xcrun simctl list devices booted 
== Devices ==
-- iOS 17.0 --
    iPhone 15 (04131198-3DFA-4F51-96CA-C3963AA1F985) (Booted) 
-- iOS 26.1 --
sarika@Sarikas-MacBook-Pro-14-inch ~ % xcrun simctl list devices available
== Devices ==
-- iOS 17.0 --
    iPhone 15 Pro (356C8DE1-4745-4529-B2A2-2D50C78D5A22) (Shutdown) 
    iPhone 15 (04131198-3DFA-4F51-96CA-C3963AA1F985) (Booted) 

16. How to get your app details?
    ------------------
Keep your app open.
In terminal, run the below command
$ xcrun simctl listapps booted | grep -E 'CFBundleIdentifier'

17. 

QUESTIONS
===============

1. Ques 1. Do we need to create script for Samsumg, ios 8, pixel 8 - for  all mobiles, pisxel 7, pixel 10??? Yes
2. Ques 2: How to quit the application manually ned to do when error //  finally block
3. Ques 3: How to integrate with Jenkins // Perfecto server - cloud based virtual device are there 
4. Ques 4: Appium inspector - search locator its not getting highlighted  -   
5. Ques 5: waiting 5 seconds, poll for 500 ms is that the logic --> if I put 7 seconds , poll for 700 ms? - implicit and explicit wait (500 ms) , Explicit Wait having : - (web driver wait , Fluent wait)
6. Ques 6: When upload the video dont just Day 1, Day 2 instead put installation, locators, waits
7. Ques 7: When need tod evelop automation scripts where we do gestures or click, is it possible clikc works and gestures not? go with gestures
8. Ques 8: Today i had an issue to launching Pixel 8 device so i wiped the data and I run the java application, it throws error- , so i need to drag and drop agian its not installing the applocation- Exception in thread "main" org.openqa.selenium.WebDriverException: Error executing adbExec. Original error: 'Command ''C:\Users\Dev\AppData\Local\Android\Sdk\platform-tools\adb.exe' -P 5037 -s emulator-5554 shell am start-activity io.appium.android.apis/io.appium.android.apis.ApiDemos' exited with code 1'; Command output: Error type 3
Error: Activity class {io.appium.android.apis/io.appium.android.apis.ApiDemos} does not exist.
9. Which code automatically installed application?
10. Key Event Close the application????? - KeyEvent file?
11.  Android real device automation browser and app? can we do one program?
12.  Screen rottaion code, scrolling not working program ----- 
13.  How to automate mobile browsers?
14.  Why getting this error - same error getting : Exception in thread "main" io.appium.java_client.NoSuchContextException: No Chromedriver found that can automate Chrome '133.0.6943'. You could also try to enable automated chromedrivers download as a possible workaround.
Build info: version: '4.38.0', revision: '6b412e825c*'
System info: os.name: 'Mac OS X', os.arch: 'aarch64', os.version: '26.1', java.version: '17.0.12'
Driver info: io.appium.java_client.android.AndroidDriver
15. Can you share this testNG code also?
16. Original Android wire need to connect with briwser 
17. Ques: On Mac, when I dont run the appium on terminal getting error. - whe  run the Java Application
org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Response code 500. Message: Neither ANDROID_HOME nor ANDROID_SDK_ROOT environment variable was exported. Read https://developer.android.com/studio/command-line/variables for more details 
Host info: host: 'Sarikas-MacBook-Pro-14-inch.local', ip: 'fe80:0:0:0:875:49bb:7e2:3fbf%en0'
Build info: version: '4.38.0', revision: '6b412e825c*'
System info: os.name: 'Mac OS X', os.arch: 'aarch64', os.version: '26.1', java.version: '17.0.12'
Driver info: io.appium.java_client.android.AndroidDriver
Command: [null, newSession {capabilities=[Capabilities {appium:automationName: UIAutomator2, appium:avd: Pixel_8, appium:chromedriverExecutable: /Users/sarika/peerji_eclips..., browserName: Chrome, platformName: ANDROID}]}]
Capabilities {appium:automationName: UIAutomator2, appium:avd: Pixel_8, appium:chromedriverExecutable: /Users/sarika/peerji_eclips..., browserName: Chrome, platformName: ANDROID}
	at org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:114)
	at org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:75)
	at org.openqa.selenium.remote.ProtocolHandshake.createSession(ProtocolHandshake.java:61)
	at io.appium.java_client.remote.AppiumCommandExecutor.createSession(AppiumCommandExecutor.java:178)
	at io.appium.java_client.remote.AppiumCommandExecutor.execute(AppiumCommandExecutor.java:243)
	at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:557)
	at io.appium.java_client.AppiumDriver.startSession(AppiumDriver.java:308)
	at org.openqa.selenium.remote.RemoteWebDriver.<init>(RemoteWebDriver.java:174)
	at io.appium.java_client.AppiumDriver.<init>(AppiumDriver.java:98)
	at io.appium.java_client.AppiumDriver.<init>(AppiumDriver.java:109)
	at io.appium.java_client.android.AndroidDriver.<init>(AndroidDriver.java:108)
	at demo.android.myclass.BrowserTest_mac.main(BrowserTest_mac.java:29)
ANS: .zsc profile, your eclipse, from yur, open your eclipse
In Terminal run following command it will open ypur eclispe that will gather Android_home keys error resolve
open /Applications/Eclipse.app
 
19. Ques 18. How to run in the Samsung Inbuilt Browser of Android ----

20. sarika@Sarikas% xcrun simctl listapps boted | grep -E 'CFBundleIdentifier'
xcrun: error: unable to find utility "simctl", not a developer tool or in PATH

22. [AppiumDriver@b4bd][0m Encountered internal error running command: Error: Could not find a driver for automationName 'XCuiTest' and platformName 'IOS'. Have you installed a driver that supports those capabilities? Run 'appium driver list --installed' to see. (Lower-level error: Could not find installed driver to support given caps)
    at DriverConfig.findMatchingDriver (/opt/homebrew/lib/node_modules/appium/lib/extension/driver-config.js:173:13)
    at AppiumDriver.createSession (/opt/homebrew/lib/node_modules/appium/lib/appium.js:303:35)
    at runCommandPromise (/opt/homebrew/lib/node_modules/appium/node_modules/@appium/base-driver/lib/basedriver/driver.ts:116:20)
    at AppiumDriver.executeCommand (/opt/homebrew/lib/node_modules/appium/node_modules/@appium/base-driver/lib/basedriver/driver.ts:161:15)
    at processTicksAndRejections (node:internal/process/task_queues:103:5)
    at defaultBehavior (/opt/homebrew/lib/node_modules/appium/lib/appium.js:726:16)
    at AppiumDriver.executeWrappedCommand (/opt/homebrew/lib/node_modules/appium/lib/appium.js:843:16)
    at AppiumDriver.executeCommand (/opt/homebrew/lib/node_modules/appium/lib/appium.js:742:17)
    at asyncHandler (/opt/homebrew/lib/node_modules/appium/node_modules/@appium/base-driver/lib/protocol/protocol.ts:409:19)

23. LF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details. Exception in thread "main" java.lang.RuntimeException: org.openqa.selenium.SessionNotCreatedException: Could not start a new session. Response code 500. Message: WebDriverAgent is not initialized Host info: host: 'Sarikas-MacBook-Pro-14-inch.local', ip: 'fe80:0:0:0:1048:d9f0:33ae:482a%en0'

Install iOS 26.1

SIR ANSWER
---------
/Users/<user-name>/.appium/node_modules/appium-xcuitest-driver/node_modules/appium-webdriveragent
- open WebDriver Agent {Dont Download from github}
-On the top click on the Integration App -> Go to Top menu - clean then - click on Build
- On the top click on the WebDriverAgentRunner -> Go to Top menu - clean then - click on Build
- Click on the Integration App -> Go to Top menu - clean then - click on Build
  

25. appium driver install xcuitest

26. Powerpoint, slide 7, how to get udid
    //Option 2: to connect to an already running simulator/physical device
options.setUdid("8F027E83-A5B4-400C-AD0D-47B9AB8226D2");

adb devices {Android}

adb devices
emulator -list-avds
Diff - udid: running devices catch, setavid - start and run device

27. How to run on Safari?

28. How to run on iohone real device

29. Console Error- when Ran ScrollGesture
[e39d32e7][0m[38;5;145m[AppiumDriver@88c6][0m Encountered internal error running command: NoSuchDriverError: A session is either terminated or not started
    at asyncHandler (/opt/homebrew/lib/node_modules/appium/node_modules/@appium/base-driver/lib/protocol/protocol.ts:329:15)
    at /opt/homebrew/lib/node_modules/appium/node_modules/@appium/base-driver/lib/protocol/protocol.ts:524:15
    at Layer.handleRequest (/opt/homebrew/lib/node_modules/appium/node_modules/router/lib/layer.js:152:17)
    at next (/opt/homebrew/lib/node_modules/appium/node_modules/router/lib/route.js:157:13)
    at Route.dispatch (/opt/homebrew/lib/node_modules/appium/node_modules/router/lib/route.js:117:3)
    at handle (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:435:11)
    at Layer.handleRequest (/opt/homebrew/lib/node_modules/appium/node_modules/router/lib/layer.js:152:17)
    at /opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:295:15
    at param (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:600:14)
    at param (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:610:14)
    at processParams (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:664:3)
    at next (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:291:5)
    at logger (/opt/homebrew/lib/node_modules/appium/node_modules/morgan/index.js:144:5)
    at Layer.handleRequest (/opt/homebrew/lib/node_modules/appium/node_modules/router/lib/layer.js:152:17)
    at trimPrefix (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:342:13)
    at /opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:297:9
    at processParams (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:582:12)
    at next (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:291:5)
    at jsonParser (/opt/homebrew/lib/node_modules/appium/node_modules/body-parser/lib/types/json.js:100:7)
    at Layer.handleRequest (/opt/homebrew/lib/node_modules/appium/node_modules/router/lib/layer.js:152:17)
    at trimPrefix (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:342:13)
    at /opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:297:9
    at processParams (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:582:12)
    at next (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:291:5)
    at Layer.handleRequest (/opt/homebrew/lib/node_modules/appium/node_modules/router/lib/layer.js:147:12)
    at trimPrefix (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:342:13)
    at /opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:297:9
    at processParams (/opt/homebrew/lib/node_modules/appium/node_modules/router/index.js:582:12)
[38;5;90m[e39d32e7][0m[38;5;86m[HTTP][0m [37m<-- GET /session/e39d32e7-51fc-43ce-9d5b-fccb4c353ad1/timeouts [39m[33m404[39m [90m2 ms - 2884[39m [90m[39m

30. Swipe Scroll when we run the code not working when Debug it works

31. Half of the element visible, chage target locator
By targetLocator1 = AppiumBy.xpath("//XCUIElementTypeStaticText[@value='Sauce Labs Fleece Jacket']//parent::XCUIElementTypeOther//following-sibling::XCUIElementTypeOther//XCUIElementTypeOther[@label='ADD TO CART']");

32. In Framework we are doing Cucumber?

33. Why we chhose Java 17? is most stable one

34. Can I install two java, because cucumber plugin need java 21? {YES, Right lcikc Java path set Java Library }

35. Can we do env variables for platform type means from terminal

36. What is thread safe? {Parallel execution, In one driver instance we can run Android and other ios ohone}

37. In pom.xml to do this depenedncy
    <!-- https://mvnrepository.com/artifact/com.codoid.products/fillo -->
      <dependency>
          <groupId>com.codoid.products</groupId>
          <artifactId>fillo</artifactId>
          <version>1.18</version>
      </dependency>
	  Need to add the following Repositories
	     <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>


38. Do I needb to add intelij in TestNG, for me drop dow of all testNG method nor coming

39. In eclipse, How to create maven project

https://www.lambdatest.com/blog/threadlocal-in-java-with-selenium-webdriver/

40. What will be the framework for mobile browsers? Will get it from Sir -------------

41. MCP Server, self healing locators - AI

AI Tools
==========
1. Gemini
2. SCreen Mirror - use Vysor,https://www.vysor.io/


CLASS DEC 10, 2025
==================
1. Framework
   -> src -> main -> java -> com.saucedemo.apps
                                               -> base package
                                               -> object package
                                               -> utils package {reusable}
                                               -> controller package {service, appium server}
    -> src -> main -> java -> com.saucedemo.apps
                                             -> pages package
                                             -> test

2. Pom.xml - Dependency
                       1. Java Client - Appium maven
                       2. Extent Reports, one more tool Allure Reports 
                       3. Jackson -for json
                       4. Fillo - read excel , sql format, read test case id
                       5. Sync all maven projects

3. Plugin -> copilot - install

4. Create New File -> testng-sanity.xml
    <suite name ="SanityTestSuite">
	  <test name="SanityTests">
        <packages>
		   <package name="com.saucedemo.apps.test"/>
        </packages>
	  </test>
	</suite>
6. In Base Package: Ques: How we will use the abstract class
             - BaseTest - abstract class - no one create object of that class
               @BeforeTest
               public void suiteSetup(){
                }
                @BeforeMethod
                public void testSetup(){
                }
                @AfterMethod
				public void testTeardown(){
                }
                @AfterTest
                public void suiteTeardown(){
                }
   
7. In Top -> Edit Configuration ->( For Run ) -> Add Configuration -> TestNG -> testng.xml -> 

8. To Add resources folder -> right test package -> Add Directory -> Select resources it will add resources folder

9. 
                                          

SIR NOTES
=============
1. Google drive ppt
2. Github code


STEPS:
======
1. Open Intellij
2. Create New project
3. Select Generators -> Maven Archetype
4. Name - Sauce Demo, Location, JDK - 17 Homebre OpenJDK 17.0.17 /opt/homebrew/opt/openjdk@17/libexec/openjdk.jdk/Contents/home or check with which java from terminal path
   Arche Type - org.apache.maven.archetypes:maven-archetype-quickstart, Group id - website
5.  Dependencies
https://mvnrepository.com/artifact/io.appium/java-client/10.0.0
<!-- https://mvnrepository.com/artifact/io.appium/java-client -->
<dependency>
    <groupId>io.appium</groupId>
    <artifactId>java-client</artifactId>
    <version>10.0.0</version>
</dependency>

https://mvnrepository.com/artifact/org.testng/testng/7.11.0
<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.11.0</version>
    <scope>test</scope>
</dependency>

https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.19.2</version>
</dependency>

https://mvnrepository.com/artifact/com.codoid.products/fillo
<!-- https://mvnrepository.com/artifact/com.codoid.products/fillo -->
<dependency>
    <groupId>com.codoid.products</groupId>
    <artifactId>fillo</artifactId>
    <version>1.18</version>
</dependency>

6. CLcik on small m -> Syc maven changes

CLASS DEC 11, 2025, THURSDAY
===============================
https://www.youtube.com/watch?v=xg9w6woWgts&list=PLXU_RLMAovjQXEUiWEvrBzkwnb9F2WfaS&index=4

Framework:
---------
- Thread Local consider as ArrayList
- SO its automatically - 
- Staic Thread LOcal as its going to use every where
- 


