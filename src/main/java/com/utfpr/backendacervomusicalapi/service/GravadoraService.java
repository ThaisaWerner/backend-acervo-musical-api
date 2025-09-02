package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.repository.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GravadoraService {

    @Autowired
    private GravadoraRepository gravadoraRepository;
}
