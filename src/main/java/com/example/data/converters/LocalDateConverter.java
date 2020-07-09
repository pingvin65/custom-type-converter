package com.example.data.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class LocalDateConverter implements Converter<String, LocalDate> {

	/**
	 * Override the convert method
	 * 
	 * @param date
	 * @return LocalDate in BASIC_ISO_DATE
	 */
	@Override
	public LocalDate convert(String date) {
		return LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
	}
}
