package com.sv1ne.components;

import static com.codeborne.selenide.Selenide.$;

public class FileUploadComponent {

    public void uploadFile(String cssElement, String fileName) {
        $(cssElement).uploadFromClasspath(fileName);
    }
}
