package stellarburgers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import stellarburgers.client.UserClient;
import stellarburgers.generators.UserGenerator;
import stellarburgers.model.User;
import stellarburgers.pages.*;

import static stellarburgers.Urls.BASE_URL;

public class BaseTest {

    WebDriver driver;
    MainPage objMainPage;
    LoginPage objLoginPage;
    RegisterPage objRegisterPage;
    ForgotPasswordPage objForgotPasswordPage;
    UserClient userClient;

    protected String accessToken;
    protected String email;
    protected String password;
    protected String name;

    @Before
    public void startUp() {
        String browser = System.getProperty("browser", "chrome");

        if (browser.equals("yandex")) {
            startBrowserYandex();
        } else {
            startBrowserChrome();
        }

        driver.manage().window().maximize();

        objMainPage = new MainPage(driver);
        objLoginPage = new LoginPage(driver);
        objRegisterPage = new RegisterPage(driver);
        objForgotPasswordPage = new ForgotPasswordPage(driver);
        userClient = new UserClient();
    }

    public void startBrowserChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void startBrowserYandex() {
        String yandexDriverPath = System.getProperty("yandex.driver.path",
                "/Users/dmitriizinenko/Documents/projects_maven/Diplom/yandexdriver");
        System.setProperty("webdriver.chrome.driver", yandexDriverPath);
        driver = new ChromeDriver();
    }

    public void navigateTo(String page) {
        driver.get(BASE_URL + page);
    }

    protected User createUserViaApi() {
        email = UserGenerator.generateRandomEmail();
        password = UserGenerator.generateRandomPassword();
        name = UserGenerator.generateRandomName();
        Response response = userClient.register(new User(email, password, name));
        accessToken = response.path("accessToken");
        return new User(email, password, name);
    }

    protected void fetchAccessTokenAfterRegistration(String email, String password, String name) {
        Response loginResponse = userClient.login(new User(email, password, name));
        accessToken = loginResponse.path("accessToken");
    }

    @After
    public void teardown() {
        if (accessToken != null) {
            userClient.delete(accessToken);
        }
        if (driver != null) {
            driver.quit();
        }
    }

}
