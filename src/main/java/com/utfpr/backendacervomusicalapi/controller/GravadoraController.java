package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.service.GravadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gravadoras")
public class GravadoraController {

    @Autowired
    GravadoraService gravadoraService;
}
