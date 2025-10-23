package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://demo.seleniumeasy.com/basic-checkbox-demo.html")

public class RadioButtonsForm extends SeleniumEasyForm{


    public String getResult() {
        return $(".radiobutton").getText();
    }

    public void selectOption(String value) {
        inRadioButtonGroup("optradio").selectByValue(value);
    }

    public void getCheckedValue() {
        $("#buttoncheck").click();
    }
}
