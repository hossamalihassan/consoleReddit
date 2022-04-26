package mainPackage;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

public class RedditAge {
	
	static int months;
	static HashMap<String, String> age = DB.age;
	static HashMap<String, String> user = DB.user;
	
	RedditAge() {
		
		LocalDate dbdate = LocalDate.parse(age.get(Login.name));
		LocalDate now = LocalDate.now();
		int day = dbdate.getDayOfMonth();
        Month month = dbdate.getMonth();
        int year = dbdate.getYear();
		LocalDate signed_in_date = LocalDate.of(year, month, day);
		
		
        RedditAge.months = (int) ChronoUnit.MONTHS.between(signed_in_date, now);
		
	}
	
	
}
