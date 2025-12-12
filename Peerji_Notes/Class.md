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


CLASS DEC 11, 2025 - THURSDAY
==============================

