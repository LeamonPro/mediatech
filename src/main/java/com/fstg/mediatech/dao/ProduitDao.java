package com.fstg.mediatech.dao;

import com.fstg.mediatech.model.ProduitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProduitDao extends JpaRepository<ProduitEntity,Integer> {
    Optional<ProduitEntity> findByRef(String ref);

    Optional<ProduitEntity> findByLibelle(String libelle);

    List<ProduitEntity> findByPrixGreaterThan(BigDecimal value);

    int deleteByRef(String ref);
}
