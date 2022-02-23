package ru.nethology.web.test;

import org.junit.jupiter.api.Test;
import ru.nethology.web.data.DataHelper;
import ru.nethology.web.page.CardReplenishment;
import ru.nethology.web.page.DashboardPage;
import ru.nethology.web.page.LoginPageV2;


import static com.codeborne.selenide.Selenide.open;

class MoneyTransferTest {


  @Test
  void shouldTransferMoneyBetweenOwnCardsV2() {
    open("http://localhost:9999");
    var loginPage = new LoginPageV2();
//    var loginPage = open("http://localhost:9999", LoginPageV2.class);
    var authInfo = DataHelper.getAuthInfo();
    var verificationPage = loginPage.validLogin(authInfo);
    var verificationCode = DataHelper.getVerificationCodeFor(authInfo);
    verificationPage.validVerify(verificationCode);
    var top = new DashboardPage().topUp();
    var replenishment = new CardReplenishment().replenishment();
    var balance = new DashboardPage().getCardBalance();

  }

}

