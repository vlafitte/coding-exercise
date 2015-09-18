import java.math.BigDecimal;

public class RateWithDurationDiscounts {
    public BigDecimal daily = BigDecimal.valueOf(50);

    // Percentage discount for a weekly rental, expressed as a decimal between 0 and 1
    public BigDecimal weeklyDiscount = BigDecimal.valueOf(0.1);
    // Percentage discount for a monthly rental, expressed as a decimal between 0 and 1
    public BigDecimal monthlyDiscount = BigDecimal.valueOf(0.5);
    
    // Constructor
	public RateWithDurationDiscounts(BigDecimal daily,
			BigDecimal weeklyDiscount, BigDecimal monthlyDiscount) {
		this.daily = daily;
		this.weeklyDiscount = weeklyDiscount;
		this.monthlyDiscount = monthlyDiscount;
	}

	// Default constructor
	public RateWithDurationDiscounts() {
	}
    
    
}
