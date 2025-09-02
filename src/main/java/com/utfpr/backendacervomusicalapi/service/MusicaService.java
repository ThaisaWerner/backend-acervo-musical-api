package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.entity.Musica;
import com.utfpr.backendacervomusicalapi.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {

    @Autowired
    MusicaRepository musicaRepository;

    public List<Musica> listar() {
        return musicaRepository.findAll();
    }

    public Optional<Musica> encontrar(Long id) {
        return musicaRepository.findById(id);
    }

    public Musica salvar(Musica musica) {
        try {
            return musicaRepository.save(musica);
        } catch (Exception e) {
            return null;
        }
    }

    public void deletar(Long id) {
        musicaRepository.deleteById(id);
    }
}
