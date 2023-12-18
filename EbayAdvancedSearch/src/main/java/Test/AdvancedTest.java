package Test;
import Infrastructure.Setup;
import Logic.*;
import Logic.Enums.Format;
import Logic.Enums.conditionEnum;
import Logic.Enums.keywordOption;
import org.junit.jupiter.api.BeforeEach;
//import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
public class AdvancedTest {
    private static Setup newDriver = null;
    private static MainPage mainPage = null;
    @BeforeEach
    public void setup(){
        newDriver= new Setup();
        newDriver.setupDriver("chrome"); // get from configuration file
        newDriver.navigateToURL("https://www.ebay.com/sch/ebayadvsearch"); // get from configuration file
        mainPage = new MainPage(newDriver.getDriver());
    }
    @Test
    public void fillItemsTest() {
        mainPage.fillFindItemsSection("ashraf", keywordOption.ANY_WORDS_ANY_ORDER,"ashraf","Baby");

    }

    @Test
    public void fillSearchincludingTest(){
        mainPage.fillSearchIncluding(false,true,false);
    }

    @Test
    public void fillPriceSectionTest()  {
        mainPage.fillPrice(12.5,1212.2);
    }
    @Test
    public void fillBuyingFormatTest(){
        mainPage.fillBuyingFormat(Format.BUY_IT_NOW);
    }
    @Test
    public void fillConditionTest() {
        mainPage.fillCondition(conditionEnum.NOT_SPECIFIED);
    }

    @AfterEach
    public void tearDown(){
        newDriver.closeDriver();
        mainPage = null;
    }
}
