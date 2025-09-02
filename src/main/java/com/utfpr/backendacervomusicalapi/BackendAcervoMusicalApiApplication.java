package com.utfpr.backendacervomusicalapi;

import com.utfpr.backendacervomusicalapi.entity.Categoria;
import com.utfpr.backendacervomusicalapi.entity.Musica;
import com.utfpr.backendacervomusicalapi.service.CategoriaService;
import com.utfpr.backendacervomusicalapi.service.MusicaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendAcervoMusicalApiApplication {

	private static final Logger log = LoggerFactory.getLogger(BackendAcervoMusicalApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendAcervoMusicalApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoriaService categoriaService, MusicaService musicaService) {

		return (arg) -> {

			log.info("");
			log.info("");
			log.info("============ Listagem de todas as MUSICAS");
			for(Musica m : musicaService.listarTodasMusicas())
				log.info(m.toString());

			log.info("");
			log.info("");
			log.info("============ Listagem de todas as CATEGORIAS");
			for(Categoria c : categoriaService.listarTodasCategorias())
				log.info(c.toString());

		};
	}
}
