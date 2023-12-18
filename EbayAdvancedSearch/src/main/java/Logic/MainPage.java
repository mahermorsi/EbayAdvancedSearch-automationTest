package Logic;
import Logic.Enums.Format;
import Logic.Enums.conditionEnum;
import Logic.Enums.keywordOption;
import org.openqa.selenium.WebDriver;
import Infrastructure.BasePage;

public class MainPage extends BasePage {
    private final FindItems findItems = new FindItems(driver);
    private final SearchIncluding searchincluding = new SearchIncluding(driver);
    private final Price priceSection = new Price(driver);
    private final BuyingFormat buyingFormat= new BuyingFormat(driver);
    private final Condition conditionSection = new Condition(driver);
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillFindItemsSection(String keywords, keywordOption keywordOption,String excludeWords, String category){
        findItems.enterKeywords(keywords);
        findItems.selectKeywordOption(keywordOption);
        findItems.enterExcludeWords(excludeWords);
        findItems.executeSelectCategory(category);
    }
    public void fillSearchIncluding(boolean titleAndDescription, boolean completedItems, boolean soldItems){
        searchincluding.selectCheckBoxes(titleAndDescription,completedItems,soldItems);
    }
    public void fillPrice(double minPrice, double maxPrice){
        priceSection.inputMinMaxRangePrice(minPrice,maxPrice);
    }
    public void fillBuyingFormat(Format format){
        buyingFormat.selectBuyingFormat(format);
    }
    public void fillCondition(conditionEnum condition){
        conditionSection.chooseCondition(condition);
    }
}
