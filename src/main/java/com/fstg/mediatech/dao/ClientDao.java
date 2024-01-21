package com.fstg.mediatech.dao;

import com.fstg.mediatech.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDao extends JpaRepository<ClientEntity,Integer> {
    ClientEntity findByNom(String nom);
}
