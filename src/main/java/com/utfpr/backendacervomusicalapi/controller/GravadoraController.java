package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Gravadora;
import com.utfpr.backendacervomusicalapi.service.GravadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/gravadoras")
public class GravadoraController {

    @Autowired
    GravadoraService gravadoraService;

    @GetMapping
    public ResponseEntity<List<Gravadora>> getAll() {
        List<Gravadora> gravadoraList = gravadoraService.listar();
        if (gravadoraList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(gravadoraList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gravadora> getOne(@PathVariable(value="id") Long id) {
        Optional<Gravadora> gravadoraFound = gravadoraService.encontrar(id);
        return gravadoraFound.map(gravadora -> new ResponseEntity<>(gravadora, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
