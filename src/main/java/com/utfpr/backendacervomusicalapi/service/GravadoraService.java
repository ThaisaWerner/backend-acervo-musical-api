package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.entity.Gravadora;
import com.utfpr.backendacervomusicalapi.repository.GravadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GravadoraService {

    @Autowired
    private GravadoraRepository gravadoraRepository;

    public List<Gravadora> listar(){
        return gravadoraRepository.findAll();
    }

    public Optional<Gravadora> encontrar(Long id) {
        return gravadoraRepository.findById(id);
    }

    public Gravadora salvar(Gravadora gravadora) {
        try {
            return gravadoraRepository.save(gravadora);
        } catch (Exception e) {
            return null;
        }
    }

    public void deletar(Long id) {
        gravadoraRepository.deleteById(id);
    }
}
