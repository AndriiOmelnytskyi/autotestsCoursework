package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class mainPage extends basePage {

    public mainPage(WebDriver driver){
        super(driver);
    }

    public By itemCard = By.xpath("//div[@class = 'card-body'][contains(., 'Tribute Burger')]");

    public By closePopUp = By.className("btn-close");

    public By addItemToBasket = By.xpath("//Button[contains(., 'Add to Cart')]");

    public By beef = By.xpath("//div[@class = 'modal-body'][contains(., 'beef')]");

    public By americanCheese = By.xpath("//div[@class = 'modal-body'][contains(., 'american cheese')]");

    public By burgerSauce = By.xpath("//div[@class = 'modal-body'][contains(., 'burger sauce')]");

    public By frenchMustard = By.xpath("//div[@class = 'modal-body'][contains(., 'french mustard')]");

    public By pickes = By.xpath("//div[@class = 'modal-body'][contains(., 'pickes')]");

    public By onion = By.xpath("//div[@class = 'modal-body'][contains(., 'onion')]");

    public By lettuce = By.xpath("//div[@class = 'modal-body'][contains(., 'lettuce')]");

    public void clickAtItem(){
        driver.findElement(itemCard).click();
    }

    public void closePopUp(){ driver.findElement(closePopUp).click();}

    public void addItem(){ driver.findElement(addItemToBasket).click();}

    public void assertIsDisplayed(){
        driver.findElement(itemCard).isDisplayed();
    }

    public void assertBeefIsDisplayed() { driver.findElement(beef).isDisplayed();}

    public void assertAmericanCheeseIsDisplayed(){
        driver.findElement(americanCheese).isDisplayed();
    }

    public void assertBurgerSauceIsDisplayed(){
        driver.findElement(burgerSauce).isDisplayed();
    }

    public void assertFrenchMustardIsDisplayed(){
        driver.findElement(frenchMustard).isDisplayed();
    }

    public void assertOnionIsDisplayed(){
        driver.findElement(onion).isDisplayed();
    }

    public void assertLettuceIsDisplayed(){
        driver.findElement(lettuce).isDisplayed();
    }

    public void assertPickesIsDisplayed(){
        driver.findElement(pickes).isDisplayed();
    }

    public void clickRightPaginationButton(){
        driver.findElement(By.xpath("//a[@class = 'page-link'][contains(., '›')]")).click();
    }

    public void clickLeftPaginationButton(){
        driver.findElement(By.xpath("//a[@class = 'page-link'][contains(., '‹')]")).click();
    }

    public void clickAtCardButton(){
        driver.findElement(By.xpath("//button[contains(., 'Cart')]")).click();
    }

    public void clickAtClosePopUpButton(){
        driver.findElement(By.xpath("//button[@class = 'Toastify__close-button Toastify__close-button--dark']")).click();
    }

    public void assertTextPresent(String text){
        driver.findElements(By.linkText(text));
    }

    public void wait(int seconds){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }


}
