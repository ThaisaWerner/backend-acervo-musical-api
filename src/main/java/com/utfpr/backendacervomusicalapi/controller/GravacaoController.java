package com.utfpr.backendacervomusicalapi.controller;

import com.utfpr.backendacervomusicalapi.service.GravacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gravacoes")
public class GravacaoController {

    @Autowired
    GravacaoService gravacaoService;
}
