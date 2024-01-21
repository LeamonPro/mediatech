package com.fstg.mediatech.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="clients")
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column (nullable=false)
    private String nom;
    @Column(nullable=false)
    private String prenom;
    @Column(name="client-telephone")
    private String telephone;
    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FactureEntity> factures;

}
