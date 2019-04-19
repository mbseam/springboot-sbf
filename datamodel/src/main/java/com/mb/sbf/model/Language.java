package com.mb.sbf.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Language  extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long languageId;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Set<Film> films = new HashSet<>();
}
