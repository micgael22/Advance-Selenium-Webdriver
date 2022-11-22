package com.herokuapp.theinternet.alertsTests;

import com.herokuapp.theInternet.base.TestUtilities;
import com.herokuapp.theInternet.pages.JavaScriptAlertsPage;
import com.herokuapp.theInternet.pages.WelcomePageObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertsTests extends TestUtilities {

    @Test
    public void jsAlertTest() throws InterruptedException {
        log.info("Starting jsAlertTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Alert button
        alertsPage.openJSAlert();
        sleep(1000);

        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Click OK button
        alertsPage.acceptAlert();

        // Get Results text
        String result = alertsPage.getResultText();
        sleep(1000);

        //Verifications
        //1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS Alert"),
                "Alert message is not expected. \nShould be 'I am a JS Alert', but it is '" + alertMessage + "'");

        //2 - Result text is expected
        Assert.assertTrue(result.equals("You successfuly clicked an alert"),
                "result is not expected. \nShould be 'You successfuly clicked an alert', but it is '" + result + "'");
    }

    @Test
    public void jsDismissTest() throws InterruptedException{
        log.info("Starting jsDismissTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Confirm button
        alertsPage.openJSConfirm();
        sleep(1000);

        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Click Cancel button
        alertsPage.dismissAlert();

        // Get Results text
        String result = alertsPage.getResultText();
        sleep(1000);

        // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS Confirm"),
                "Alert message is not expected. \nShould be 'I am a JS Confirm', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        Assert.assertTrue(result.equals("You clicked: Cancel"),
                "result is not expected. \nShould be 'You clicked: Cancel', but it is '" + result + "'");
    }

    @Test
    public void jsPromptTest() throws InterruptedException {
        log.info("Starting jsDismissTest");

        // open main page
        WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
        welcomePage.openPage();

        // Click on JavaScript Alerts link
        JavaScriptAlertsPage alertsPage = welcomePage.clickJavaScriptAlertsLink();

        // Click JS Prompt button
        alertsPage.openJSPrompt();
        sleep(1000);

        // Get alert text
        String alertMessage = alertsPage.getAlertText();

        // Type text into alert
        alertsPage.typeTextIntoAlert("Hello Alert, it's Micgael here");
        sleep(1000);
        // Get Results text
        String result = alertsPage.getResultText();
        sleep(1000);

        // Verifications
        // 1 - Alert text is expected
        Assert.assertTrue(alertMessage.equals("I am a JS prompt"),
                "Alert message is not expected. \nShould be 'I am a JS prompt', but it is '" + alertMessage + "'");

        // 2 - Result text is expected
        Assert.assertTrue(result.equals("You entered: Hello Alert, it's Micgael here"),
                "result is not expected. \nShould be 'You entered: Hello Alert, its Dmitry here', but it is '" + result
                        + "'");
    }
}
