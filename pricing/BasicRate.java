import java.math.BigDecimal;

public class BasicRate {
    // Daily cost in dollars
    public BigDecimal daily = BigDecimal.valueOf(50);
    // Weekly cost in dollars
    public BigDecimal weekly = BigDecimal.valueOf(250);
    // Monthly cost in dollars
    public BigDecimal monthly = BigDecimal.valueOf(1500);
    
    // Constructor
	public BasicRate(BigDecimal daily, BigDecimal weekly, BigDecimal monthly) {
		this.daily = daily;
		this.weekly = weekly;
		this.monthly = monthly;
	}

	public BasicRate() {
		// TODO Auto-generated constructor stub
	}
}
