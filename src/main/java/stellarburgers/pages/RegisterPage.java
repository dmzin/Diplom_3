package stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    private By nameField = By.xpath("//label[text()='Имя']/../input");
    private By emailField = By.xpath("//label[text()='Email']/../input");
    private By passwordField = By.xpath("//input[@name='Пароль']");
    private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By loginLink = By.xpath("//a[text()='Войти']");
    private By passwordError = By.xpath("//p[text()='Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @Step("Ввести имя: {name}")
    public void setName(String name) {
        type(nameField, name);
    }

    @Step("Ввести Email: {email}")
    public void setEmail(String email) {
        type(emailField, email);
    }

    @Step("Ввести пароль")
    public void setPassword(String password) {
        type(passwordField, password);
    }

    @Step("Нажать на кнопку 'Зарегистрироваться'")
    public void clickRegisterButton() {
        click(registerButton);
    }

    @Step("Нажать на кнопку 'Войти'")
    public void clickLoginLink() {
        click(loginLink);
    }

    public String getPasswordErrorText() {
        return driver.findElement(passwordError).getText();
    }

    public boolean isPasswordErrorDisplayed() {
        return driver.findElement(passwordError).isDisplayed();
    }

    @Step("Зарегистрировать пользователя: {name}, {email}")
    public void register(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickRegisterButton();
    }

    @Step("Дождаться загрузки страницы регистрации")
    public void waitForLoadRegisterPage() {
        waitForVisibility(registerButton);
    }

}
