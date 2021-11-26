package com.erc.his.enums;

import java.util.ArrayList;
import java.util.List;

public enum BloodGroup {
	APOZITIF("ARH(+)", "A RH(+) "), ANEGATIF("ARH(-)", "A RH(-)"), BPOZITIF("BRH(+)", "B RH(+) "),
	BNEGATIF("BRH(-)", "B RH(-) "), OPOZITIF("0RH(+)", "0 RH(+) "), ONEGATIF("0RH(-)", "0 RH(-) "),
	ABPOZITIF("ABRH(+)", "AB RH(+) "), ABNEGATIF("ABRH(-)", "AB RH(-)");

	private String id;
	private String name;

	public String getName() {
		return name;
	}

	private BloodGroup(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public static String getSelectedById(String _id) {
		for (BloodGroup item : BloodGroup.values()) {
			if (_id.equals(item.id)) {
				return item.getName();
			}
		}
		return null;
	}

	public static String getSelectedByName(String _name) {
		for (BloodGroup item : BloodGroup.values()) {
			if (_name.equals(item.getName())) {
				return item.id;
			}
		}
		return null;
	}

	public static List<String> getAll() {
		List<String> gg = new ArrayList<>();
		for (BloodGroup item : BloodGroup.values()) {
			gg.add(item.getName());
		}
		return gg;
	}

	@Override
	public String toString() {
		return name;
	}
}
