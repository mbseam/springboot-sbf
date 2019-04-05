package com.mb.sbf.io.res;

import lombok.Data;

import java.sql.Date;

@Data
public class CategoryResponse extends BaseResponse {

	private Long categoryId;
	private String name;
	private Date lastUpdate;
}
