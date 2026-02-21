package blackrock.challenge.investment.dto;

import blackrock.challenge.investment.dto.k;
import blackrock.challenge.investment.dto.p;
import blackrock.challenge.investment.dto.q;
import blackrock.challenge.investment.dto.Transactions;

import java.util.List;

public class ReturnRequest {

	private Integer age;
	private Double wage; // monthly wage
	private Double inflation; // annual inflation

	private List<q> q;
	private List<p> p;
	private List<k> k;

	private List<Transactions> transactions;

	public ReturnRequest() {
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getWage() {
		return wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
	}

	public Double getInflation() {
		return inflation;
	}

	public void setInflation(Double inflation) {
		this.inflation = inflation;
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

	public List<Transactions> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transactions> transactions) {
		this.transactions = transactions;
	}
}
