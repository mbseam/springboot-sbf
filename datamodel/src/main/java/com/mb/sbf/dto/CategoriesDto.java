package com.mb.sbf.dto;

import com.mb.sbf.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CategoriesDto {

    List<CategoryDto> categories = new ArrayList<>();

}
