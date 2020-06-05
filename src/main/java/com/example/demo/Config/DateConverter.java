package com.example.demo.Config;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.core.convert.converter.Converter;
import com.mysql.cj.util.StringUtils;

public class DateConverter  implements Converter<String, Date> {
	private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
	private static final String shortDateFormat = "yyyy-MM-dd";
	private static final String dateFormat2 = "yyyy/MM/dd HH:mm:ss";
	private static final String shortDateFormat2 = "yyyy/MM/dd";

	@Override
	public Date convert(String source) {
		if (source == null) {
			return null;
		}
		source = source.trim();
		try {
			SimpleDateFormat formatter;
			if (source.contains("-")) {
				if (source.contains(":")) {
					formatter = new SimpleDateFormat(dateFormat);
				} else {
					formatter = new SimpleDateFormat(shortDateFormat);
				}
				Date dtDate = formatter.parse(source);
				return dtDate;
			} else if (source.contains("/")) {
				if (source.contains(":")) {
					formatter = new SimpleDateFormat(dateFormat2);
				} else {
					formatter = new SimpleDateFormat(shortDateFormat2);
				}
				Date dtDate = formatter.parse(source);
				return dtDate;
			}
		} catch (Exception e) {
			throw new RuntimeException(String.format("parser %s to Date fail", source));
		}

		throw new RuntimeException(String.format("parser %s to Date fail", source));

	}

}