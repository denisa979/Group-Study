package com.group.pages;

import com.group.utilities.DriverUtils;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverUtils.getDriver(), this);
    }


    public void logIn(String programCode){
        String url = "https://" + System.getenv("username") + ":" + System.getenv("password")
                + "@qa.sep.tdtm.cydeo.com/" + programCode;
        DriverUtils.getDriver().get(url);

    }
}
