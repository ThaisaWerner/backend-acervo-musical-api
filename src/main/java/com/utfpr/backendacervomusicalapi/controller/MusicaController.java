package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Musica;
import com.utfpr.backendacervomusicalapi.service.MusicaService;
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
@RequestMapping("/musicas")
public class MusicaController {

    @Autowired
    MusicaService musicaService;

    @GetMapping
    public ResponseEntity<List<Musica>> getAll() {
        List<Musica> musicaList = musicaService.listar();
        if (musicaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(musicaList, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> getOne(@PathVariable(value="id")Long id) {
        Optional<Musica> musicaFound = musicaService.encontrar(id);
        return musicaFound.map(musica -> new ResponseEntity<>(musica, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
