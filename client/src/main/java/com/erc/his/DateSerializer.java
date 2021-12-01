package com.erc.his;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateSerializer implements JsonSerializer<Date> {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
		long value = date.getTime();
		String stringValue = String.valueOf(value);
		return new JsonPrimitive(stringValue);
	}
}