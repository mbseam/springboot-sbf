package com.mb.sbf.io.res;

import com.mb.sbf.model.Category;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListCategoryResponse extends BaseResponse {
	private List<Category> categories = new ArrayList<Category>();
}
