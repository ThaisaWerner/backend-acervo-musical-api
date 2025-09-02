package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
}
