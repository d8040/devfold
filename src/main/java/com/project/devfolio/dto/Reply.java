package com.project.devfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
	private int id;
	private String regDate;
	private String updateDate;
	private String relTypeCode; /* ëę¸ ěěš(ex. article, reply, potfolio...) */ 
	private int relId;
	private int memberId;
	private String body;
}
