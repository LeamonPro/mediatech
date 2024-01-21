package com.fstg.mediatech.model;

import jakarta.persistence.*;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Table(name="ligne_facture")
@ToString
public class LigneFactureEntity implements Serializable {
    private static final long serielVersionUID=-3181735183192870271L;
    @EmbeddedId
    private LigneFactureKey id;

    @ManyToOne()
    @MapsId("produitId")
    @JoinColumn(name="produit_id")
    private ProduitEntity produit;
    @ManyToOne()
    @MapsId("factureId")
    @JoinColumn(name="facture_id")
    private FactureEntity facture;

    private double quantite;
}
