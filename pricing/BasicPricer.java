import java.time.ZonedDateTime;

public interface BasicPricer {
	
    BasicQuote getQuote(ZonedDateTime start, ZonedDateTime end, BasicRate rate);
}
