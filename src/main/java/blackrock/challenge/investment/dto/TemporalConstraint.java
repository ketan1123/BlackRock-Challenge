package blackrock.challenge.investment.dto;

import java.util.List;

public class TemporalConstraint {

	private Double wage;
	
	private List<Transactions> transactions;
	
	private List<q> q;
	
	private List<p> p;
	
	private List<k> k;


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

	public List<q> getQ() {
		return q;
	}

	public void setQ(List<q> q) {
		this.q = q;
	}

	public List<p> getP() {
		return p;
	}

	public void setP(List<p> p) {
		this.p = p;
	}

	public List<k> getK() {
		return k;
	}

	public void setK(List<k> k) {
		this.k = k;
	}

	@Override
	public String toString() {
		return "TemporalConstraint [wage=" + wage + ", transactions=" + transactions + ", q=" + q + ", p=" + p + ", k="
				+ k + "]";
	}
	
	
	
}
