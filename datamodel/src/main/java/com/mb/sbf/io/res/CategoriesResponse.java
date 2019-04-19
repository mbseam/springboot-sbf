package com.mb.sbf.io.res;

import com.mb.sbf.dto.CategoryDto;
import com.mb.sbf.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoriesResponse extends BaseResponse {

	private List<CategoryDto> categories = new ArrayList<>();
}
