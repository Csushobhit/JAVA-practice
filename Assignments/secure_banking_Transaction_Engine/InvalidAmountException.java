package secure_banking_Transaction_Engine;

public class InvalidAmountException extends Exception{
	InvalidAmountException(String message)
	{
		super(message);
	}
}
