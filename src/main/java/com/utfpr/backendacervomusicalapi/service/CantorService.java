package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.repository.CantorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CantorService {

    @Autowired
    private CantorRepository cantorRepository;
}
