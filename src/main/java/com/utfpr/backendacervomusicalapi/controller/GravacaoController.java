package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Gravacao;
import com.utfpr.backendacervomusicalapi.service.GravacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gravacoes")
public class GravacaoController {

    @Autowired
    GravacaoService gravacaoService;

    @GetMapping
    public ResponseEntity<List<Gravacao>> getAll() {
        List<Gravacao> gravacaoList = gravacaoService.listar();
        if(gravacaoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(gravacaoList, HttpStatus.OK);
        }
    }
}
