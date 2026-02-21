package blackrock.challenge.investment.dto;

import java.util.List;

public class InvalidTransaction {

	private List<Transactions> transactions;
	
	//private String Message;

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	/*
	 * public String getMessage() { return Message; }
	 * 
	 * public void setMessage(String message) { Message = message; }
	 */

	@Override
	public String toString() {
		return "InvalidTransaction [transactions=" + transactions + "]";
	}
}
