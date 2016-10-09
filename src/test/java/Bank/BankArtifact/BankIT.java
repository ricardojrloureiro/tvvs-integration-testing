package Bank.BankArtifact;

import static org.junit.Assert.*;

import org.junit.Test;

import Bank.BankArtifact.Bank;
import Bank.BankArtifact.Client;

public class BankIT {
	public final float floatTolerance = 0.0001f;


	@Test
	public void testDepositAmount() {
		Bank bank = new Bank();
		Client carlos = new Client();
		
		bank.depositAccount(carlos, 50.0f);
		float accountAmount = carlos.getAccount().getAmount();
		assertEquals(50.0f, accountAmount,floatTolerance);
		
	}
	
	@Test	
	public void testWithdrawAmount() {
		Bank bank = new Bank();
		Client carlos = new Client();
		
		assertEquals(bank.withdrawClientAccount(carlos, 60.0f), -1);
		
		bank.depositAccount(carlos, 50.0f);
		bank.withdrawClientAccount(carlos, 20.0f);
		float accountAmount = carlos.getAccount().getAmount();
		
		assertEquals(30.0f, accountAmount,floatTolerance);
	}

}
