package ru.nethology.web.test;

import org.junit.jupiter.api.Test;
import ru.nethology.web.data.DataHelper;
import ru.nethology.web.page.CardReplenishment;
import ru.nethology.web.page.DashboardPage;
import ru.nethology.web.page.LoginPageV2;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


class MoneyTransferTest {


    @Test
    void shouldTransferMoneyBetweenOwnCardsV2() {
        open("http://localhost:9999");
        var loginPage = new LoginPageV2();
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
        verificationPage.validVerify(verificationCode);
        var balanceCard1 = new DashboardPage().getCardBalance(0);
        var balanceCard2 = new DashboardPage().getCardBalance(1);
        var top = new DashboardPage().topUp(0);
        var replenishment = new CardReplenishment().replenishment("200", "5559000000000002");
        var balanceFirstCard = new DashboardPage().getCardBalance(0);
        var balanceSecondCard = new DashboardPage().getCardBalance(1);
        int expectedBalanceCard1 = balanceCard1 + 200;
        int expectedBalanceCard2 = balanceCard2 - 200;

        assertEquals(expectedBalanceCard1, balanceFirstCard);
        assertEquals(expectedBalanceCard2, balanceSecondCard);

    }

}

