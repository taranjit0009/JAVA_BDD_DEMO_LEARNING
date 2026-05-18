package com.automation.hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.testcontext.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	// Instance variable to hold the shared test context
	protected TestContextSetup context;

	// Constructor: Cucumber will inject TestContextSetup here
	public Hooks(TestContextSetup context) {
		this.context = context;
	}

	/**
	 * @Before hook runs before each scenario. - Sets up WebDriverManager for Chrome
	 *         - Creates a new ChromeDriver instance - Maximizes the browser window
	 *         - Navigates to the base URL - Stores the driver in TestContextSetup
	 *         so step definitions can use it
	 */
	@Before
	public void setup() {
		if (context.browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			context.driver = new ChromeDriver();
		} else if (context.browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			context.driver = new FirefoxDriver();
		}
		context.driver.manage().window().maximize();
		context.driver.get(context.URL);

	}

	@Before("@LoginBeforeAll")
	public void LoginSetup() {
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("User is on the Login page.");
		System.out.println("Clickon on login button");
		System.out.println("User us logged in succesfully.");
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	/**
	 * @After hook runs after each scenario. - Quits the browser if it was
	 *        initialized - Ensures cleanup so no driver leaks remain
	 */
	@After
	public void tearDown() {
		if (context.driver != null) {
			context.driver.quit();
			System.out.println("Browser closed after all scenarios.");
		}
	}

	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {

	    if (scenario.isFailed()) {

	        String screenshotName = scenario.getName()
	                .replaceAll(" ", "_");

	        File sourceFile = ((TakesScreenshot) context.driver)
	                .getScreenshotAs(OutputType.FILE);

	        String destinationPath = System.getProperty("user.dir")
	                + "/test-output/ExtentReport/screenshots/"
	                + screenshotName + ".png";

	        File destinationFile = new File(destinationPath);

	        destinationFile.getParentFile().mkdirs();

	        FileUtils.copyFile(sourceFile, destinationFile);

	        byte[] fileContent = FileUtils.readFileToByteArray(destinationFile);

	        scenario.attach(fileContent, "image/png", screenshotName);

	        System.out.println("Screenshot saved at: " + destinationPath);
	    }
	}
// // Getter for context if needed
//    public static TestContextSetup getContext() {
//        return context;
//    }
}
