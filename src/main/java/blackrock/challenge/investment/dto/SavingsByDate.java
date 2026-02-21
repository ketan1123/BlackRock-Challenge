package blackrock.challenge.investment.dto;

import java.time.LocalDateTime;

public class SavingsByDate {

	private LocalDateTime start;
	private LocalDateTime end;
	private double amount;
	private double profits;
	private double taxBenefit;

	public SavingsByDate(LocalDateTime start, LocalDateTime end, double amount, double profits, double taxBenefit) {
		this.start = start;
		this.end = end;
		this.amount = amount;
		this.profits = profits;
		this.taxBenefit = taxBenefit;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public double getAmount() {
		return amount;
	}

	public double getProfits() {
		return profits;
	}

	public double getTaxBenefit() {
		return taxBenefit;
	}
}