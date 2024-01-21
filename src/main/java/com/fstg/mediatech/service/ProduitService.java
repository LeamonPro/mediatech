package com.fstg.mediatech.service;

import com.fstg.mediatech.dao.ProduitDao;
import com.fstg.mediatech.dto.ProduitDto;

import java.util.List;

public interface ProduitService {
    ProduitDto save(ProduitDto produitdto);
    int delete (String ref);
    ProduitDto update(ProduitDto produit);
    ProduitDto findByref(String ref);
    List<ProduitDto> findAll();

}
