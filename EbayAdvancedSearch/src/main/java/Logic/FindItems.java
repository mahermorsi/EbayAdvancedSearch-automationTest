package Logic;
import Infrastructure.BasePage;
import Logic.Enums.keywordOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class FindItems extends BasePage {
    // findItems locators
    private final By keywordsInput = By.id("_nkw");
    private final By keywordOptionsDropdown = By.id("s0-1-17-4[0]-7[1]-_in_kw");
    private final By excludeWordsInput = By.id("_ex_kw");
    private final By categoryDropdown = By.id("s0-1-17-4[0]-7[3]-_sacat");

    //Search including locators

    public FindItems(WebDriver driver) {
        super(driver);
    }

    public void enterKeywords(String keywords) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement keywordsInputField = wait.until(ExpectedConditions.presenceOfElementLocated(keywordsInput));
        keywordsInputField.sendKeys(keywords);
    }
    public void selectKeywordOption(keywordOption option) {
        WebElement dropdownElement = driver.findElement(keywordOptionsDropdown);
        Select keywordOptionsSelect = new Select(dropdownElement);
        switch (option) {
            case ALL_WORDS_ANY_ORDER:
                keywordOptionsSelect.selectByValue(keywordOption.ALL_WORDS_ANY_ORDER.getId());
                break;
            case ANY_WORDS_ANY_ORDER:
                keywordOptionsSelect.selectByValue(keywordOption.ANY_WORDS_ANY_ORDER.getId());
                break;
            case EXACT_WORDS_EXACT_ORDER:
                keywordOptionsSelect.selectByValue(keywordOption.EXACT_WORDS_EXACT_ORDER.getId());
                break;
            case EXACT_WORDS_ANY_ORDER:
                keywordOptionsSelect.selectByValue(keywordOption.EXACT_WORDS_ANY_ORDER.getId());
                break;
            default:
                throw new IllegalArgumentException("Invalid keyword option: " + option);
        }
    }
    public void enterExcludeWords(String excludeWords) {
        WebElement excludeWordsInputField = driver.findElement(excludeWordsInput);
        excludeWordsInputField.sendKeys(excludeWords);
    }
    public void executeSelectCategory(String categoryOption) {
        WebElement dropdownElement = driver.findElement(categoryDropdown);
        Select categoryOptionSelect = new Select(dropdownElement);
        List<WebElement> categoryListOptions = dropdownElement.findElements(By.tagName("option"));
        for( WebElement option: categoryListOptions){
            if (option.getText().contains(categoryOption)){
                categoryOptionSelect.selectByValue(option.getAttribute("value"));
                return;
            }
        }
        throw new IllegalArgumentException("Category option was not found");
    }
}

