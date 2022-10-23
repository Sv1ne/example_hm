package com.sv1ne.pages;

import com.codeborne.selenide.SelenideElement;
import com.sv1ne.components.CalendarComponent;
import com.sv1ne.components.FileUploadComponent;
import com.sv1ne.components.ResultModal;

import java.util.Arrays;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    FileUploadComponent fileUploadComponent = new FileUploadComponent();
    ResultModal resultModal = new ResultModal();

    SelenideElement
            firstnameElement = $("#firstName"),
            lastnameElement = $("#lastName"),
            emailElement = $("#userEmail"),
            genderElement = $("#genterWrapper"),
            userNumberElement = $("#userNumber");

    private String name;
    private String userNumber;
    private String gender;
    private String lastName;
    private String email;
    private String day;
    private String month;
    private String year;
    private String subject;
    private String adress;
    private String hobbies;
    private String fileName;
    private String state;

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String city;

    public String getHobbies() {
        return hobbies;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getSubject() {
        return subject;
    }

    public String getAdress() {
        return adress;
    }

    public RegistrationFormPage openPage() {
        open(baseUrl);
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        this.name = value;
        firstnameElement.setValue(value);
        return this;
    }

    public void checkResult(String key, String value) {
        resultModal.checkValue(key, value);
    }

    public RegistrationFormPage setLastName(String value) {
        this.lastName = value;
        lastnameElement.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        this.email = value;
        emailElement.setValue(value);
        return this;
    }

    public RegistrationFormPage setGender(String value) {
        this.gender = value;
        genderElement.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        this.userNumber = value;
        userNumberElement.setValue(value);
        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public String getFileName() {
        return fileName;
    }

    public RegistrationFormPage uploadPicture(String fileName){
        this.fileName = fileName;
        fileUploadComponent.uploadFile("#uploadPicture", fileName);
        return this;
    }

    public RegistrationFormPage selectHobbies(String... hobbies) {
        String tmp = Arrays.toString(hobbies);
        this.hobbies = tmp.substring(1,tmp.length()-1);
        for (String hobby : hobbies) {
            $("#hobbiesWrapper").$(byText(hobby)).click();
        }
        return this;
    }
    public RegistrationFormPage selectSubject(String subject){
        this.subject = subject;
        $("#subjectsInput").setValue(subject).pressEnter();
        return this;
    }
    public RegistrationFormPage selectAdress(String adress){
        this.adress = adress;
        $("#currentAddress").setValue(adress);
        return this;
    }
    public RegistrationFormPage selectStateAndCity(String state, String city){
        this.state = state;
        this.city = city;
        $("#state").scrollIntoView(true);
        $("#state").click();
        $("#state").$(byText(state)).click();
        $("#city").click();
        $("#city").$(byText(city)).click();
        return this;
    }

    public RegistrationFormPage clickSubmit(){
        $("#submit").click();
        return this;
    }
}