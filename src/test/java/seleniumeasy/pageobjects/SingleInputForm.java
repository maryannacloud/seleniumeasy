package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.seleniumeasy.com/test/basic-first-form-demo.html")
public class SingleInputForm extends SeleniumEasyForm{
    public void enterMessage(String message) {
        $("#user-message").type(message);
    }

    public void showMessage(){
        $(FormButton.withLabel("Show Message")).click();
    }

    public String displayedMessage() {
        return $("#display").getText();
    }
}
