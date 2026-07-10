package stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    private By loginButtonOnMain = By.xpath("//button[text()='Войти в аккаунт']");
    private By personalAccountButton = By.xpath("//p[text()='Личный Кабинет']");
    private By mainHeader = By.xpath("//h1[text()='Соберите бургер']");
    private By orderButton = By.xpath("//button[text()='Оформить заказ']");
    private By bunsTab = By.xpath("//span[text()='Булки']/parent::*");
    private By saucesTab = By.xpath("//span[text()='Соусы']/parent::*");
    private By fillingsTab = By.xpath("//span[text()='Начинки']/parent::*");
    private By activeTab = By.xpath("//div[contains(@class, 'tab_tab_type_current')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать кнопку 'Войти в аккаунт'")
    public void clickLoginButtonOnMain() {
        click(loginButtonOnMain);
    }

    @Step("Нажать кнопку 'Личный Кабинет'")
    public void clickPersonalAccountButton() {
        click(personalAccountButton);
    }

    @Step("Нажать на раздел 'Булки'")
    public void clickBunsTab() {
        click(bunsTab);
    }

    @Step("Нажать на раздел 'Соусы'")
    public void clickSaucesTab() {
        click(saucesTab);
    }

    @Step("Нажать на раздел 'Начинки'")
    public void clickFillingsTab() {
        click(fillingsTab);
    }

    @Step("Получить текст активного раздела")
    public String getActiveTabText() {
        return driver.findElement(activeTab).getText();
    }

    @Step("Проверить отображатеся ли кнопка 'Оформить заказ'")
    public boolean isOrderButtonDisplayed() {
        waitForVisibility(orderButton);
        return driver.findElement(orderButton).isDisplayed();
    }

    @Step("Дождаться загрузки главной страницы")
    public void waitForLoadMainPage() {
        waitForVisibility(mainHeader);
    }

}
