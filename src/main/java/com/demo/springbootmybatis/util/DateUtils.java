package com.demo.springbootmybatis.util;

import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    private static final SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
    private static final SimpleDateFormat datedf = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
    
    public static final String STANDARD_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";

	public static final String STANDARD_DATE_FORMAT_STR = "yyyy-MM-dd";
    
    private static final String[] GENERIC_DATE_PATTERNS = {
    		STANDARD_DATE_TIME_FORMAT_STR,STANDARD_DATE_FORMAT_STR};
	/**
	 * 得到传入日期n天后的日期,如果传入日期为null，则表示当前日期n天后的日期
	 *
	 * @author
	 * @param Date
	 *            dt
	 * @param days
	 *            可以为任何整数，负数表示前days天，正数表示后days天
	 * @return Date
	 */
	public static Date getAddDayDate(Date dt, int days) {
		if (dt == null)
			dt = new Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + days);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
    
    /***************************************************************************
	 * 得到传入日期所在月的结束时间，如果传入日期为null，则表示当前日期n天后的日期
	 *
	 * @author
	 * @param dt
	 * @return Date
	 */
	public static Date getMonthEndTime(Date dt) {
		if (dt == null)
			dt = new Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, -1);
		return cal.getTime();
	}

    /***************************************************************************
	 * 得到传入日期所在月的开始时间，如果传入日期为null，则表示当前日期n天后的日期
	 *
	 * @author
	 * @param dt
	 * @return Date
	 */
	public static Date getMonthBeginTime(Date dt) {
		if (dt == null)
			dt = new Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/***************************************************************************
	 * 得到传入年月所在月的开始时间
	 *
	 * @author
	 * @param year
	 * @param month
	 * @return Date
	 */
	public static Date getMonthBeginTime(int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
    
    /**
     * 获取指定时间的前一天
     * @param date
     * @return
     */
    public static Date getPreDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}
    
    /**
     * 获取指定时间的前一天
     * @param date
     * @return
     */
    public static Date getNextDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}
    /**
     * 获取当前时间的前一天
     * @param date
     * @return
     */
    public static Date getNowPreDay() {
    	Date date=new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date = calendar.getTime();
		return date;
	}
    /**
     * 获取指定时间的后一天
     * @param date
     * @return
     */
    public static Date getNowNextDay() {
    	Date date=new Date(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		date = calendar.getTime();
		return date;
	}
    
    /**
     * 获取今天的日期
     * @return
     */
	public static String getToday() {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		return fmt.format(today);
	}
	
	/*
	 * 获取当天实际并格式化
	 */
	public static String getToday(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		Date today = cal.getTime();
		SimpleDateFormat fmt = new SimpleDateFormat(dateFormat);
		return fmt.format(today);
	}

    public static Date parse(String strDate, String suffix) {
        if (StringUtils.isBlank(strDate))
            return null;
        try {
            if (strDate.length()<=10)
                return sdf.parse(strDate.concat(" ").concat(suffix));
            else
                return sdf.parse(strDate.substring(0,10).concat(" ").concat(suffix));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Date parseFormat(String strDate, String format) {
        if (StringUtils.isBlank(strDate))
            return null;
        try {
        	 SimpleDateFormat sdf = new SimpleDateFormat(format);  
        	 Date date = sdf.parse(strDate);  
        	 return date;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parse(Timestamp time) {
        if (time == null)
            return "";
        return sdf.format(time);
    }

    public static String parse(Timestamp time , SimpleDateFormat format) {
        if (time == null)
            return "";
        return format.format(time);
    }
	public static String formatDate(Date dt,String format) {
		if (dt == null)
			return null;
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		return fmt.format(dt);
	}


    public static String parse(Long time) {
        return df.format(time);
    }

    public static Timestamp now(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp time(long days) {
        return new Timestamp(System.currentTimeMillis() + days*24*60*60*1000);
    }

    public static Timestamp getBeginOfToday(){
        String nowString =  parse(now(),new SimpleDateFormat("yyyy-MM-dd 00:00:00", Locale.CHINA)) ;
        return Timestamp.valueOf(nowString);
    }
    
    public static Timestamp getEndOfToday(){
        String nowString =  parse(now(),new SimpleDateFormat("yyyy-MM-dd 23:59:59", Locale.CHINA)) ;
        return Timestamp.valueOf(nowString);
    }

    /**
     * 将日期转换为字符串，格式为：yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static synchronized String convertToDateTime(Date date) {
        try {

            return sdf.format(date);
        }catch (Exception e) {
            return null;
        }
    }

    /**
     * 字符串转换成日期类型，格式为：yyyy-MM-dd HH:mm:ss
     * @param date
     * @return
     */
    public static synchronized Date parseToDateTime(String date) {
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            return null;
        }
    }

    public static boolean compare(Date now, long greaterThan, long pass){
        if(now == null){
            return false;
        }
        return now.getTime() - pass > greaterThan;
    }
    
    /**
	 * 得到两个时间相差多少天，不足一天算一天
	 *
	 * @param beginDate
	 * @param endTime
	 * @return
	 */
	public static int getDateMargin(Date beginDate, Date endDate) {
		if (endDate == null)
			endDate = new Date();
		final int mOfDay = 1000 * 60 * 60 * 24;
		final long divtime = (endDate.getTime() - beginDate.getTime());
		final long lday = divtime % mOfDay > 0 ? divtime / mOfDay + 1 : divtime
				/ mOfDay;
		return Long.valueOf(lday).intValue();
	}

	/**
	 * 得到当前时间和指定时间的小时差,不足一小时按小时算
	 *
	 * @param date
	 * @return
	 */
	public static long getHourMargin(Date beginDate, Date endDate) {
		if (endDate == null)
			endDate = new Date();
		long hour = endDate.getTime() - beginDate.getTime();
		hour = hour / (60 * 60 * 1000);
		hour = hour % (60 * 60 * 1000) > 0 ? hour + 1 : hour;
		return hour;
	}

	/**
	 * 得到两个时间相差多少分钟,不足一分钟按一分钟算
	 *
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public static int getMinuteMargin(Date beginDate, Date endDate) {
		if (endDate == null)
			endDate = new Date();
		final int mOfMinute = 1000 * 60;
		final long divtime = (endDate.getTime() - beginDate.getTime());
		final long lminute = divtime % mOfMinute > 0 ? divtime / mOfMinute + 1
				: divtime / mOfMinute;
		return Long.valueOf(lminute).intValue();
	}

  /**
   * 字符串转换成日期类型，格式为：yyyy-MM-dd
   * @param date
   * @return
   */
	public static java.sql.Date parseDate(String dateString) {
		return new java.sql.Date(parseToDateTime(dateString).getTime());
	}
	
  public static synchronized Date parseToDate(String date) {
    try {
        return datedf.parse(date);
    } catch (ParseException e) {
        return null;
    }
	}

	public static Timestamp parseTimestampOpt(String str) {
		try {
			if(str == null){
				return null;
			}
			return new Timestamp( org.apache.commons.lang.time.DateUtils.parseDate(str, GENERIC_DATE_PATTERNS).getTime());
		} catch (ParseException e) {
			e.printStackTrace();;
			return null;
		}
	}

  public static Timestamp parseTimestamp(String str) {
    try {
        return new Timestamp( org.apache.commons.lang.time.DateUtils.parseDate(str, GENERIC_DATE_PATTERNS).getTime());
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
	}
	private static String[] weeks = {"周日","周一","周二","周三","周四","周五","周六"};

	private static Calendar calendar = Calendar.getInstance();
	public static String convertTime(String dateStr) {
		Date date = DateUtils.parseToDateTime(dateStr);
		if(date != null) {
			calendar.setTime(date);
			int index = calendar.get(Calendar.DAY_OF_WEEK)-1;
			return dateStr.split(" ")[0] +" "+ weeks[index] + " " + dateStr.split(" ")[1];
		}
		return dateStr;
	}
	/**
	 * 获取日期所在周的周一日期
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getFirstOfWeek(Date date){
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        
        cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        
        return cal.getTime();
	}
	/**
	 * 获取日期所在周的周日的日期
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date getLastOfWeek(Date date){
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        
        cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		

        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        cal.add(Calendar.DAY_OF_WEEK, 6);
        
        //日期+然后减少1秒
        cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.MILLISECOND, -1);
        
        return cal.getTime();

	}
	
	 public static void main(String args[]) throws Exception { 

		Date date=new Date();
         Timestamp timestamp = parseTimestamp("2017-04-23 23:22:11");

         System.out.print( formatDate(getFirstOfWeek(date),"yyyy-MM-dd HH:mm:ss"));
		 System.out.print( formatDate(getLastOfWeek(date),"yyyy-MM-dd HH:mm:ss")); 		 		 
		 System.out.print( formatDate(getMonthBeginTime(date),"yyyy-MM-dd HH:mm:ss"));
		 System.out.print( formatDate(getMonthEndTime(date),"yyyy-MM-dd HH:mm:ss")); 		 		 

	 }
}
