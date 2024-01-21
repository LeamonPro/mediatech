package com.fstg.mediatech.controller;

import com.fstg.mediatech.dto.ClientRequestDto;
import com.fstg.mediatech.dto.ClientResponseDto;
import com.fstg.mediatech.exception.EntityNotFoundException;
import com.fstg.mediatech.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientControler {
    @Autowired
    private ClientService clientService;
    @GetMapping("")
    public ResponseEntity<List<ClientResponseDto>> getClients(){
        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<ClientResponseDto> saveClient(@Valid @RequestBody() ClientRequestDto client){
        return new ResponseEntity<>(clientService.save(client),HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable("id") Integer id) throws EntityNotFoundException {
        return new ResponseEntity<>(clientService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<ClientResponseDto> findByNom(@PathVariable("nom") String nom) {
        return new ResponseEntity<>(clientService.findByNom(nom),HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> update(@RequestBody() ClientRequestDto clientRequestDto,@PathVariable("id") Integer id) throws EntityNotFoundException {
        return new ResponseEntity<>(clientService.update(clientRequestDto, id),HttpStatus.ACCEPTED);
    }
}
