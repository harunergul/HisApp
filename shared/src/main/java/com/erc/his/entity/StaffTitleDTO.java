package com.erc.his.entity;

public class StaffTitleDTO extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private Long staffTitleId;
	private String code;
	private String name;
	private String status;

	public Long getStaffTitleId() {
		return staffTitleId;
	}

	public void setStaffTitleId(Long staffTitleId) {
		this.staffTitleId = staffTitleId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
