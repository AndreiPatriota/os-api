package com.drei.os.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drei.os.dtos.TecnicoDTO;
import com.drei.os.services.TecnicoService;

@RestController
@RequestMapping(value = "/tecnicos")
public class TecnicoController {
    @Autowired
    private TecnicoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
        var umTecnicoDTO = new TecnicoDTO(service.findById(id));
        return ResponseEntity.ok().body(umTecnicoDTO);
    }

    @GetMapping
    public ResponseEntity<List<TecnicoDTO>> findAll() {
        var listadeTecnicosDTOS = service.findAll()
                .stream()
                .map(umTecnico -> new TecnicoDTO(umTecnico))
                .collect(Collectors.toList());

        return ResponseEntity.ok().body(listadeTecnicosDTOS);
    }

}