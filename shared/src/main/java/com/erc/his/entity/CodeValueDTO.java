package com.erc.his.entity;

import java.io.Serializable;

public class CodeValueDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codeValueId;
	private Long codeDefinitionId;
	private String code;
	private String description;
	private String active;
	private String status;

	public Long getCodeValueId() {
		return codeValueId;
	}

	public void setCodeValueId(Long codeValueId) {
		this.codeValueId = codeValueId;
	}

	public Long getCodeDefinitionId() {
		return codeDefinitionId;
	}

	public void setCodeDefinitionId(Long codeDefinitionId) {
		this.codeDefinitionId = codeDefinitionId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

}
