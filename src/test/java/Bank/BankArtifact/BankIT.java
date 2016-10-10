package Bank.BankArtifact;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Bank.BankArtifact.Bank;
import Bank.BankArtifact.Client;

public class BankIT {
	public final float floatTolerance = 0.0001f;
	private Bank bank;
	
	@Before
    public void setUp() {
		bank = new Bank();
		Client carlos = new Client("Carlos");
		Client melo = new Client("Melo");
		Client rui = new Client("Rui");
		
		bank.addClient(carlos);	bank.addClient(melo); bank.addClient(rui);

    }
	
	

	@Test
	public void testDepositAmount() {
		
		Client carlos = bank.getClientByName("Carlos");
		bank.depositAccount(carlos, 50.0f);
		float accountAmount = carlos.getAccount().getAmount();
		assertEquals(50.0f, 30.0f,floatTolerance);
		
	}
	
	@Test	
	public void testWithdrawAmount() {
		Client rui = bank.getClientByName("Rui");
		
		assertEquals(bank.withdrawClientAccount(rui, 60.0f), -1);
		
		bank.depositAccount(rui, 50.0f);
		bank.withdrawClientAccount(rui, 20.0f);
		float accountAmount = rui.getAccount().getAmount();
		
		assertEquals(30.0f, accountAmount,floatTolerance);
	}
	
	@Test
	public void testTransactionBetweenUsers() {
		Client carlos = bank.getClientByName("Carlos");
		Client melo = bank.getClientByName("Melo");
		
		bank.depositAccount(carlos, 50.0f);
		
		bank.transfer(carlos, melo, 10.0f);
		
		assertEquals(40.0f, carlos.getAccount().getAmount(),floatTolerance);
		assertEquals(10.0f, melo.getAccount().getAmount(),floatTolerance);
	}

}
