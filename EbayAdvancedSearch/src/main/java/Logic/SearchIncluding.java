package Logic;

import Infrastructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchIncluding extends BasePage {
    private final By titleDescCheckbox = By.id("s0-1-17-5[1]-[0]-LH_TitleDesc");
    private final By completeCheckbox = By.id("s0-1-17-5[1]-[1]-LH_Complete");
    private final By soldCheckbox = By.id("s0-1-17-5[1]-[2]-LH_Sold");
    public SearchIncluding(WebDriver driver) {
        super(driver);
    }
    public void selectCheckBoxes(boolean titleAndDescription, boolean completedItems, boolean soldItems){
        if (titleAndDescription) {
            clickCheckbox(titleDescCheckbox);
        } if (completedItems) {
            clickCheckbox(completeCheckbox);
        } if (soldItems) {
            clickCheckbox(soldCheckbox);
        }
    }
    private void clickCheckbox(By checkboxLocator) {
        WebElement checkbox = driver.findElement(checkboxLocator);
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

}
