package com.sv1ne.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import com.sv1ne.pages.RegistrationFormPage;
import com.sv1ne.utils.Month;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.holdBrowserOpen;
import static com.codeborne.selenide.Selenide.*;


public class SearchTests extends RegistrationFormPage {
    Faker faker = new Faker();

    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String userEmail = faker.internet().safeEmailAddress();
    String gender = faker.demographic().sex();
    String phoneNumber = String.valueOf(faker.phoneNumber().subscriberNumber(10));
    String day = String.valueOf(faker.number().numberBetween(1, 31));
    String month = String.valueOf(Month.getRandomMonth());
    String year = String.valueOf(faker.number().numberBetween(1990, 2022));
    String adress = String.valueOf(faker.address().fullAddress());

    @BeforeAll
    static void setUp() {
        holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    void testForm() {
        RegistrationFormPage registrationFormPage = new RegistrationFormPage().openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setNumber(phoneNumber)
//                .setBirthDate("31", "August", "1990")
                .setBirthDate(day, month, year)
                .selectHobbies("Sports", "Reading","Music")
                .selectSubject("Maths")
                .selectAdress(adress)
                .uploadPicture( "Screenshot_4.png")
                .selectStateAndCity("NCR", "Delhi")
                .clickSubmit();
        registrationFormPage.checkResult("Student Name", String.format("%s %s", registrationFormPage.getFirstName(), registrationFormPage.getLastName()));
        registrationFormPage.checkResult("Student Email", String.format("%s", registrationFormPage.getEmail()));
        registrationFormPage.checkResult("Gender", String.format("%s", registrationFormPage.getGender()));
        registrationFormPage.checkResult("Mobile", String.format("%s", registrationFormPage.getUserNumber()));
        registrationFormPage.checkResult("Date of Birth", String.format("%s %s,%s", registrationFormPage.getDay(), registrationFormPage.getMonth(), registrationFormPage.getYear()));
        registrationFormPage.checkResult("Subjects", String.format("%s", registrationFormPage.getSubject()));
        registrationFormPage.checkResult("Hobbies", String.format("%s", registrationFormPage.getHobbies()));
        registrationFormPage.checkResult("Picture", String.format("%s", registrationFormPage.getFileName()));
        registrationFormPage.checkResult("Address", String.format("%s", registrationFormPage.getAdress()));
        registrationFormPage.checkResult("State and City", String.format("%s %s", registrationFormPage.getState(), registrationFormPage.getCity()));

    }
}