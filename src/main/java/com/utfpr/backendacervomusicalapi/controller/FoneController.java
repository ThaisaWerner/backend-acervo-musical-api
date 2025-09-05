package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Fone;
import com.utfpr.backendacervomusicalapi.service.FoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fones")
public class FoneController {

    @Autowired
    FoneService foneService;

    @GetMapping
    public ResponseEntity<List<Fone>> getAll() {
        List<Fone> foneList = foneService.listar();
        if (foneList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(foneList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fone> getOne (@PathVariable(value="id") Long id) {
        Optional<Fone> foneFound = foneService.encontrar(id);
        return foneFound.map(fone -> new ResponseEntity<>(fone, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fone> update(@PathVariable(value="id") Long id, @RequestBody Fone foneUpdated) {
        Optional<Fone> foneOld = foneService.encontrar(id);

        if (foneOld.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            foneUpdated.setId(foneOld.get().getId());
            if (foneService.salvar(foneUpdated) != null) {
                return new ResponseEntity<>(foneUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PostMapping
    public ResponseEntity<Fone> create(@RequestBody Fone fone) {
        Fone foneCreated = foneService.salvar(fone);

        if (foneCreated != null) {
            return new ResponseEntity<>(foneCreated, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
