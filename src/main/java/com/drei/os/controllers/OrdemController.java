package com.drei.os.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drei.os.dtos.OrdemDTO;
import com.drei.os.services.OrdemService;

@RestController
@RequestMapping(value = "/ordens")
public class OrdemController {
    @Autowired
    private OrdemService service;

    @GetMapping(value = "/{inIn}")
    public ResponseEntity<OrdemDTO> findById(@PathVariable Integer inIn) {
        var ordem = service.findById(inIn);
        return ResponseEntity.ok().body(new OrdemDTO(ordem));
    }

    @GetMapping
    public ResponseEntity<List<OrdemDTO>> findAll() {
        var listadeOrdensDTO = service.findAll()
                                .stream()
                                .map(ordem -> new OrdemDTO(ordem))
                                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listadeOrdensDTO);
    }

}