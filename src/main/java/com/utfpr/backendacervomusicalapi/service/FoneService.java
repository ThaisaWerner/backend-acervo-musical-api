package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.repository.FoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoneService {

    @Autowired
    private FoneRepository foneRepository;
}
