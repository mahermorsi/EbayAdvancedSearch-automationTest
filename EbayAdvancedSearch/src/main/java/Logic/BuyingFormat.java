package Logic;

import Infrastructure.BasePage;
import Logic.Enums.Format;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BuyingFormat extends BasePage {
    private final By acceptOfferID = By.id("s0-1-17-6[3]-[0]-LH_BO");
    private final By auctionID = By.id("s0-1-17-6[3]-[1]-LH_Auction");
    private final By buyitNowID = By.id("s0-1-17-6[3]-[2]-LH_BIN");
    private final By classifiedAdsID = By.id("s0-1-17-6[3]-[3]-LH_CAds");
    public BuyingFormat(WebDriver driver) {
        super(driver);
    }

    public void selectBuyingFormat(Format format) {
        WebElement radioElement = getRadioElement(format);
        if (!radioElement.isSelected()) {
            radioElement.click();
        }
    }
    private WebElement getRadioElement(Format format) {
        switch (format) {
            case ACCEPTS_OFFERS -> {
                return driver.findElement(acceptOfferID);
            }
            case AUCTION -> {
                return driver.findElement(auctionID);
            }
            case BUY_IT_NOW -> {
                return driver.findElement(buyitNowID);
            }
            case CLASSIFIED_ADS -> {
                return driver.findElement(classifiedAdsID);
            }
            default -> throw new IllegalArgumentException("Invalid Format: " + format);
        }
    }
}
