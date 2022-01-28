package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = new Account(1L, 0.0);
		
		acc.deposit(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void withdrawShouldDecreaseBalanceWhenAmountLessOrEqualsThanBalance() {
		
		double amount = 100.0;
		double accountBalance = 250.0;
		double expectedValue = 150.0;
		Account acc = new Account(1L, accountBalance);
		
		acc.withdraw(amount);
		
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}
	
	@Test
	public void fullwithdrawShouldZeroBalanceWhenCalled() {
		
		Account acc = new Account(1L, 5000.0);
		
		acc.fullwithdraw();
		
		Assertions.assertEquals(0.0, acc.getBalance());
	}
	
	@Test
	public void fullwithdrawShouldReturnTheValueWhenCalled() {
		
		double accountBalance = 5000.0;
		Account acc = new Account(1L, accountBalance);
		
		double returnedValue = acc.fullwithdraw();
		
		Assertions.assertEquals(returnedValue, accountBalance);
	}
}
