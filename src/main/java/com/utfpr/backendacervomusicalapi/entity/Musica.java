package com.utfpr.backendacervomusicalapi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "musica")
@Data
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_musica", nullable = false)
    private Long id;

    @ManyToOne //Mapeia o relacionamento entre as entidades
    @JoinColumn(name = "cod_categoria", nullable = false) //indica qual o nome da chave estrangeira no relacionamento
    private Categoria categoria;

    private Integer duracao;

    @Column(length = 100)
    private String titulo;

    @Override
    public String toString() {
        return "Musica{" +
                "id=" + id +
                ", categoria=" + categoria +
                ", duracao=" + duracao +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
