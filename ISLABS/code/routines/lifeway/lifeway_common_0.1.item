package routines;

import java.util.Calendar;
import java.util.Date;

public class lifeway_common {

	public static Date lastDayOfWeek(Date date){  
	Calendar cal  = Calendar.getInstance();
	cal.setTime(date);
	int currentDay = cal.get(Calendar.DAY_OF_WEEK);	
	if(currentDay==1)
	{
		return cal.getTime();
	}
	else
	{
	int leftDays= Calendar.SATURDAY-currentDay+1;
	cal.add(Calendar.DATE, leftDays);	
	return cal.getTime();
	}
	}
}
