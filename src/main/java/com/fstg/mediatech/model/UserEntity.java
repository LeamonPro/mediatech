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
@Table(name="users")
public class UserEntity implements Serializable {
    @Id
    private Integer userId;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password ;
    @ManyToMany
    @JoinTable(name="user_roles", joinColumns = @JoinColumn(
            name="userId"), inverseJoinColumns = @JoinColumn(name="roleId")
    )
    private List<RoleEntity> roles;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private UserProfile profile;
}
