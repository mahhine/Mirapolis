package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import pages.HomePageAuthorization;
import pages.PageForgetPassword;
import pages.PersonalPage;

import static com.codeborne.selenide.Selenide.*;

@Log4j2
@Feature("Вход в систему")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MirapolisTest {

    HomePageAuthorization homePageAuthorization = new HomePageAuthorization();

    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void setUpEach() {
        open("https://lmslite47vr.demo.mirapolis.ru/mira");
    }

    @AfterEach
    public void tierDown() {
        closeWebDriver();
    }

    @Test
    @DisplayName("Авторизация пользователя")
    public void signIn() {
        PersonalPage personalPage = new PersonalPage();
        homePageAuthorization.authorization("fominaelena", "1P73BP4Z");
        personalPage.loadingPersonalPage();
    }

    @Test
    @DisplayName("Проверка кнопки отображения пароля")
    public void setPasswordVisible(){
        homePageAuthorization.setPasswordVisible("fominaelena", "1P73BP4Z");
        Assertions.assertEquals("text", homePageAuthorization.getPasswordField().getAttribute("type"), "Тип элемента не изменился: " + homePageAuthorization.getPasswordField().getAttribute("type"));
    }

    @Test
    @DisplayName("Проверка негативного сценария 'Неверный логин'")
    public void negativeLogin(){
        homePageAuthorization.authorization("fominaelenasdfsdf", "1P73BP4Z");
        Assertions.assertEquals("Неверные данные для авторизации", Selenide.switchTo().alert().getText(), "Предупреждение не соответсвует ожидаемому: " + Selenide.switchTo().alert().getText());
    }

    @Test
    @DisplayName("Забыл пароль")
    public void forgetPassword(){
        PageForgetPassword pageForgetPassword = new PageForgetPassword();
        pageForgetPassword.forgetPassword();
    }
}
