package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.entity.Gravacao;
import com.utfpr.backendacervomusicalapi.repository.GravacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GravacaoService {

    @Autowired
    private GravacaoRepository gravacaoRepository;

    public List<Gravacao> listar() {
        return gravacaoRepository.findAll();
    }

    public Optional<Gravacao> encontrar(Long id) {
        return gravacaoRepository.findById(id);
    }

    public Gravacao salvar(Gravacao gravacao) {
        try {
            return gravacaoRepository.save(gravacao);
        } catch (Exception e) {
            return null;
        }
    }

    public void deletar(Long id) {
        gravacaoRepository.deleteById(id);
    }
}
