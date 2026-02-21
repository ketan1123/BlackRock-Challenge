package blackrock.challenge.investment.dto;

public class PerformanceResponse {

	private String time; // execution time
	private String memory; // memory usage in MB
	private int threads; // active threads count

	public PerformanceResponse() {
	}

	public PerformanceResponse(String time, String memory, int threads) {
		this.time = time;
		this.memory = memory;
		this.threads = threads;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}
}
