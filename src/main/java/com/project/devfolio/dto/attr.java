package com.project.devfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class attr {
	private int id;
	private String regDate;
	private String updateDate;
	private String relTypeCode; /* 사용처구분(ex. 직군, 태그 등 */ 
	private int relId;
	private String typeCode;
	private String type2Code;
	private String value;
	private String expireDate;
}
