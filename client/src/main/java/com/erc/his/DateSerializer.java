package com.erc.his;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateSerializer implements JsonSerializer<Date> {
	
	public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
		long value = date.getTime();
		String stringValue = String.valueOf(value);
		return new JsonPrimitive(stringValue);
	}
}