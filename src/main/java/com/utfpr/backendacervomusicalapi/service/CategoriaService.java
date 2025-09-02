package com.utfpr.backendacervomusicalapi.service;

import com.utfpr.backendacervomusicalapi.entity.Categoria;
import com.utfpr.backendacervomusicalapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Essa classe vai fazer as chamadas aos métodos do repositório
@Service
public class CategoriaService {

    //Realiza o processo de injeção de dependência entre ContatoService e ContatoRepository
    @Autowired
    private CategoriaRepository categoriaRepository;

    //Usando Repository e JPARepository não é necessário abrir sessão, abrir transação, comitar ou fechar sessão e transação -> Ver curso udemy JPA o processo de abrir sessão, etc.
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> encontrar(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria salvar(Categoria categoria) {
        try {
            return categoriaRepository.save(categoria);
        } catch (Exception e) {
            return null;
        }
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
