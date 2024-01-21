package com.fstg.mediatech.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitDto {
        private String libelle;
        private String ref;
        private BigDecimal prix;
        private double quantiteStock;
}

