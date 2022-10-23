package com.sv1ne.tests;

import com.codeborne.selenide.Configuration;
import com.sv1ne.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Configuration.holdBrowserOpen;


public class SearchTests {

    @BeforeAll
    static void setUp() {
        holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com/automation-practice-form";
    }

    @Test
    void testForm() {

        RegistrationFormPage registrationFormPage = new RegistrationFormPage().openPage()
                .setFirstName("Alex")
                .setLastName("Gordon")
                .setUserEmail("name@gmail.com")
                .setGender("Male")
                .setNumber("0123456789")
                .setBirthDate("31", "August", "1990")
                .selectHobbies("Sports", "Reading")
                .selectSubject("Maths")
                .selectAdress("Bunina 12")
                .uploadPicture( "Screenshot_4.png")
                .selectStateAndCity("NCR", "Delhi")
                .clickSubmit();

        registrationFormPage.checkResult("Student Name", String.format("%s %s", registrationFormPage.getName(), registrationFormPage.getLastName()));
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