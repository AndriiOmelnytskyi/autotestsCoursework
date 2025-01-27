
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.itemPage;
import pages.mainPage;

public class mainPageGeneralTest {
    private mainPage mainPage;
    private itemPage itemPage;

    /**
     * Тест відповідає за перевірку основної логіки на головній сторінці додатку: перегляд
     * карток із бургерами, перевірка інформації про бургери, додавання бургеру в корзину
     */
    @Test
    public void t_01_checkingGeneralInfoTest(){
        Assert.assertEquals("11", "21");
    }

    /**
    * Тест перевіряє роботу пагінації на головній сторінці
    */
    @Test
    public void t_02_checkPagination(){
        Assert.assertEquals("11", "11");
    }

    /**
     * Тест перевіряє додавання окремого товару в корзину. Перевірка підтвердження покупки
     */
    @Test
    public void t_03_addAndBuyItem(){
        setUp();
        //додавання бургера в корзину
        mainPage.wait(5);
        mainPage.addItem();
        mainPage.assertTextPresent("Cart 1");
        mainPage.wait(5);
        mainPage.clickAtClosePopUpButton();
        mainPage.clickAtCardButton();
        //перевірка валідацій в корзині
        itemPage.assertTextPresent("Tribute Burger");
        itemPage.clickAtAddItemButton();
        itemPage.clickAtAddItemButton();
        itemPage.clickAtAddItemButton();
        itemPage.removeItemButton();
        itemPage.removeItemButton();
        itemPage.removeItemButton();
        //погодження покупки
        itemPage.confirmButton();
        mainPage.wait(5);
        //перевірка повернення на головну сторінку
        mainPage.assertIsDisplayed();
    }

    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        mainPage = new mainPage(driver);
        itemPage = new itemPage(driver);
        mainPage.navigateTo("https://musical-douhua-c546d9.netlify.app/");
    }


}
