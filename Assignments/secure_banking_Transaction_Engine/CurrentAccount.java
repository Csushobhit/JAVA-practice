package secure_banking_Transaction_Engine;

public class CurrentAccount extends BankAccount {
	public CurrentAccount(int Accno, String Accname, double b,int p) throws InvalidAmountException {
		super(Accno, Accname, b,p);
	}
	public void accountType()
	{
		System.out.println("Savings Account");
	}
}

