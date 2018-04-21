package com.unesco.core.entities.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.unesco.core.entities.LongId;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="un_role")
public class Role implements GrantedAuthority, LongId {
    @Id
    @SequenceGenerator(name = "roleSequenceGen", sequenceName = "roleSequenceGen", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roleSequenceGen")
    private long id;
    @Column(unique=true)
    private String role;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return role;
    }
    public void setRoleName(String role) {
        this.role = role;
    }

    public Role(){}
    public Role(String name)
    {
        role = name;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
