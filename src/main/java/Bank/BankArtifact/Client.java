package Bank.BankArtifact;

public class Client {
	private Account account;
	
	public Client() {
		this.account = new Account();
	}
	
	public void depositMoney(float amount){
		account.setAmount(account.getAmount()+amount);
	}
	
	public Account getAccount() {
		return this.account;
	}
	
	public int withdrawMoney(float amount){
		float finalAmount = account.getAmount() - amount;
		if(finalAmount>=0) {
			account.setAmount(finalAmount);
			return 0;
		} else {
			return -1;
		}
	}
}
