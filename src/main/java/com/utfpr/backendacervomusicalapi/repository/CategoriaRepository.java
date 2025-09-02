package com.utfpr.backendacervomusicalapi.repository;

import com.utfpr.backendacervomusicalapi.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//indica que a interface é um componente gerenciado pelo Spring e está sendo usada como um repositório de acesso a dados.
// Essa anotação não é obrigatória em uma interface de repositório do Spring Data JPA, mas é uma boa prática utilizá-la
@Repository
//O primeiro generics é a classe de entidade e cria o vínculo com o repositório
//O segundo é o tipo de dado que representa o id da classe entidade
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
