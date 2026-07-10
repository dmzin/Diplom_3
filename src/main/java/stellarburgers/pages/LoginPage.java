package stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailField = By.xpath("//input[@name='name']");
    private By passwordField = By.xpath("//input[@name='Пароль']");
    private By loginButton = By.xpath("//button[text()='Войти']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести Email: {email}")
    public void setEmail(String email) {
        type(emailField, email);
    }

    @Step("Ввести пароль")
    public void setPassword(String password) {
        type(passwordField, password);
    }

    @Step("Нажать кнопку 'Войти'")
    public void clickLoginButton() {
        click(loginButton);
    }

    @Step("Войти по Email: {email}")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickLoginButton();
    }

    @Step("Дождаться загрузки страницы")
    public void waitForLoadLoginPage() {
        waitForVisibility(loginButton);
    }

}
