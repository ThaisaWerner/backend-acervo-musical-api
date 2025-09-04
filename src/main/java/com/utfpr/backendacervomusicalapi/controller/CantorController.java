package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Cantor;
import com.utfpr.backendacervomusicalapi.service.CantorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cantores")
public class CantorController {

    @Autowired
    CantorService cantorService;

    @GetMapping
    public ResponseEntity<List<Cantor>> getAll() {
        List<Cantor> cantorList = cantorService.listar();
        if (cantorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(cantorList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cantor> getOne(@PathVariable(value="id") Long id) {
        Optional<Cantor> cantorFound = cantorService.encontrar(id);
        return cantorFound.map(cantor -> new ResponseEntity<>(cantor, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cantor> update(@PathVariable(value="id") Long id, @RequestBody Cantor cantorUpdated) {
        Optional<Cantor> cantorOld = cantorService.encontrar(id);

        if (cantorOld.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            cantorUpdated.setId(cantorOld.get().getId());
            if(cantorService.salvar(cantorUpdated) != null) {
                return new ResponseEntity<>(cantorUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
