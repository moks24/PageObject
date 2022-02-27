package ru.nethology.web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CardReplenishment {

    private SelenideElement cart = $("[class='heading heading_size_xl heading_theme_alfa-on-white']");
    private SelenideElement sum = $("[data-test-id='amount'] input");
    private SelenideElement from = $("[data-test-id='from'] input");
    private SelenideElement topUpButton = $("[data-test-id='action-transfer']");

    public CardReplenishment() {
        cart.shouldBe(visible);
    }

    public DashboardPage replenishment(String amount, String cardNumber){
        sum.setValue(amount);
        from.setValue(cardNumber);
        topUpButton.click();
        return new DashboardPage();
    }

}
