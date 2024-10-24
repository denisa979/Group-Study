package com.group.step_definition;

import com.group.pages.DetailedPriceSummaryPage;


import com.group.pojos.program.Product;
import com.group.utilities.BrowserUtils;
import com.group.utilities.DriverUtils;
import com.group.utilities.QaDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;


public class PriceSummaryStepDefinition {

    DetailedPriceSummaryPage detailedPriceSummaryPage = new DetailedPriceSummaryPage();

    String globalProgramCode;
    @Given("the user is on the enrollment page {string}")
    public void the_user_is_on_the_enrollment_page(String programCode) {

        globalProgramCode = programCode;
        BrowserUtils.waitFor(2);
        detailedPriceSummaryPage.logIn(programCode);
    }

    @When("the user completes step one with valid information {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserCompletesStepOneWithValidInformation
            (String firstName, String lastName, String emailAddress, String phone, String howDidYouHearAboutUs, String parentFirstName, String parentLastName, String parentEmailAddress, String parentPhone) {

        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.firstName, 10);
        detailedPriceSummaryPage.firstName.clear();
        detailedPriceSummaryPage.firstName.sendKeys(firstName);

        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.lastName, 10);
        detailedPriceSummaryPage.lastName.clear();
        detailedPriceSummaryPage.lastName.sendKeys(lastName);

        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.emailAddress, 10);
        detailedPriceSummaryPage.emailAddress.clear();
        detailedPriceSummaryPage.emailAddress.sendKeys(emailAddress);

        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.phone, 10);
        detailedPriceSummaryPage.phone.clear();
        detailedPriceSummaryPage.phone.sendKeys(phone);

        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.howDidYouHearAboutUs, 10);
        BrowserUtils.scrollToElement(detailedPriceSummaryPage.howDidYouHearAboutUs);

        BrowserUtils.waitFor(1);
        detailedPriceSummaryPage.howDidYouHearAboutUs.click();

        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.googleDropDown, 10);
        if (howDidYouHearAboutUs.equals("LinkedIN") || howDidYouHearAboutUs.equals("Twitter") || howDidYouHearAboutUs.equals("Referred by a friend or colleague") || howDidYouHearAboutUs.equals("Other")) {
            BrowserUtils.scrollToElement(detailedPriceSummaryPage.otherDropDown);
        }
        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.otherDropDown, 10);
        detailedPriceSummaryPage.chooseOptionFromDropDown(howDidYouHearAboutUs).click();

        if (DriverUtils.getDriver().getCurrentUrl().contains("jfft")) {

            BrowserUtils.waitForVisibility(detailedPriceSummaryPage.parentFirstName, 10);
            detailedPriceSummaryPage.parentFirstName.sendKeys(parentFirstName);

            BrowserUtils.waitForVisibility(detailedPriceSummaryPage.parentLastName, 20);
            detailedPriceSummaryPage.parentLastName.sendKeys(parentLastName);

            BrowserUtils.waitForVisibility(detailedPriceSummaryPage.parentEmailAddress, 20);
            detailedPriceSummaryPage.parentEmailAddress.sendKeys(parentEmailAddress);

            BrowserUtils.waitForVisibility(detailedPriceSummaryPage.parentPhone, 20);
            detailedPriceSummaryPage.parentPhone.sendKeys(parentPhone);
        }
        BrowserUtils.scrollToElement(detailedPriceSummaryPage.nextButton);
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForClickablility(detailedPriceSummaryPage.nextButton, 20);
        assert detailedPriceSummaryPage.nextButton.isEnabled();
        detailedPriceSummaryPage.nextButton.click();
    }

    @Then("the user is on the step two of the enrollment process")
    public void the_user_is_on_the_step_two_of_the_enrollment_process() {
        BrowserUtils.waitFor(1);
        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.upfrontAccordion,20);
        detailedPriceSummaryPage.upfrontAccordion.click();

    }

    @When("the user clicks on any accordion")
    public void the_user_clicks_on_any_accordion() {

        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.installmentsAccordion,20);
        detailedPriceSummaryPage.installmentsAccordion.click();
    }

    @Then("the accordion should expand to open the price details")
    public void the_accordion_should_expand_to_open_the_price_details() {
        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.upfrontAccordion,20);
        Assert.assertTrue(detailedPriceSummaryPage.upfrontAccordion.isDisplayed());
        System.out.println("detailedPriceSummaryPage = " + detailedPriceSummaryPage.upfrontAccordion.isDisplayed());


        BrowserUtils.waitForVisibility(detailedPriceSummaryPage.installmentsAccordion, 20);
        Assert.assertTrue(detailedPriceSummaryPage.installmentsAccordion.isDisplayed());
        System.out.println("detailedPriceSummaryPage = " + detailedPriceSummaryPage.installmentsAccordion.isDisplayed());
    }

    @And("price details for each price type follow the data provided")
    public void priceDetailsForEachPriceTypeFollowTheDataProvided() {

            Product currentProduct = QaDataReader.getSingleProduct(globalProgramCode);
            List<Product.Price> allPrices = currentProduct.getPrices();

            BrowserUtils.waitFor(2);

            for (Product.Price price : allPrices) {
                if (price.getType().equals("one-time")) {

                    int baseAmount = detailedPriceSummaryPage.getUpfrontBasePrice();

                    System.out.println("price.getBaseAmount() = " + price.getBaseAmount());
                    System.out.println("baseAmount = " + baseAmount);
                    Assert.assertEquals(price.getBaseAmount(), baseAmount);

                    if (price.getType().equals("recurring")){

                        int installmentBaseAmount = detailedPriceSummaryPage.getInstallmentBaseAmount();
                        int numberOfInstallments = detailedPriceSummaryPage.getNumberOfInstalments();

                        System.out.println("installmentBaseAmount = " + installmentBaseAmount);
                        System.out.println("price.getNumberOfInstallments() = " + price.getNumberOfInstallments());
                        System.out.println("numberOfInstallments = " + numberOfInstallments);
                        Assert.assertEquals(price.getNumberOfInstallments(), numberOfInstallments);
                    }
            }
        }


    }
    @Then("each price summary must say {string} at the end")
    public void each_price_summary_must_say_at_the_end(String expectedText) {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(detailedPriceSummaryPage.excludingFeesUpfront.getText().endsWith(expectedText));
        System.out.println("expectedText = " + expectedText);

        BrowserUtils.waitFor(1);
        Assert.assertTrue(detailedPriceSummaryPage.excludingFeesInstallmentsPlan.getText().endsWith(expectedText));
        System.out.println("expectedText = " + expectedText);
    }


}

