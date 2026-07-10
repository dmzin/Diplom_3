package stellarburgers.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

    private By loginLink = By.xpath("//a[text()='Войти']");

    public ForgotPasswordPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать 'Войти' в форме восстановления пароля")
    public void clickLoginLink() {
        click(loginLink);
    }

    @Step("Дождаться загрузки формы восстановления пароля")
    public void waitForLoadForgotPasswordPage() {
        waitForVisibility(loginLink);
    }

}
