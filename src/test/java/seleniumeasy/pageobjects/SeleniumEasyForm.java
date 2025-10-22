package seleniumeasy.pageobjects;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumEasyForm extends PageObject {

    private static final By POPUP_WINDOW_CLOSE_ICON = By.cssSelector("a[title='Close']");

    public void clearPopupWindow() {
        if ($(POPUP_WINDOW_CLOSE_ICON).isPresent()) {
            waitFor(visibilityOfElementLocated(POPUP_WINDOW_CLOSE_ICON)).click();
            waitFor(invisibilityOfElementLocated(POPUP_WINDOW_CLOSE_ICON));
        }
    }
}
