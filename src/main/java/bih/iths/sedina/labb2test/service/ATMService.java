package bih.iths.sedina.labb2test.service;

import bih.iths.sedina.labb2test.component.AccountComponent;
import bih.iths.sedina.labb2test.exception.InsufficientFundsException;
import bih.iths.sedina.labb2test.exception.InvalidAmountException;
import bih.iths.sedina.labb2test.exception.MaxWithdrawalExceededException;
import org.springframework.stereotype.Service;

@Service
public class ATMService {

    private final AccountComponent accountComponent;

    private final int maxWithdrawalAmount = 1000;

    public ATMService(AccountComponent accountComponent) {
        this.accountComponent = accountComponent;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Insättningen måste vara större än 0!");
        }
        accountComponent.deposit(amount);
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Beloppet måste vara större än 0!");
        }
        //accountComponent.withdraw(amount);

        if (amount > maxWithdrawalAmount) {
            throw new MaxWithdrawalExceededException("Beloppet får inte överstiga maxbeloppet: " + maxWithdrawalAmount);
        }


        if (amount > accountComponent.getSaldo()) {
            throw new InsufficientFundsException("Beloppet får inte överstiga aktuellt saldo!");
        }

        accountComponent.withdraw(amount);

    }

    public int getSaldo() {

        return accountComponent.getSaldo();
        //return 5000;
    }

}
