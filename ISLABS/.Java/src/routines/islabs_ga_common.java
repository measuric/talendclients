package routines;

import java.util.Calendar;
import java.util.Date;

public class islabs_ga_common {

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
	
	public static Date lastWeekStartDate(Date date)
	{
		Calendar cal  = Calendar.getInstance();
		cal.setTime(date);
		int currentDay = cal.get(Calendar.DAY_OF_WEEK);	
		if(currentDay==1)
		{
			cal.add(Calendar.DATE,-13);
		}
		else
		{
		cal.add(Calendar.DATE, 0-(5+currentDay));
		}
		return cal.getTime();
	}
	
public static String cleanseData(String data)
{	
	return data!=null && data.trim().length()>0?data.replaceAll("\\(not set\\)", "direct").replaceAll("\\(none\\)", "direct").replaceAll("organics","organic").replaceAll("referrals","referral"):"";
}

public static String cleanseMediumData(String medium)
{	

	if("(not set)".equalsIgnoreCase(medium))
		return "campaign";
	else if("(none)".equalsIgnoreCase(medium))
		return "direct";
	else if("organic".equalsIgnoreCase(medium))
		return "search";
	else if("referral".equalsIgnoreCase(medium))
		return "referral";
	else 
		return "campaign";

}

public static Integer zeroIfNull(Integer value)
{
	return value!=null?value:0;
}

public static Float zeroIfNull(Float value)
{
	return value!=null?value:0;
}
public static String IfNull(String value)
{
	return value!=null && value.trim().length()>0?value:null;
}

public static Boolean isDateParsable(String date,String pattern)
{
	Date parseDate;
	
	try
	{
		parseDate=TalendDate.parseDate(pattern, date);
		return true;
	}
	catch(Exception e)
	{
	  return false;	
	}
	
}
}

