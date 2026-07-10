package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import stellarburgers.generators.UserGenerator;
import stellarburgers.model.User;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
import static stellarburgers.Urls.REGISTER_PAGE;

public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    @Description("Проверка успешной регистрации нового пользователя с валидными данными")
    public void shouldRegisterSuccessfully() {
        email = UserGenerator.generateRandomEmail();
        password = UserGenerator.generateRandomPassword();
        name = UserGenerator.generateRandomName();

        navigateTo(REGISTER_PAGE);
        objRegisterPage.waitForLoadRegisterPage();

        objRegisterPage.register(name, email, password);

        objLoginPage.waitForLoadLoginPage();

        String currentUrl = driver.getCurrentUrl();
        MatcherAssert.assertThat("После регистрации должен быть переход на страницу входа",
                currentUrl, containsString("login"));

        fetchAccessTokenAfterRegistration(email, password, name);
    }

    @Test
    @DisplayName("Ошибка при регистрации с коротким паролем (меньше 6 символов)")
    @Description("Проверка появления ошибки при регистрации с паролем менее 6 символов")
    public void shouldShowErrorForShortPassword() {
        email = UserGenerator.generateRandomEmail();
        password = "12345";
        name = UserGenerator.generateRandomName();

        navigateTo(REGISTER_PAGE);
        objRegisterPage.waitForLoadRegisterPage();

        objRegisterPage.register(name, email, password);

        assertTrue("Должна появиться ошибка о некорректном пароле",
                objRegisterPage.isPasswordErrorDisplayed());
        MatcherAssert.assertThat("Текст ошибки должен быть 'Некорректный пароль'",
                objRegisterPage.getPasswordErrorText(), is("Некорректный пароль"));
    }

}
