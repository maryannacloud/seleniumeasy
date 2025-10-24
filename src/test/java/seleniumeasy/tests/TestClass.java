package seleniumeasy.tests;

import net.thucydides.core.annotations.Managed;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.*;

import java.util.List;

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

    private static final List<String> ALL_THE_OPTIONS = List.of("Option 1", "Option 2", "Option 3", "Option 4");

    @Test
    public void multipleCheckbox() {
        checkboxForm.open();

        assertThat(ALL_THE_OPTIONS).allMatch(option -> !checkboxForm.optionIsCheckedFor(option));
        checkboxForm.clickCheckAllButton();
        assertThat(ALL_THE_OPTIONS).allMatch(option -> checkboxForm.optionIsCheckedFor(option));
    }

    RadioButtonsForm radioButtonsForm;

    @Test
    public void radioButtons() {
        radioButtonsForm.open();

        radioButtonsForm.selectOption("Male");
        radioButtonsForm.getCheckedValue();
        assertThat(radioButtonsForm.getResult()).isEqualTo("Radio button 'Male' is checked");
    }

    MultipleRadioButtonsFrom multipleRadioButtonsForm;

    @Test
    public void multipleRadioButtons() {
        multipleRadioButtonsForm.open();

        multipleRadioButtonsForm.selectGender("Female");
        multipleRadioButtonsForm.selectAgeGroup("15 - 50");
        multipleRadioButtonsForm.getValues();

        assertThat(multipleRadioButtonsForm.getResult()).contains("Sex : Female").contains("Age group: 15 - 50");
    }

    SingleSelectDropdownFrom singleSelectDropdownForm;

    @Test
    public void singleSelectDropdown() {
        singleSelectDropdownForm.open();

        assertThat(singleSelectDropdownForm.selectedDay()).isEmpty();
        singleSelectDropdownForm.selectDay("Wednesday");
        assertThat(singleSelectDropdownForm.selectedDay()).isEqualTo("Wednesday");
    }

    MultiSelectDropdownForm multiSelectDropdownForm;

    @Test
    public void multiSelectDropdown() {
        multiSelectDropdownForm.open();

        assertThat(multiSelectDropdownForm.selectedStates()).isEmpty();
        multiSelectDropdownForm.selectStates("FL", "VA", "NY");
        assertThat(multiSelectDropdownForm.selectedStates()).containsExactlyInAnyOrder("Florida", "Virginia", "New York");
    }

    HoverPage hoverPage;

    @Test
    public void hover() {
        hoverPage.open();

        hoverPage.hoverOverFigure(1);
        hoverPage.captionForFigure(1).shouldBeVisible();
        hoverPage.captionForFigure(1).shouldContainText("user2");

        hoverPage.hoverOverFigure(2);
        hoverPage.captionForFigure(2).shouldBeVisible();
        hoverPage.captionForFigure(2).shouldContainText("user2");
    }
}
