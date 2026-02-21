package blackrock.challenge.investment.dto;

import java.time.LocalDateTime;

public class q {

	private Double fixed;
	
	private LocalDateTime  start;
	
	private LocalDateTime  end;

	public Double getFixed() {
		return fixed;
	}

	public void setFixed(Double fixed) {
		this.fixed = fixed;
	}

	public LocalDateTime  getStart() {
		return start;
	}

	public void setStart(LocalDateTime  start) {
		this.start = start;
	}

	public LocalDateTime  getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime  end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "q [fixed=" + fixed + ", start=" + start + ", end=" + end + "]";
	}

	
	
}
