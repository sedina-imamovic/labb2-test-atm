package bih.iths.sedina.labb2test.service;

import bih.iths.sedina.labb2test.component.AccountComponent;
import bih.iths.sedina.labb2test.exception.InsufficientFundsException;
import bih.iths.sedina.labb2test.exception.InvalidAmountException;
import bih.iths.sedina.labb2test.exception.MaxWithdrawalExceededException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ATMServiceTest {

    @Mock
    private AccountComponent accountComponent;

    @InjectMocks
    private ATMService atmService;


    @Test
    public void depositForInvalidAmount() {
        assertThrows(InvalidAmountException.class, () -> atmService.deposit(-100));
    }

    @Test
    public void depositForValidAmount() {
        atmService.deposit(100);
        verify(accountComponent).deposit(100);
    }


    @Test
    public void withdrawForInvalidAmount() {
        assertThrows(InvalidAmountException.class, () -> atmService.withdraw(-100));
    }

    @Test
    public void withdrawWhenExceedingMaxWithdraw() {
        assertThrows(MaxWithdrawalExceededException.class, () -> atmService.withdraw(2000));
    }

    @Test
    public void withdrawWhenSaldoIsInsufficient() {
        when(accountComponent.getSaldo()).thenReturn(300);
        assertThrows(InsufficientFundsException.class, () -> atmService.withdraw(500));
    }

    @Test
    public void withdrawWhenAmountIsValid() {
        when(accountComponent.getSaldo()).thenReturn(1000);
        atmService.withdraw(100);
        verify(accountComponent).withdraw(100);
    }

    @Test
    public void getSaldoFromAccountComponent() {
        when(accountComponent.getSaldo()).thenReturn(950);
        int result = atmService.getSaldo();
        assertEquals(950, result);
        verify(accountComponent).getSaldo();
    }

}
