package com.fstg.mediatech.service;

import com.fstg.mediatech.dao.ProduitDao;
import com.fstg.mediatech.dto.ClientResponseDto;
import com.fstg.mediatech.dto.ProduitDto;
import com.fstg.mediatech.model.ProduitEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService{
    private final ProduitDao produitDao;
    private final ModelMapper modelMapper;
    @Override
    public ProduitDto save(ProduitDto produitDto) {
        if(produitDao.findByRef(produitDto.getRef()) != null) return null;
        else {
            ProduitEntity produit=modelMapper.map(produitDto,ProduitEntity.class);
            ProduitEntity savedProd=produitDao.save(produit);
            return modelMapper.map(savedProd,ProduitDto.class);

        }

    }

    @Transactional
    @Override
    public int delete(String ref) {
        return produitDao.deleteByRef(ref);
    }

    @Override
    public ProduitDto update(ProduitDto produit) {
        Optional<ProduitEntity> produitEntity = produitDao.findByRef(produit.getRef());
        if (produitEntity.isEmpty()) return null;
        update(produitEntity.get(), produit);
        ProduitEntity saved = produitDao.save(produitEntity.get());
        return modelMapper.map(saved, ProduitDto.class);
    }
    private void update(ProduitEntity produitEntity, ProduitDto produitDto) {
        produitEntity.setLibelle(produitDto.getLibelle());
        produitEntity.setPrix(produitDto.getPrix());
        produitEntity.setQuantite_stock(produitDto.getQuantiteStock());
    }
    @Override
    public ProduitDto findByref(String ref) {
        Optional<ProduitEntity> produitEntity=produitDao.findByRef(ref);
        if (produitEntity==null) return null;
        return modelMapper.map(produitEntity,ProduitDto.class);
    }

    @Override
    public List<ProduitDto> findAll() {
        return produitDao.findAll().stream().map(
                el ->modelMapper.map(el, ProduitDto.class)
        ).collect(Collectors.toList());
    }
}
