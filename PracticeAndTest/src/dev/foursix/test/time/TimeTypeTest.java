package dev.foursix.test.time;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeTypeTest {
	
	public TimeTypeTest() {		
//		Time time = new Time(System.currentTimeMillis());		
//		System.out.println(time);
//		
//		Date date = new Date(System.currentTimeMillis());		
//		System.out.println(date);
//		
//		SimpleDateFormat sdf = new SimpleDateFormat();		
//		System.out.println(sdf.format(date));
//		System.out.println(sdf.toPattern());
//		
//		String str = sdf.format(date);
//		
//		SimpleDateFormat sdff = new SimpleDateFormat();
//		try {
//			java.util.Date datee = sdff.parse(str);
//			System.out.println(datee);
//			
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		///////////////////////////////////////////////////////
//		
//		java.util.Date datetime = new java.util.Date();
//		datetime.setTime(System.currentTimeMillis());
//		System.out.println(datetime);	
//		
//		String dtime = datetime.toString();
//		
//		try {
//			java.util.Date datetimeR = DateFormat.getDateTimeInstance().parse(dtime);
//			System.out.println(datetimeR);//
//		} catch (ParseException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//			
//		Calendar cal= Calendar.getInstance();			
//		System.out.println("[" + cal.getTime().toString() + "]");}
//		
//		SimpleDateFormat datetimeform = new SimpleDateFormat();
////		SimpleDateFormat datetimeform = new SimpleDateFormat("EEE MMM dd hh:mm:ss zzz yyyy");
//		try {
//			System.out.println(datetimeform.toPattern());
//			datetimeform.applyPattern("EEE MM dd hh:mm:ss.SSS z yyyy");
//			System.out.println(datetimeform.toPattern());
//			
//			System.out.println(datetimeform.format(date));
//			String daform = datetimeform.format(date);			
//			
//			java.util.Date datetime2 = datetimeform.parse(daform);
//			System.out.println(datetime2);
//			
//			System.out.println(date.getTime());
//			System.out.println(datetime2.getTime());
//			
//			
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		datetimeConvert();
	}

	private void datetimeConvert() {
		Date datetime = new Date(System.currentTimeMillis());
		System.out.println("String:" + datetime + " long:" + datetime.getTime());
		
		SimpleDateFormat siFormat = new SimpleDateFormat();
		siFormat.applyPattern("yyyy/MM/dd HH:mm:ss.SSS");
		
		String strDatetime = siFormat.format(datetime);
		System.out.println(strDatetime);
		
		try {
			Date datetime2 = siFormat.parse(strDatetime);
			System.out.println("String:" + datetime2 + " long:" + datetime2.getTime());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
