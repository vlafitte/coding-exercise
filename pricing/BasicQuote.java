import java.math.BigDecimal;

public class BasicQuote {
	
	// Trip cost
    public BigDecimal renterCost;
    
    // Owners earn 75% of the trip cost
    public BigDecimal ownerEarnings;

	public BasicQuote() {
	}
	
	public BasicQuote(BigDecimal renterCost) {
		this.renterCost = renterCost;
		
		this.ownerEarnings = renterCost.multiply(BigDecimal.valueOf(0.75));
	}
	
}
