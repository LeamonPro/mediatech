package com.fstg.mediatech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="roles")
public class RoleEntity implements Serializable {
    @Id
    private Integer roleId;
    @Column(nullable = false)
    private String nom;
    @ManyToMany
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(
            name="roleId"), inverseJoinColumns = @JoinColumn(name="userId")
    )
    private List<UserEntity> users;

}
