package dev.foursix.test.time;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;


public class TimeConvertTest {
	
	public TimeConvertTest() {
		long lint = 2375000000l;
		
		Time time = new Time(lint);		
		System.out.println(time);
		
		Date date = new Date(lint);
		System.out.println(date);
		
//		TimeStamp stamp = new Timestamp(lint);
		
	}

}
