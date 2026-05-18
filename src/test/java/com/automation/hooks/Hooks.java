package com.automation.hooks;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.automation.testcontext.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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
		}
		else if(context.browser.equalsIgnoreCase("firefox")) {
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
// // Getter for context if needed
//    public static TestContextSetup getContext() {
//        return context;
//    }
}
