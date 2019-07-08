package com.valerii.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "category_news", schema = "news_portal")

public class Category_news extends BaseEntity<Long>{

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(name = "mm_news_news_category", schema = "news_portal",
            joinColumns = @JoinColumn(name = "news_category_id"),
            inverseJoinColumns = @JoinColumn(name = "news_id"))
    private List<News> news =new ArrayList<>();

}
