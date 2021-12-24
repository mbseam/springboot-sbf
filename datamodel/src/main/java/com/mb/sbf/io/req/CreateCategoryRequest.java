package com.mb.sbf.io.req;

import lombok.*;

import javax.persistence.Entity;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryRequest extends BaseRequest {

	private String name;

}
