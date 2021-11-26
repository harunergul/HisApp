package com.erc.his.enums;

import java.util.ArrayList;
import java.util.List;

public enum Gender {
	KADIN("F", "Female"), ERKEK("M", "Male"), OTHER("O", "Other");

	private String id;
	private String name;

	public String getName() {
		return name;
	}

	private Gender(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public static String getSelectedById(String _id) {
		for (Gender item : Gender.values()) {
			if (_id.equals(item.id)) {
				return item.name;
			}
		}
		return null;
	}

	public static String getSelectedByName(String _name) {
		for (Gender item : Gender.values()) {
			if (_name.equals(item.getName())) {
				return item.id;
			}
		}
		return null;
	}

	public static List<String> getAll() {
		List<String> gg = new ArrayList<>();
		for (Gender item : Gender.values()) {
			gg.add(item.getName());
		}
		return gg;
	}

	@Override
	public String toString() {
		return name;
	}
}