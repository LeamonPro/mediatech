package com.fstg.mediatech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_profile")
public class UserProfile implements Serializable {
    @Id
    private Integer id;
     private String avatar;
     private String telephone;

     @OneToOne
     @JoinColumn(name="user_id")
    private UserEntity user;
}
