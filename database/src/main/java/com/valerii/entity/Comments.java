package com.valerii.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "comments", schema = "news_portal")

public class Comments extends BaseEntity<Long> {

    @Embedded
    @AttributeOverride(name = "content", column = @Column(name = "comment_body"))
    private Content content;

    @ManyToOne
    @JoinColumn(name = "comments_news_id")
    private News news;

    @ManyToOne
    @JoinColumn(name = "comments_user_id")
    private Users user;

}
