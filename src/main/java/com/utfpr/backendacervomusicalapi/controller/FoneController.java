package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.entity.Fone;
import com.utfpr.backendacervomusicalapi.service.FoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
