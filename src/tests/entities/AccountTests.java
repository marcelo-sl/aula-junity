package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factories.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenAmountLessOrEqualsThanBalance() {
		
		double amount = 100.0;
		double accountBalance = 250.0;
		double expectedValue = 150.0;
		Account acc = AccountFactory.createAccount(accountBalance);
		
		acc.withdraw(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Account acc = AccountFactory.createAccount(800.0);
			acc.withdraw(801.0);
		});
	}
	
	@Test
	public void fullwithdrawShouldZeroBalanceAndReturnValue() {
		
		double initialBalance = 5000.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		
		double result = acc.fullwithdraw();
		
		Assertions.assertEquals(0.0, acc.getBalance());
		Assertions.assertEquals(result, initialBalance);
	}
}
