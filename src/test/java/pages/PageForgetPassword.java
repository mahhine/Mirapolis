package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class PageForgetPassword {
    private final SelenideElement buttonForgetPassword = $(By.cssSelector(".mira-default-login-page-link"));
    private final SelenideElement loadingOpenPageForgetPassword = $(By.xpath("//div[@class='info-title'][text()='Восстановление пароля']"));
    private final SelenideElement buttonBackToHomePage = $(By.cssSelector(".mira-page-forgot-password-link"));

    @Step("Проверка кнопок 'Забыли пароль?' и 'Назад к входу в систему'")
    public void forgetPassword(){
        log.info("Нажимаем кнопку 'Забыли пароль?' ");
        buttonForgetPassword.shouldBe(Condition.visible).click();
        log.info("Перешли на страницу 'Восстановление пароля'");
        loadingOpenPageForgetPassword.shouldBe(Condition.visible);
        log.info("Нажимаем кнопку 'Назад к входу в систему'");
        buttonBackToHomePage.shouldBe(Condition.visible).click();
        log.info("Перешли на домашнюю страницу");
        buttonForgetPassword.shouldBe(Condition.visible);
    }
}
