package com.ui.automation.web;

import com.ui.automation.BaseTest;
import com.ui.automation.pageobjects.GoogleMailLoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.open;

public class TestGmailLogin extends BaseTest {

    GoogleMailLoginPage googleMailLoginPage;

    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        super.beforeClass();
        googleMailLoginPage = open(GoogleMailLoginPage.getPageURL(), GoogleMailLoginPage.class);
    }

    @Features("Gmail functionality")
    @Stories({"Verify Gmail login"})
    @Test(description = "TC-001")
    public void testLogin() {
        googleMailLoginPage
                .loginAsExistingUser()
                .verifyInboxDisplayed();
    }
}