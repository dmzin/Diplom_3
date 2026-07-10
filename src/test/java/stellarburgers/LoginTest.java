package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static stellarburgers.Urls.*;

public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Вход через кнопку «Войти в аккаунт» на главной странице")
    @Description("Проверка входа в систему через кнопку «Войти в аккаунт» на главной странице")
    public void shouldLoginViaMainPageLoginButton() {
        createUserViaApi();

        navigateTo(MAIN_PAGE);
        objMainPage.waitForLoadMainPage();

        objMainPage.clickLoginButtonOnMain();

        objLoginPage.waitForLoadLoginPage();
        objLoginPage.login(email, password);

        objMainPage.waitForLoadMainPage();
        MatcherAssert.assertThat("После входа должна отображаться кнопка «Оформить заказ»",
                objMainPage.isOrderButtonDisplayed(), is(true));
    }

    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Проверка входа в систему через кнопку «Личный кабинет» в шапке сайта")
    public void shouldLoginViaPersonalAccountButton() {
        createUserViaApi();

        navigateTo(MAIN_PAGE);
        objMainPage.waitForLoadMainPage();

        objMainPage.clickPersonalAccountButton();

        objLoginPage.waitForLoadLoginPage();
        objLoginPage.login(email, password);

        objMainPage.waitForLoadMainPage();
        MatcherAssert.assertThat("После входа должна отображаться кнопка «Оформить заказ»",
                objMainPage.isOrderButtonDisplayed(), is(true));
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Проверка входа в систему через ссылку «Войти» на странице регистрации")
    public void shouldLoginViaRegisterPage() {
        createUserViaApi();

        navigateTo(REGISTER_PAGE);
        objRegisterPage.waitForLoadRegisterPage();

        objRegisterPage.clickLoginLink();

        objLoginPage.waitForLoadLoginPage();
        objLoginPage.login(email, password);

        objMainPage.waitForLoadMainPage();
        MatcherAssert.assertThat("После входа должна отображаться кнопка «Оформить заказ»",
                objMainPage.isOrderButtonDisplayed(), is(true));
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Проверка входа в систему через ссылку «Войти» на странице восстановления пароля")
    public void shouldLoginViaForgotPasswordPage() {
        createUserViaApi();

        navigateTo(FORGOT_PASSWORD_PAGE);
        objForgotPasswordPage.waitForLoadForgotPasswordPage();

        objForgotPasswordPage.clickLoginLink();

        objLoginPage.waitForLoadLoginPage();
        objLoginPage.login(email, password);

        objMainPage.waitForLoadMainPage();
        MatcherAssert.assertThat("После входа должна отображаться кнопка «Оформить заказ»",
                objMainPage.isOrderButtonDisplayed(), is(true));
    }

}
