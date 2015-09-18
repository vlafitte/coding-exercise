import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;


public class BestPriceFounder implements BasicPricer, PricerWithDurationDiscounts {
	
	// GetQuote method implemented on basic rate
	public BasicQuote getQuote(ZonedDateTime start, ZonedDateTime end,
			BasicRate rate) {

		BasicQuote bqResult;
		  
		// Time interval between the end date and the start date
		DateTime startDate = new DateTime(start.getYear(), start.getMonthValue(), start.getDayOfMonth(), start.getHour(), start.getMinute());
		DateTime endDate = new DateTime(end.getYear(), end.getMonthValue(), end.getDayOfMonth(), end.getHour(), end.getMinute());		  
		Period p = new Period(startDate, endDate);
		
		// Price calcul 
		BigDecimal clientPrice = rate.monthly.multiply(BigDecimal.valueOf(p.getMonths()));
		clientPrice = clientPrice.add(rate.weekly.multiply(BigDecimal.valueOf(p.getWeeks())));
		clientPrice = clientPrice.add(rate.daily.multiply(BigDecimal.valueOf(p.getDays())));
		
		bqResult = new BasicQuote(clientPrice);
		
		return bqResult;
	}

	// GetQuote method implemented with duration discount rate
	public BasicQuote getQuote(ZonedDateTime start, ZonedDateTime end,
			RateWithDurationDiscounts rate) {
		
		// Time interval between the end date and the start date
		DateTime startDate = new DateTime(start.getYear(), start.getMonthValue(), start.getDayOfMonth(), start.getHour(), start.getMinute());
		DateTime endDate = new DateTime(end.getYear(), end.getMonthValue(), end.getDayOfMonth(), end.getHour(), end.getMinute());		  
		Period p = new Period(startDate, endDate);
		Duration dur = new Duration(startDate, endDate);
		
		// Price calcul 
		BigDecimal basePrice = rate.daily.multiply(BigDecimal.valueOf(dur.getStandardDays()));
		BigDecimal finalPrice =basePrice;
		
		if (p.getDays() == 0) {
			// Monthly discount => 1 or 2 ... months and no more days or no more week
			if (p.getMonths() > 0 && p.getWeeks() == 0) {
				finalPrice = finalPrice.subtract(basePrice.multiply(rate.monthlyDiscount));
			}
			
			// Weekly discount
			if (p.getMonths() == 0 && p.getWeeks() > 0) {
				finalPrice = finalPrice.subtract(basePrice.multiply(rate.weeklyDiscount));
			}
		}

		BasicQuote bqResult = new BasicQuote(finalPrice);
		return bqResult;
	}
}
