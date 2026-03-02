package secure_banking_Transaction_Engine;

public class InsufficientBalanceException extends RuntimeException{
	InsufficientBalanceException(String message)
	{
		super(message);
	}
}
