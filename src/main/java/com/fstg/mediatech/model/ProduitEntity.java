package com.fstg.mediatech.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="produits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitEntity implements Serializable {
    private static long serialVersionUID=-7275079172834495736L;
    @Id()
    private int id;
    @Column(nullable = false)
    private String libelle;
    @Column(nullable = false)
    private String ref;
    @Column(nullable = false)
    private BigDecimal prix;
    @Column(nullable = false)
    private double quantite_stock;

    @OneToMany(mappedBy = "produit",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<LigneFactureEntity> ligneFactures;
}
