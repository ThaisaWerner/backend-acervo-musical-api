package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.entity.Cantor;
import com.utfpr.backendacervomusicalapi.repository.CantorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CantorService {

    @Autowired
    private CantorRepository cantorRepository;

    public List<Cantor> listar() {
        return cantorRepository.findAll();
    }

    public Optional<Cantor> encontrar(Long id) {
        return cantorRepository.findById(id);
    }

    public Cantor salvar(Cantor cantor) {
        try {
            return cantorRepository.save(cantor);
        } catch (Exception e) {
            return null;
        }
    }

    public void deletar(Long id) {
        cantorRepository.deleteById(id);
    }
}
