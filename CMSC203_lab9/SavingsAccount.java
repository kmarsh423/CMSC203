package dataElement;

public class SavingsAccount extends BankAccount{

	private double rate = 0.025;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double amount) {
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
	}
	
	public void postInterest() {
		double newBalance = rate/12; 
		setBalance((newBalance*getBalance())+getBalance());
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		super(oldAccount, amount);
		savingsNumber++;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	
}
