package com.crz.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

	public String getNowDate(){
		String DateNow = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
		return DateNow;
	}

	public String getDate(){
		String DateNow = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		return DateNow;
	}
}
