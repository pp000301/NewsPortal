package com.valerii.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "news", schema = "news_portal")

public class News extends BaseEntity<Long> {

    @Column(name = "title")
    private String title;

    @Column(name = "count_coments")
    private Long count_coments;

    @Embedded
    private Content content;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ToString.Exclude
    @OneToMany(mappedBy = "news")
    private List<Comments> comments = new ArrayList<>();

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "mm_news_news_category", schema = "news_portal",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "news_category_id"))
    private List<Category_news> category_news = new ArrayList<>();
}
