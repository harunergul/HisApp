package com.erc.his.entity;

import java.io.Serializable;

public class CodeDefinitionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codeDefinitionId;
	private String codeType;
	private String description;
	private String active;
	private String status;

	public Long getCodeDefinitionId() {
		return codeDefinitionId;
	}

	public void setCodeDefinitionId(Long codeDefinitionId) {
		this.codeDefinitionId = codeDefinitionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

}
