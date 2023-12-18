package Logic;

import Infrastructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Logic.Enums.conditionEnum;
import org.openqa.selenium.WebElement;

public class Condition extends BasePage {
    private final By newConditionID = By.id("s0-1-17-6[4]-[0]-LH_ItemCondition");
    private final By usedConditionID = By.id("s0-1-17-6[4]-[1]-LH_ItemCondition");
    private final By notSpecifiedConditionID = By.id("s0-1-17-6[4]-[2]-LH_ItemCondition");
    public Condition(WebDriver driver) {
        super(driver);
    }
    public void chooseCondition(conditionEnum condition) {
        switch (condition) {
            case NEW:
                clickConditionRadio(newConditionID);
                break;
            case USED:
                clickConditionRadio(usedConditionID);
                break;
            case NOT_SPECIFIED:
                clickConditionRadio(notSpecifiedConditionID);
                break;
            default:
                throw new IllegalArgumentException("Invalid condition: " + condition);
        }
    }

    private void clickConditionRadio(By conditionRadio) {
        WebElement conditionRadioElement = driver.findElement(conditionRadio);
        if (!conditionRadioElement.isSelected()) {
            conditionRadioElement.click();
        }
    }
}
