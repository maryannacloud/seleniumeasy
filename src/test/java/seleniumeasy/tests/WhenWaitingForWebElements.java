package seleniumeasy.tests;

import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.ModalDialogPage;

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

    @Test
    public void waitingForMessageToClose() {

    }

    @Test
    public void waitingForElementsToAppear() {

    }

    @Test
    public void waitingForElementsToDisappear() {

    }

}
