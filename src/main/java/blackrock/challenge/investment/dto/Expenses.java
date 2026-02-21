package blackrock.challenge.investment.dto;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.validation.constraints.Positive;

public class Expenses {

	private LocalDateTime  date;
	
	@Positive(message = "amount must be greater than 0")
	private Double amount;

	public LocalDateTime  getDate() {
		return date;
	}

	public void setDate(LocalDateTime  date) {
		this.date = date;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Expenses [date=" + date + ", amount=" + amount + "]";
	}
	
	
}
