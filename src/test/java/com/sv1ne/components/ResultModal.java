package com.sv1ne.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {
    public void checkValue(String key, String value){
        $(".table-responsive table").$(byText(key)).parent().shouldHave(text(value));
    }
}
