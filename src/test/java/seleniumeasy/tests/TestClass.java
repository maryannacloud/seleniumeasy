package seleniumeasy.tests;

import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.CheckboxForm;
import seleniumeasy.pageobjects.MultipleInputForm;
import seleniumeasy.pageobjects.SingleInputForm;

import static org.assertj.core.api.Assertions.assertThat;

public class TestClass {

    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;

    SingleInputForm singleInputForm;

    @Test
    public void basicForms() {
        singleInputForm.open();
        singleInputForm.enterMessage("Hello Serenity!");
        assertThat(singleInputForm.displayedMessage()).isEqualTo("Hello Serenity!");
    }

    MultipleInputForm multipleInputFieldsForm;

    @Test
    public void basicFormsWithUniqueFields() {
        multipleInputFieldsForm.open();
        multipleInputFieldsForm.enterValue1("2");
        multipleInputFieldsForm.enterValue2("3");
        multipleInputFieldsForm.getTotal();
        assertThat(multipleInputFieldsForm.displayedTotal()).isEqualTo("5");
    }

    CheckboxForm checkboxForm;

    @Test
    public void singleCheckbox() {
        checkboxForm.open();
        checkboxForm.setAgeSelected();
        assertThat(checkboxForm.ageText()).isEqualTo("Success - Check box is checked");

    }

    @Test
    public void multipleCheckbox() {
        checkboxForm.open();
        assertThat(checkboxForm.optionIsCheckedFor("Option 1")).isFalse();
        assertThat(checkboxForm.optionIsCheckedFor("Option 2")).isFalse();
        assertThat(checkboxForm.optionIsCheckedFor("Option 3")).isFalse();
        assertThat(checkboxForm.optionIsCheckedFor("Option 4")).isFalse();

        checkboxForm.clickCheckAllButton();

        assertThat(checkboxForm.optionIsCheckedFor("Option 1")).isTrue();
        assertThat(checkboxForm.optionIsCheckedFor("Option 2")).isTrue();
        assertThat(checkboxForm.optionIsCheckedFor("Option 3")).isTrue();
        assertThat(checkboxForm.optionIsCheckedFor("Option 4")).isTrue();

    }



}
