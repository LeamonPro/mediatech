package com.fstg.mediatech.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name="factures")
@ToString
public class FactureEntity implements Serializable {
    @Id()
    private int id;
    @Column(nullable = false)
    private String ref;
    @Column(nullable = false,name="date_creation_facture")
    private Date date;
    @ManyToOne()
    private ClientEntity client;

    @OneToMany(mappedBy = "facture",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<LigneFactureEntity> ligneFactures;
}
