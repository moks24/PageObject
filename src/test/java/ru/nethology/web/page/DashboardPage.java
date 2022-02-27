package ru.nethology.web.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.val;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    // к сожалению, разработчики не дали нам удобного селектора, поэтому так
    private ElementsCollection topUpButton =  $$("[data-test-id='action-deposit']");
    private SelenideElement cards = $("[data-test-id='dashboard']");
//    private SelenideElement cardsNumberOne = $("[data-test-id=\"92df3f1c-a033-48e6-8390-206f6b1f56c0\"]");
//    private SelenideElement cardsNumberTwo = $("[data-test-id=\"0f3f5c2a-249e-4c3d-8287-09f7a039391d\"]");
    private ElementsCollection carts = $$(".list__item");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";


    public DashboardPage() {
        cards.shouldBe(visible);
    }

    public int getCardBalance(int id) {
        val text = carts.get(id).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public CardReplenishment topUp(int number){
        topUpButton.get(number).click();
        return new CardReplenishment();
    }

}
