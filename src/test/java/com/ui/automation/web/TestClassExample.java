package com.ui.automation.web;

import com.ui.automation.BaseTest;
import com.ui.automation.environment.EnvironmentConfigurator;
import com.ui.automation.pageobjects.SimpleGoogleTestPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.open;

public class TestClassExample extends BaseTest {

    SimpleGoogleTestPage simpleGoogleTestPage;

    @Override
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println(EnvironmentConfigurator.getInstance().getBrowserClient());
        System.out.println(EnvironmentConfigurator.getInstance().getLocalization());
        System.out.println(EnvironmentConfigurator.getInstance().getAppUrl());
        System.out.println(EnvironmentConfigurator.getInstance().getLogin());
        System.out.println(EnvironmentConfigurator.getInstance().getPassword());
        System.out.println(EnvironmentConfigurator.getInstance().getSeleniumHub());
        System.out.println(EnvironmentConfigurator.getInstance().isGridUsed());


        super.beforeClass();
        simpleGoogleTestPage = open(SimpleGoogleTestPage.getPageURL(), SimpleGoogleTestPage.class);
    }

    @Features("Search functionality")
    @Stories({"Google search"})
    @Test(groups = {"smoke"}, description = "TC-01")
    public void testSearch() {
        simpleGoogleTestPage
                .searchFor("Random")
                .verifyPageTitle();
    }
}