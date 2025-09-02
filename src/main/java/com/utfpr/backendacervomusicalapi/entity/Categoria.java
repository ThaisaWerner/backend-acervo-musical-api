package com.utfpr.backendacervomusicalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

//Cada entidade representa uma tabela no banco de dados
@Entity //Marca a classe como uma entidade gerenciada pelo framework ORM
@Table(name = "categoria") //Configurar nome e outras configurações da tabela
@Data
public class Categoria {

    @Id
    //Especifica como a chave primária deve ser gerada. Nesse caso será gerada pelo bd
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_categoria", nullable = false) //Indica qual coluna na tabela está sendo mapeada e adiciona informações complementares
    private Long id;

    @Column(name = "desc_categoria", length = 50)
    private String descCategoria;

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", descCategoria='" + descCategoria + '\'' +
                '}';
    }
}
