package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Cantor;
import com.utfpr.backendacervomusicalapi.service.CantorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
