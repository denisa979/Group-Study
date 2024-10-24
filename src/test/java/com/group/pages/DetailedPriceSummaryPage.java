package com.group.pages;

import com.group.utilities.DriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class DetailedPriceSummaryPage extends BasePage{

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    public WebElement lastName;


    @FindBy(xpath = "//input[@formcontrolname='email']")
    public WebElement emailAddress;

    @FindBy(xpath = "//input[@formcontrolname='phoneNumber']")
    public WebElement phone;

    @FindBy(xpath = "//mat-label[text()='How did you hear about us?']")
    public WebElement howDidYouHearAboutUs;

    @FindBy(xpath = "//*[text()='Email']")
    public WebElement emailDropDown;

    @FindBy(xpath = "//*[text()='Facebook']")
    public WebElement facebookDropDown;

    @FindBy(xpath = "//*[text()='Google']")
    public WebElement googleDropDown;

    @FindBy(xpath = "//*[text()='Instagram']")
    public WebElement instagramDropDown;

    @FindBy(xpath = "//*[text()='LinkedIN']")
    public WebElement linkedInDropDown;

    @FindBy(xpath = "//*[text()='Twitter']")
    public WebElement twitterDropDown;

    @FindBy(xpath = "//*[text()='Referred by a friend or colleague']")
    public WebElement referredByFriendOrColleagueDropDown;

    @FindBy(xpath = "//*[text()='Other']")
    public WebElement otherDropDown;

    public WebElement chooseOptionFromDropDown(String optionName){
        WebElement webElement = DriverUtils.getDriver().findElement(By.xpath("//mat-option/span[contains(text(), '"+optionName+"')]"));
        return webElement;
    }

    @FindBy(xpath = "//button[@class='next-button']")
    public WebElement nextButton;

    @FindBy(css = "input#mat-input-4")
    public WebElement parentFirstName;

    @FindBy(css = "input#mat-input-5")
    public WebElement parentLastName;

    @FindBy(css = "input#mat-input-6")
    public WebElement parentEmailAddress;

    @FindBy(css = "input#mat-input-7")
    public WebElement parentPhone;

    @FindBy(xpath = "//p[text()='Choose a payment plan']")
    public WebElement choosePaymentPlan;

    @FindBy(xpath = "//span[@class='payment-type']")
    public WebElement upfrontAccordion;

    @FindBy(xpath = "(//span[@class='price'])[1]")
    public WebElement upfrontBasePrice;

    @FindBy(xpath = "//span[@class='discount-price']")
    public WebElement upfrontDiscountTotalPrice;

    @FindBy(xpath = "(//span[@class='price'])[2]")
    public WebElement upfrontDiscount;

    @FindBy(xpath = "//i[text()='excluding fees']")
    public WebElement excludingFeesUpfront;



    @FindBy(xpath = "//span[@class='mat-content ng-tns-c1676997785-9 mat-content-hide-toggle']")
    public WebElement installmentBox;

    @FindBy(xpath = "(//span[@class='payment-type'])[2]")
    public WebElement installmentsAccordion;

    @FindBy(xpath = "//div[@class='content-panel-item ng-star-inserted']/span[contains(text(), 'Installments')]/following-sibling::span")
    public WebElement installmentsNumber;

    @FindBy(xpath = "(//span[@class='price'])[1]")
    public WebElement installmentBaseAmount;

    @FindBy(xpath = "(//i[@class='excluding-fee'])[1]")
    public WebElement excludingFeesInstallmentsPlan;

    public int getUpfrontBasePrice(){
        String value = upfrontBasePrice.getText();
        return Integer.parseInt(value);
    }

    public int getInstallmentBaseAmount() {
        String value = installmentBaseAmount.getText();
        return Integer.parseInt(value);

    }
    public int getNumberOfInstalments() {
        String value = installmentsNumber.getText();
        return Integer.parseInt(value);
    }
}
