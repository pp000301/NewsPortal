package com.valerii.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "role_users", schema = "news_portal")
public class RoleUsers extends BaseEntity<Long> {
    @Column(name = "role")
    private String role;

    @OneToOne
    @JoinColumn(name = "users_id")
    private Users userRole;

}
