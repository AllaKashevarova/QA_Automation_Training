package com.coherent.task30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Locators {

    public WebDriver driver;
    By logInButtonMain = By.xpath("//div[@class='ActionButtons_1KQUh4y2uqGFcS5C_M9sDV']/a[contains(@class,'Button2_view_default')]");
    By userName = By.id("passp-field-login");
    By logInButton = By.id("passp:sign-in");
    By passwordField = By.id("passp-field-passwd");
    By logInButton2 = By.id("passp:sign-in");
    By UserImage = By.xpath("//img[@class='user-pic__image']");
    By userNickName = By.cssSelector("#js-apps-container .user-account__name");
    //below ones are not used in code but have been created in testing purpose:
    By linkText = By.linkText("Light version");
    By variable = By.partialLinkText("Yandex");
    By tagName = By.tagName("span");
}
