package com.fstg.mediatech.service;

import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;
import com.fstg.mediatech.exception.EntityNotFoundException;

import java.util.List;

public interface ClientService {
    ClientResponseDto save(ClientRequestDto clientRequestDto);
    ClientResponseDto findById(Integer id) throws EntityNotFoundException;
    ClientResponseDto findByNom(String nom);
    void delete(Integer id);
    ClientResponseDto update(ClientRequestDto clientRequestDto,Integer id) throws EntityNotFoundException;
    List<ClientResponseDto> findAll();


}
