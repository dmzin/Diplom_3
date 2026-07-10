package stellarburgers;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static stellarburgers.Urls.MAIN_PAGE;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Переход к разделу «Соусы»")
    @Description("Проверка переключения таба конструктора на раздел «Соусы»")
    public void shouldSwitchToSaucesSection() {
        navigateTo(MAIN_PAGE);
        objMainPage.waitForLoadMainPage();

        objMainPage.clickSaucesTab();

        String activeTabText = objMainPage.getActiveTabText();
        MatcherAssert.assertThat("Активным должен быть таб «Соусы»", activeTabText, is("Соусы"));
    }

    @Test
    @DisplayName("Переход к разделу «Начинки»")
    @Description("Проверка переключения таба конструктора на раздел «Начинки»")
    public void shouldSwitchToFillingsSection() {
        navigateTo(MAIN_PAGE);
        objMainPage.waitForLoadMainPage();

        objMainPage.clickFillingsTab();

        String activeTabText = objMainPage.getActiveTabText();
        MatcherAssert.assertThat("Активным должен быть таб «Начинки»", activeTabText, is("Начинки"));
    }

    @Test
    @DisplayName("Переход к разделу «Булки»")
    @Description("Проверка переключения таба конструктора на раздел «Булки»")
    public void shouldSwitchToBunsSection() {
        navigateTo(MAIN_PAGE);
        objMainPage.waitForLoadMainPage();

        objMainPage.clickSaucesTab();
        objMainPage.clickBunsTab();

        String activeTabText = objMainPage.getActiveTabText();
        MatcherAssert.assertThat("Активным должен быть таб «Булки»", activeTabText, is("Булки"));
    }

}
