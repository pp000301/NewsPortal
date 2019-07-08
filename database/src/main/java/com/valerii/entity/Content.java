package com.valerii.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Builder
@Embeddable

public class Content {
    @Column(name = "content")
    private String content;
    @Column(name = "created_date")
    private LocalDateTime created_date;
}
