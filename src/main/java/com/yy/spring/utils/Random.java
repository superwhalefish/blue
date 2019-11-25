package com.yy.spring.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Random {
public String getRand() {
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	String format = sdf.format(date);
	return format;
	
}
}
