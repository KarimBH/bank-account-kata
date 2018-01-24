package com.github.karimbh.bankaccount.stepsdefs;

import com.github.karimbh.bankaccount.domain.Account;
import com.github.karimbh.bankaccount.domain.Client;
import com.github.karimbh.bankaccount.domain.MonetaryAmount;
import cucumber.api.java8.En;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.Assert.assertEquals;

public class WithdrawFromAccountStepDefinitions implements En {

    private Account account;

    public WithdrawFromAccountStepDefinitions() {
        configureSteps();
    }

    private void configureSteps() {
        Given("^an existing client named \"([^\"]*)\" with (.+) (.*) in his account$",
                (String username, BigDecimal initialBalance, Currency currency) -> {
                    account = new Account(
                            new Client(username),
                            new MonetaryAmount(initialBalance, currency)
                    );
                });

        When("^he withdraws (.+) (.*) from his account$", (BigDecimal withdrawVal, Currency currency) -> {
            account.withdraw(new MonetaryAmount(withdrawVal, currency));
        });

        Then("^the new balance is (.+) (.*)$", (BigDecimal newBalance, Currency currency) -> {
            assertEquals(account.getBalance(), new MonetaryAmount(newBalance, currency));
        });
    }

}
