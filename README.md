# HFSCarQuote

**Pre-Requisites**
1. Generate a maven project - mvn archetype:generate
2.Using Maven repo to avoid any explict webdriver, Junit and java jar files download and management into the project. Update these details in the POM.xml
3. If using maven, add the following dependency -
	<dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>3.141.59</version>
    </dependency>

3. Download the EdgeDriver.exe as it will need to be used in the code
4. Import drivers into your project. Do it  for all browsers - Edge, Chrome and Firefox. The browsers and corresponding driver versions must match.
5. Wait 2 secs before each action.


**Challenges faced**
1. StaleElemenException ; Reason AJAX call that updates the webelements dynamically. Found with the drop-down elements hence could not use Select Class for drop down objects identification

2.Selenium.ElementNotInteractable - Unable to click the button since its out of foucs.
Reason - Window resizing.
Fix - Launch the Window in maximised mode and and page load time.

3.org.openqa.selenium.InvalidSelectorException
Reason - Unable to uniquely identify the element based on the locators specified.
Fix - Use Relative xpath values

4. Use judgement to identify what elements we need in xpath for example the 'Yes' button text and button (easire to identify without long and complex classes to be provided in the path)


Wanted to have a framework, so the values did not have to be hardcoded in the method and rather just select values based on index of the elements
based on the index value then iterate through all possible dependant values
Standardise the xpath

**Tools**
1. IDE = Eclipse for JAVA
2. Pluggins - Chropath and POM Builder for Xpaths identification on MS Edge
3. GitHub Desktop for cloning repo and upploading back into repo

**Assumptions**
1. Used MS Edge as the default browser.

**Current Implementation**
1. Two separate classes within the same package - one for postive and other for negative tests.

**Improvements and Learnings**
While working through and getting the picture together realised follwoing were missing -
1. Robust framework to avoid any hardcoding of data values in the methods. 
2. True Junit framework by asserting in Src/Test and defining methods in Src/Main.
3. Multiple @Test Annotation for each action specified sepeartely as a method rather than one big method.
4. Could not get the JAVA executable created with JUnit test framework. Reason - Executable required a main(), the integration of which with JUnit I am still learning.
