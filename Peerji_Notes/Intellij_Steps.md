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