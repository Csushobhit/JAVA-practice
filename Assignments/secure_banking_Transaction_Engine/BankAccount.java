package secure_banking_Transaction_Engine;

public abstract class BankAccount {
	private int AccountNumber;
	private String AccountHolderName;
	private double Balance;
	private int pin;
	
	public BankAccount(int Accno, String Accname, double b, int p) throws InvalidAmountException
	{
		AccountNumber = Accno;
		AccountHolderName = Accname;
		setBalance(b);
		pin = p;
	}
	protected void setBalance(double bb) throws InvalidAmountException
	{
		if(bb < 0)
		{
			throw new InvalidAmountException("Negative balance not allowed");
		}
		this.Balance = bb;
	}
	public double getBalance()
	{
		return Balance;
	}
	public void deposit(double amount) throws InvalidAmountException 
	{
        if (amount <= 0)
        {
            throw new InvalidAmountException("Invalid deposit amount");
        }
        Balance += amount;
    }
	public void withdraw(double amount)
            throws InvalidAmountException {
        if (amount <= 0)
        {
            throw new InvalidAmountException("Invalid withdraw amount");
        }
        if (amount > Balance)
            {
        	throw new InsufficientBalanceException("Not enough balance");
            }
        Balance -= amount;
    }
	public boolean checkPin(int a)
	{
		if(a == pin) return true;
		else
		{
			return false;
		}
	}
	public abstract void accountType();
}
