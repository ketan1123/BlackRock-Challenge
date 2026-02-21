package blackrock.challenge.investment.dto;

import java.util.List;

import jakarta.validation.constraints.Positive;

public class WageTransaction {
	
	@Positive(message = "amount must be greater than 0")
	private Double wage;
	
	private List<Transactions> transactions;

	public Double getWage() {
		return wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
	}

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "WageTransaction [wage=" + wage + ", transactions=" + transactions + "]";
	}
	
	
	
	

}
