package seleniumeasy.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import seleniumeasy.pageobjects.FormPageConstants;

public class NavigateActions extends UIInteractionSteps {

    @Step
    public void to(FormPageConstants formPageConstants) {
        openPageNamed(formPageConstants.name());
    }

    @Step
    public void toSingleInputForm() {
        openPageNamed("SingleInputFieldForm");
    }

    @Step
    public void toMultipleInputForm() {
        openPageNamed("MultipleInputForm");
    }

    @Step
    public void toCheckboxForm() {
        openPageNamed("CheckboxForm");
    }
}
