package blackrock.challenge.investment.dto;

import java.time.LocalDateTime;

public class p {

    private Double extra;
	
	private LocalDateTime  start;
	
	private LocalDateTime  end;

	public Double getExtra() {
		return extra;
	}

	public void setExtra(Double extra) {
		this.extra = extra;
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
		return "p [extra=" + extra + ", start=" + start + ", end=" + end + "]";
	}
	
	
}
