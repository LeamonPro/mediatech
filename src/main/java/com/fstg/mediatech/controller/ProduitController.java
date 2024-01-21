package com.fstg.mediatech.controller;

import com.fstg.mediatech.dao.ProduitDao;
import com.fstg.mediatech.dto.ProduitDto;
import com.fstg.mediatech.service.ProduitService;
import com.fstg.mediatech.service.ProduitServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;
    @PostMapping("/")
    public ProduitDto save(@RequestBody ProduitDto produitdto) {
        return produitService.save(produitdto);
    }
    @GetMapping("/ref/{ref}")
    public ProduitDto findByref(@PathVariable String ref) {
        return produitService.findByref(ref);
    }
    @GetMapping("/")
    public List<ProduitDto> findAll() {
        return produitService.findAll();
    }
    @DeleteMapping("/ref/{ref}")
    public int delete(@PathVariable String ref) {
        return produitService.delete(ref);
    }

    @PutMapping("/")
    public ProduitDto update(@RequestBody  ProduitDto produit) {
        return produitService.update(produit);
    }
}
