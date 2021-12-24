package com.mb.sbf.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name = "category_id")
	private Long categoryId;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdate;

	@ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
	private Set<Film> films = new HashSet<>();
}
