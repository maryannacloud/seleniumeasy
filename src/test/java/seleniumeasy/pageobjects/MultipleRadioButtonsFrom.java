package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://demo.seleniumeasy.com/basic-checkbox-demo.html")
public class MultipleRadioButtonsFrom extends SeleniumEasyForm {

    public void selectGender(String value) {
        inRadioButtonGroup("gender").selectByValue(value);
    }

    public void selectAgeGroup(String value) {
        inRadioButtonGroup("ageGroup").selectByValue(value);
    }

    public void getValues() {
        $(FormButton.withLabel("Get values")).click();
    }


    public String getResult() {
        return $(".groupradiobutton").getText();
    }

}
