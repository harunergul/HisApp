package com.erc.his.enums;

import java.util.ArrayList;
import java.util.List;

public enum MaritalStatus {
	SINGLE(1L, "SINGLE"), MARRIED(2L, "MARRIED");

	private Long id;
	private String name;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	private MaritalStatus(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public static String getSelectedById(Long _id) {
		for (MaritalStatus item : MaritalStatus.values()) {
			if (_id.equals(item.getId())) {
				return item.getName();
			}
		}
		return null;
	}

	public static Long getSelectedByName(String _name) {
		for (MaritalStatus item : MaritalStatus.values()) {
			if (_name.equals(item.getName())) {
				return item.getId();
			}
		}
		return null;
	}

	public static List<String> getAll() {
		List<String> gg = new ArrayList<>();
		for (MaritalStatus item : MaritalStatus.values()) {
			gg.add(item.getName());
		}
		return gg;
	}

	@Override
	public String toString() {
		return name;
	}
}
