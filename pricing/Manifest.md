1. Documentation about each method.

public class BestPriceFounder 
implements BasicPricer, PricerWithDurationDiscounts

This class will find the best price according to the dates and the basic or discount prices given by the owner
This class implements the two prices interfaces. So, it contains the implementation of the two differents GetQuote class. 

A - public BasicQuote getQuote(ZonedDateTime start, ZonedDateTime end,BasicRate rate)
 	
 	This method will return the best price regarding their three parameters :
 		- beginning date
 		- end date
 		- the Basic Rate
 		
 	By default the basic rate constructor will use the same rate as written in the readme file. But it also be customized by an other constructor containing all the fields.
 	Beginning date and end date will be used to calculate the duration location of the car (nb : we always consider that end is greater than start date).
 	To calculate this information, we used the period class defined by JodaTime libray, this object will give us the number of months, of weeks and days. 
 	After we apply every each rate with the corresponding number of periods to obtain the final price.

B - public BasicQuote getQuote(ZonedDateTime start, ZonedDateTime end, RateWithDurationDiscounts rate)
 	
 	This method will return the best price regarding their three parameters :
 		- beginning date
 		- end date
 		- the Rate With Duration Discounts
 		
 	For the rate with duration discount, we applied the same principle as for the basic rate, by default the constructor will use the readme file values. 
 	An other constructor is also available to personalize them.
 	Beginning date and end date will be used to calculate the duration location of the car (nb : we always consider that end is greater than start date).
 	To calculate this information, I used the period class and the duration class defined by JodaTime library. 
 	The duration class give the total numbers of the days, the user wants to rent the car. We multiply by the daily rate.
 	After the period gives us the number of months, weeks and days. 
 	To have a monthly or a weekly discount, the user will have to rent the car exactly one or two month(s), or one or two or three weeks. 
 	
 	
 	
 2- To solve this case, I chose to include the Joda-Time library because it was very helpfull to calculate the number of the days, of weeks and months and he handles every special case, like the number of the days by month. 
 	About each method, I made to differnents methods. In the first one, the basic rate I choose to apply the price case by case, this method will give the best price for the 	renter. Although, in the second one, I chose to only have one discount by rent. So if the renter keep the car car one more day, his rate will very be more expensive bacause he will loose his weekly or monthly discount. 
 	 
 	