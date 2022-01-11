package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class HomePageAuthorization {
    private final SelenideElement loginField = $(By.xpath("//input[@name='user']"));
    @Getter
    private final SelenideElement passwordField = $(By.xpath("//input[@name='password']"));
    private final SelenideElement passwordVisible = $(By.xpath("//input[@type='text']"));
    private final SelenideElement buttonPasswordVisible = $(By.id("show_password"));
    private final SelenideElement login = $(By.xpath("//input[@name='user']"));
    private final SelenideElement password = $(By.xpath("//input[@name='password']"));
    private final SelenideElement buttonEnter = $(By.id("button_submit_login_form"));


    @Step("Проверка видимости пароля")
    public void setPasswordVisible(String login, String password){
        log.info("Вводим логин");
        loginField.val(login);
        log.info("Вводим пароль");
        passwordField.val(password);
        log.info("Нажимаем кнопку видимости пароля");
        buttonPasswordVisible.shouldBe(Condition.visible).click();
        log.info("Пароль виден");
        passwordVisible.shouldBe(Condition.visible);
    }

    @Step("Авторизация пользователя")
    public void authorization(String login, String password){
        log.info("Вводим логин");
        this.login.val(login);
        log.info("Вводим пароль");
        this.password.val(password);
        log.info("Переходим на персональную страницу");
        buttonEnter.shouldBe(Condition.visible).click();
    }
}
