package bih.iths.sedina.labb2test.component;

import org.springframework.stereotype.Component;

@Component
public class AccountComponent {

    private int saldo = 0;

    public void withdraw(int amount) {
        saldo -= amount;
    }

    public void deposit(int amount) {
        saldo += amount;
    }
    
    public int getSaldo() {
        return saldo;
    }
}
