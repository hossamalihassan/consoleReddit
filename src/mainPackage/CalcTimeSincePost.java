package mainPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CalcTimeSincePost {
	

	public static String calcAge() {
		StringBuilder timeBuilder = new StringBuilder();
		
		List<String> post_info = ViewPosts.allPosts.get(ViewPosts.post_index);
	    String[] get_post_info_arr = new String[post_info.size()];
		get_post_info_arr = post_info.toArray(get_post_info_arr);
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.ENGLISH);
		
		try {		
		    Date now = new Date();
		    String nowDate = sdf.format(now);
		    
			Date firstDate = sdf.parse(get_post_info_arr[5]);
		    Date secondDate = sdf.parse(nowDate);
		    
		    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
		    
			long daysDiff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			long hoursDiff = TimeUnit.HOURS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			long minsDiff = TimeUnit.MINUTES.convert(diffInMillies, TimeUnit.MILLISECONDS);
			
			
			if(daysDiff > 0 && daysDiff < 365) {
				timeBuilder.append(daysDiff + "d ");
			}
			if(hoursDiff > 0 && hoursDiff < 24) {
				timeBuilder.append(hoursDiff + "h ");
			}
			if(minsDiff < 60 && minsDiff >= 0 && hoursDiff == 0) {
				if(minsDiff == 0) 
					timeBuilder.append("seconds ");
				else
					timeBuilder.append(minsDiff + "m ");
			}
			if(daysDiff > 365) {
				timeBuilder.append((daysDiff / 365) + "y ");
			}
				
			timeBuilder.append("ago");
			
			return timeBuilder.toString();
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
