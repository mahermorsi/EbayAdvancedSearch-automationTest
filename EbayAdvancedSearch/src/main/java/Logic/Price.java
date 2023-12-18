package Logic;

import Infrastructure.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class Price extends BasePage{
    private final By minPriceInput = By.id("s0-1-17-5[2]-@range-comp[]-@range-textbox[]-textbox");
    private final By maxPriceInput = By.id("s0-1-17-5[2]-@range-comp[]-@range-textbox[]_1-textbox");
    public Price(WebDriver driver) {
        super(driver);
    }
    public void inputMinPrice(double minPrice) {
        WebElement minPriceElement = driver.findElement(minPriceInput);
        minPriceElement.clear();
        minPriceElement.sendKeys(String.valueOf(minPrice));
    }
    public void inputMaxPrice(double maxPrice) {
        WebElement maxPriceElement = driver.findElement(maxPriceInput);
        maxPriceElement.clear();
        maxPriceElement.sendKeys(String.valueOf(maxPrice));
    }
    public void inputMinMaxRangePrice(double minPrice, double maxPrice){
        inputMinPrice(minPrice);
        inputMaxPrice(maxPrice);
    }
}
