package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.repository.GravacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GravacaoService {

    @Autowired
    private GravacaoRepository gravacaoRepository;
}
