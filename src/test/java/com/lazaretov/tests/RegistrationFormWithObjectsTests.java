package com.lazaretov.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.lazaretov.helpers.Attach;
import com.lazaretov.pages.RegistrationFormPage;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.lazaretov.testData.UserInfo.*;
import static io.qameta.allure.Allure.step;

public class RegistrationFormWithObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("browserName", "chrome");
//        capabilities.setCapability("browserVersion", "100.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//          Configuration.holdBrowserOpen = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    @Test
    @Feature("Форма регистрации")
    @Story("Заполнение всех полей")
    @Owner("lazaretov")
    @Severity(SeverityLevel.NORMAL)
    @Link(value = "Testing site", url = "https://demoqa.com")
    @DisplayName("Проверка полей формы регистрации")
    void fillFormTest() {
        step("Open and fill form", () -> {
            registrationFormPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setPhone(phone)
                    .setDateOfBirth(day, month, year)
                    .setSubjects(subject)
                    .setHobbies(hobby)
                    .uploadPic(pic)
                    .setAddress(address, state, city)
                    .clickSubmit();
        });
        step("Check results", () -> {
            registrationFormPage.checkResultsTableVisible()
                    .checkResult("Student Name", firstName + " " + lastName)
                    .checkResult("Student Email", email)
                    .checkResult("Gender", gender)
                    .checkResult("Mobile", phone)
                    .checkResult("Date of Birth", date)
                    .checkResult("Subjects", subject)
                    .checkResult("Hobbies", hobby)
                    .checkResult("Picture", pic)
                    .checkResult("Address", address)
                    .checkResult("State and City", state + " " + city);
        });
    }
}
