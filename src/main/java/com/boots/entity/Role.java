package com.boots.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column(name = "role_id")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
