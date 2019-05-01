package com.mb.sbf.io.res;

import com.mb.sbf.dto.CategoryDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoriesResponse extends BaseResponse {

	private List<CategoryDto> categories = new ArrayList<>();
}
