package com.mb.sbf.model;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

@Embeddable
@Data
public class FilmCategoryPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("film_id")
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("category_id")
    private Category category;
}
