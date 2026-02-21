package blackrock.challenge.investment.dto;

import java.util.List;

public class ValidTransaction {

	private List<Transactions> transaction;

	public List<Transactions> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transactions> transaction) {
		this.transaction = transaction;
	}

	@Override
	public String toString() {
		return "ValidTransaction [transaction=" + transaction + "]";
	}
	
	
}
