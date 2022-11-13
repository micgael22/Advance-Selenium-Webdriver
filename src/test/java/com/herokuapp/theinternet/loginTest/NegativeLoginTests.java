package com.herokuapp.theinternet.loginTest;

import com.herokuapp.theInternet.base.TestUtilities;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class NegativeLoginTests extends TestUtilities {


	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 1)
	public void negativeTest(String username, String password, String expectedErrorMessage) {
		System.out.println("Starting negativeTest ---------------------------------->");

		// open main page
		String url = "http://the-internet.herokuapp.com/";
		driver.get(url);
		System.out.println("Main page is opened.");

		// Click on Form Authentication link
		driver.findElement(By.linkText("Form Authentication")).click();

		// enter username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);

		// push log in button
		driver.findElement(By.className("radius")).click();

		// Verification
		String actualErrorMessage = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);

		System.out.println("END NEGATIVE TEST ---------------------------------->");
	}
}
