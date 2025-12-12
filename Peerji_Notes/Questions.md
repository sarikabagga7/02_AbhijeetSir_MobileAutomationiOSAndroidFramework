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


38. Do I needb to add intelij in TestNG, for me drop dow of all testNG methos nor coming

39. In eclipse, How to create maven project

https://www.lambdatest.com/blog/threadlocal-in-java-with-selenium-webdriver/