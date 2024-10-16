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

    @FindBy(xpath = "//span[text()='2']")
    public WebElement secondPageTwoNumberBlue;

    @FindBy(xpath = "//p[text()='Choose a payment plan']")
    public WebElement choosePaymentPlan;

    @FindBy(xpath = "(//span[@class='payment-type'])[1]")
    public WebElement upfrontAccordion;

    @FindBy(xpath = "(//span[text()='Base price'])[1]")
    public WebElement upfrontBasePrice;

    @FindBy(xpath = "(//span[@class='price'])[1]")
    public WebElement upfrontBaseAmount;

    @FindBy(xpath = "//span[text()='Upfront discount']")
    public WebElement upfrontDiscount;

    @FindBy(xpath = "(//span[@class='price'])[2]")
    public WebElement upfrontDiscountAmount;

    @FindBy(xpath = "//span[text()='Subtotal']")
    public WebElement subtotalUpfront;

    @FindBy(xpath = "(//span[@class='price'])[3]")
    public WebElement subtotalUpfrontAmount;

    @FindBy(xpath = "(//i[@class='excluding-fee'])[1]")
    public WebElement excludingFeesUpfront;

    @FindBy(xpath = "(//span[@class='payment-type'])[2]")
    public WebElement installmentsAccordion;

    @FindBy(xpath = "(//span[text()='Base price'])[2]")
    public WebElement installmentBasePrice;

    @FindBy(xpath = "(//span[@class='price'])[3]")
    public WebElement installmentBaseAmount;

    @FindBy(xpath = "//span[text()='Installments']")
    public WebElement installmentsPlan;

    @FindBy(xpath = "(//span[@class='price'])[4]")
    public WebElement installmentsNumber;

    @FindBy(xpath = "//span[text()='Price per installment']")
    public WebElement pricePerInstallment;

    @FindBy(xpath = "(//span[@class='price'])[5]")
    public WebElement amountPerInstallment;

    @FindBy(xpath = "//span[@class='sub-item-panel ng-star-inserted']")
    public WebElement dueToday;

    @FindBy(xpath = "//div[@class='fee-items-holder']/span[contains(text(), 'First month')]")
    public WebElement firstMonthsPay;

    @FindBy(xpath = "(//span[@class='price'])[6]")
    public WebElement firstMonthsAmount;

    @FindBy(xpath = "(//i[@class='excluding-fee'])[1]")
    public WebElement excludingFeesInstallmentsPlan;




}
