

import java.time.ZonedDateTime;

import junit.framework.TestCase;

public class PriceTest  extends TestCase {

	//Test with basic price
	public void testPrice() throws Exception {

        //______________________________________________________________
        // Test with basic prices.
        //_______________________________________________________________

		// Variables initialisation
		BestPriceFounder bpf = new BestPriceFounder();
		BasicQuote result;
        ZonedDateTime start = ZonedDateTime.now();
        ZonedDateTime end = ZonedDateTime.now();
        
        // Test for 1 days
        result = bpf.getQuote(start, end.plusDays(1), new BasicRate());
        assertEquals(50,0 , result.renterCost.doubleValue());
        assertEquals(37,5, result.ownerEarnings.doubleValue());
        
        // Test for 12 days : 1 week + 5 days
        result = bpf.getQuote(start, end.plusDays(12), new BasicRate());
        assertEquals(500,0 , result.renterCost.doubleValue());
        assertEquals(375,0 , result.ownerEarnings.doubleValue());
        
        // Test for 45 days : 1 month, 2 weeks and 1 day
        result = bpf.getQuote(start, end.plusDays(45), new BasicRate());
        assertEquals(2050,0 , result.renterCost.doubleValue());
        assertEquals(1537,50 , result.ownerEarnings.doubleValue());

        //______________________________________________________________
        // Test with discount duration.
        //_______________________________________________________________
		
        // Test for 1 days => no discount
        result = bpf.getQuote(start, end.plusDays(1), new RateWithDurationDiscounts());
        assertEquals(50,0 , result.renterCost.doubleValue());
        assertEquals(37,5, result.ownerEarnings.doubleValue());
        
        // Test for 12 days => no discount because 2 days more
        result = bpf.getQuote(start, end.plusDays(12), new RateWithDurationDiscounts());
        assertEquals(600,0 , result.renterCost.doubleValue());
        assertEquals(450,0 , result.ownerEarnings.doubleValue());
        
        // Test for 14 days => weekly discount
        result = bpf.getQuote(start, end.plusDays(14), new RateWithDurationDiscounts());
        assertEquals(630,0 , result.renterCost.doubleValue());
        assertEquals(472,5 , result.ownerEarnings.doubleValue());
        
        // Test for 61 days => monthly discount
        result = bpf.getQuote(start, end.plusDays(61), new RateWithDurationDiscounts());
        assertEquals(1500,0 , result.renterCost.doubleValue());
        assertEquals(1125,0 , result.ownerEarnings.doubleValue());
	}

}
