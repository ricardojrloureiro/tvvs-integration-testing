package Bank.BankArtifact;

import java.util.ArrayList;

public class Bank {
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	
	public Bank() {
		
	}
	
	/**
	 * @param client
	 * @param amount
	 * @return -1 if there isn't enough amount or 0 if the transaction went as expected
	 */
	public int withdrawClientAccount(Client client, float amount) {
		return client.withdrawMoney(amount);
	}
	
	public void depositAccount(Client client, float amount) {
		client.depositMoney(amount);
	}
	
	public void addClient(Client client) {
		clients.add(client);
	}
}
