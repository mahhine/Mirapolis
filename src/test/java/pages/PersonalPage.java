package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public class PersonalPage {

    private final SelenideElement loadingOpenPersonalPage = $(By.xpath("//span[@class='mira-vertical-portal-menu-fixer-title']"));

    public void loadingPersonalPage() {
        log.info("Перешли на персональную страницу");
        loadingOpenPersonalPage.shouldBe(Condition.visible);
    }
}
