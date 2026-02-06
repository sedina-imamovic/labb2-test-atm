package bih.iths.sedina.labb2test.component;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountComponentTest {

    private AccountComponent accountComponent;

    @BeforeEach
    public void setUp() {
        accountComponent = new AccountComponent();
    }

    @Test
    public void saldoShouldBeZero() {
        assertEquals(0, accountComponent.getSaldo());
    }

    @Test
    public void depositShouldAffectSaldo() {
        accountComponent.deposit(1000);
        assertEquals(1000, accountComponent.getSaldo());
    }

    @Test
    public void withdrawShouldAffectSaldo() {
        accountComponent.withdraw(500);
        assertEquals(-500, accountComponent.getSaldo());
    }

    @Test
    public void withdrawAndDepositTest() {
        accountComponent.deposit(700);
        accountComponent.withdraw(400);
        assertEquals(300, accountComponent.getSaldo());
    }

}
