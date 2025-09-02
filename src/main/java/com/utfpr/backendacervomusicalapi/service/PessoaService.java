package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.entity.Pessoa;
import com.utfpr.backendacervomusicalapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public Optional<Pessoa> encontrar(Long id) {
        return pessoaRepository.findById(id);
    }

    public Pessoa salvar(Pessoa pessoa) {
        try {
            return pessoaRepository.save(pessoa);
        } catch (Exception e) {
            return null;
        }
    }

    public void deletar(Long id) {
        pessoaRepository.deleteById(id);
    }
}
