package blackrock.challenge.investment.dto;

public class ValidInvalidTransaction {
	
	private ValidTransaction  validTransaction;
	
	private InvalidTransaction  invalidTransaction;

	public ValidTransaction getValidTransaction() {
		return validTransaction;
	}

	public void setValidTransaction(ValidTransaction validTransaction) {
		this.validTransaction = validTransaction;
	}

	public InvalidTransaction getInvalidTransaction() {
		return invalidTransaction;
	}

	public void setInvalidTransaction(InvalidTransaction invalidTransaction) {
		this.invalidTransaction = invalidTransaction;
	}

	@Override
	public String toString() {
		return "ValidInvalidTransaction [validTransaction=" + validTransaction + ", invalidTransaction="
				+ invalidTransaction + "]";
	}
	
	

}
