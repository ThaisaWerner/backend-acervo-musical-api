package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Pessoa;
import com.utfpr.backendacervomusicalapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAll() {
        List<Pessoa> pessoaList = pessoaService.listar();
        if (pessoaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(pessoaList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getOne(@PathVariable(value="id") Long id) {
        Optional<Pessoa> pessoaFound = pessoaService.encontrar(id);
        return pessoaFound.map(pessoa -> new ResponseEntity<>(pessoa, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable(value="id") Long id, @RequestBody Pessoa pessoaUpdated) {
        Optional<Pessoa> pessoaOld = pessoaService.encontrar(id);

        if (pessoaOld.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            pessoaUpdated.setId(pessoaOld.get().getId());
            if (pessoaService.salvar(pessoaUpdated) != null) {
                return new ResponseEntity<>(pessoaUpdated, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    }
}
