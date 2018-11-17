package com.lijj.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by LIJJAI on 2018/11/9.
 */
public final class DateTools {

	private DateTools() {

	}

	// 计算两个日期之间的时间间隔天数，计头不计尾或计尾不计头
	public static int getTwoDateDays(Date date1, Date date2) {
		String fromDate = convertDate(date1);
		String toDate = convertDate(date2);
//        System.out.println(fromDate+"   "+toDate);
		int fromDateYear = Integer.valueOf(fromDate.substring(0, 4));
		int toDateYear = Integer.valueOf(toDate.substring(0, 4));
//        int fromDateMonth=Integer.valueOf(fromDate.substring(5,7));
//        int toDateMonth=Integer.valueOf(toDate.substring(5,7));
//        int fromDateDay=Integer.valueOf(fromDate.substring(8,10));
//        int toDateDay=Integer.valueOf(toDate.substring(8,10));
//        System.out.println(fromDateYear);
//        System.out.println(fromDateMonth);
//        System.out.println(fromDateDay);
//        System.out.println(toDateYear);
//        System.out.println(toDateMonth);
//        System.out.println(toDateDay);
		// 日期间隔分三段，第一段fromDate到年底的间隔days1；第二段第二年到倒数第二年的间隔days2；第三段最后一年第一天到toDate的间隔days3
		int days1 = 0;
		int days2 = 0;
		int days3 = 0;

		// days2
		for (int i = fromDateYear + 1; i < toDateYear; i++) {
			if (isRunNian(i)) {
				days2 += 366;
			} else {
				days2 += 365;
			}
		}
		// days3
		days3 = getDaythInYear(date2);

		// days1
		if (isRunNian(fromDateYear)) {
			days1 = 366 - getDaythInYear(date1);
		} else {
			days1 = 365 - getDaythInYear(date1);
		}

//        System.out.println(days1);
//        System.out.println(days2);
//        System.out.println(days3);
		// 如果两个日期是同一年
		if (fromDateYear == toDateYear) {
			if (isRunNian(fromDateYear)) {
				return days1 + days3 - 366;
			}
			return days1 + days2 + days3 - 365;
		}
		return days1 + days2 + days3;
	}

	// 将日期类型转换成2018-11-22格式
	public static String convertDate(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.format(date);
	}

	// 判断是不是闰年
	public static boolean isRunNian(int year) {
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			return true;
		}
		return false;
	}

	// 计算是一年当中第几天
	public static int getDaythInYear(Date date) {
		int symbol = 0;
		String dateString = convertDate(date);
		int Year = Integer.valueOf(dateString.substring(0, 4));
		int Month = Integer.valueOf(dateString.substring(5, 7));
		int Day = Integer.valueOf(dateString.substring(8, 10));
//        System.out.println(Year);
//        System.out.println(Month);
//        System.out.println(Day);
		for (int i = 1; i < Month; i++) {
			switch (i) {
			case 1:
				symbol += 31;
				break;
			case 2:
				symbol += 28;
				break;
			case 3:
				symbol += 31;
				break;
			case 4:
				symbol += 30;
				break;
			case 5:
				symbol += 31;
				break;
			case 6:
				symbol += 30;
				break;
			case 7:
				symbol += 31;
				break;
			case 8:
				symbol += 31;
				break;
			case 9:
				symbol += 30;
				break;
			case 10:
				symbol += 31;
				break;
			case 11:
				symbol += 30;
				break;
			}
		}
		symbol += Day;
		if (isRunNian(Year)) {
			return symbol + 1;
		}
		return symbol;
	}
}
