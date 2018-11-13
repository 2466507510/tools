package com.lijj.test;

import java.util.Date;

import com.lijj.tools.DateTools;

/**
 * Created by LIJJAI on 2018/11/9.
 */
public class TestDateTools {
	@SuppressWarnings("deprecation")
	public static void main(String[] a) {
		Date date = new Date();
		date.setYear(2044 - 1900);
		date.setMonth(10);
		date.setDate(20);
//        System.out.println(date);    
//        System.out.println(DateTools.convertDate(new Date()));
		System.out.println(DateTools.getTwoDateDays(new Date(), date));
//        System.out.println(DateTools.getDaythInYear(new Date()));
//        (DateTools.isRunNian(1000));
	}
}
