package com.mb.sbf.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Data
public class Film extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="film_id")
	private Long filmId;

	private String description;

	private String fulltext;

	@Column(name="language_id")
	private Integer languageId;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	private Integer length;

	private String rating;

	@Column(name="release_year")
	private Integer releaseYear;

	@Column(name="rental_duration")
	private Integer rentalDuration;

	@Column(name="rental_rate")
	private BigDecimal rentalRate;

	@Column(name="replacement_cost")
	private BigDecimal replacementCost;

	@Column(name = "special_features")
	private String specialFeatures;

	private String title;
}