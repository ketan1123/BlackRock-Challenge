package blackrock.challenge.investment.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Positive;

public class Transactions {

	private LocalDateTime  date;
	
	@Positive(message = "amount must be greater than 0")
	private Double amount;
	
	@Positive(message = "amount must be greater than 0")
	private Double ceiling;
	
	@Positive(message = "amount must be greater than 0")
	private Double remanent;
	
	private String message;

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

	public Double getCeiling() {
		return ceiling;
	}

	public void setCeiling(Double ceiling) {
		this.ceiling = ceiling;
	}

	public Double getRemanent() {
		return remanent;
	}

	public void setRemanent(Double remanent) {
		this.remanent = remanent;
	}
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Transactions [date=" + date + ", amount=" + amount + ", ceiling=" + ceiling + ", remanent=" + remanent
				+ ", message=" + message + "]";
	}
	
	
	
	
}
