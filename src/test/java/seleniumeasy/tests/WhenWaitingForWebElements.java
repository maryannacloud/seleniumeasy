package seleniumeasy.tests;

import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.AlertMessagePage;
import seleniumeasy.pageobjects.DynamicDataPage;
import seleniumeasy.pageobjects.ModalDialogPage;

import static org.assertj.core.api.Assertions.assertThat;

public class WhenWaitingForWebElements {

    @Managed(driver = "chrome")
    WebDriver driver;

    ModalDialogPage modalDialogPage;

    @Test
    public void waitingForModalDialog() {
        modalDialogPage.open();

        modalDialogPage.saveChangesButton().shouldNotBeVisible();
        modalDialogPage.openModalDialog();
        modalDialogPage.saveChangesButton().shouldBeVisible();
        modalDialogPage.saveChanges();
        modalDialogPage.saveChangesButton().shouldNotBeVisible();
    }

    AlertMessagePage alertMessagePage;

    @Test
    public void waitingForMessageToClose() {
        alertMessagePage.open();
        alertMessagePage.openSuccessMessage();
        assertThat(alertMessagePage.alertSuccessMessageText()).contains("I'm an autocloseable success message.");
        alertMessagePage.waitForMessageToDisappear();
        alertMessagePage.alertSuccessMessage().shouldNotBeVisible();
    }

    DynamicDataPage dynamicDataPage;

    @Test
    public void waitingForElementsToAppear() {
        dynamicDataPage.open();
        dynamicDataPage.getNewUser();
        assertThat(dynamicDataPage.userDescription()).contains("First Name").contains("Last Name");
    }

    @Test
    public void waitingForElementsToDisappear() {

    }

}
