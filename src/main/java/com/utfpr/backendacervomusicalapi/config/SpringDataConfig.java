package com.utfpr.backendacervomusicalapi.config;

import com.zaxxer.hikari.HikariDataSource;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//Marca a classe como sendo uma classe de configuração.
// Este tipo de classe será uma das primeiras a ser inicializada pelo Spring para liberar os recursos que estão configurados nela
@Configuration
//Diz ao spring que os recursos do spring data jpa serão usados
//Também informa qual pacote da aplicação estarão as interfaces que vão
//representar os repositórios do SpringData JPA, ou seja, a camada de persistência do projeto (salvar, recuperar, atualizar e deletar dados)
@EnableJpaRepositories("com.utfpr.backendacervomusicalapi.repository")
//Habilita no spring o controle transacional com o banco de dados, desse modo o spring é responsável em lidar com as transações
@EnableTransactionManagement
public class SpringDataConfig {

    //Método fazendo conexão com o banco de dados
    @Bean
    public DataSource dataSource() {

        //Gerencia conexões com o banco de dados reutilizando conexões em vez de abrir uma nova a cada requisição
        HikariDataSource ds = new HikariDataSource();

        ds.setUsername("root");
        ds.setPassword("@Thai95");
        ds.setJdbcUrl("jdbc:mariadb://localhost:3306/acervo_musical");
        ds.setDriverClassName("org.mariadb.jdbc.Driver");

        //Para conexão com o h2
//        ds.setJdbcUrl("jdbc:h2:mem:teste");
//        ds.setDriverClassName("org.h2.Driver");

        return ds;
    }

    //Responsável por criar instâncias de EntityManager(faz a ponte entre entidades e o bd) que são objetos usados para interagir com o banco de dados
    //O EntityManager gerencia as entidades
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        //Configura e cria um entityManagerFactory
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();

        //Diz para o JPA usar o Hibernete(mapeia classes Java em tabelas no banco) para fazer alterações no BD
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        //Permite que o hibernate gere automaticamente as tabelas com base nas entidades
        vendorAdapter.setGenerateDdl(true);
        //desativa a exibição dos comandos SQL no console (poderia ser true para debug).
        vendorAdapter.setShowSql(false);

        //Define a fonte de dados
        factory.setDataSource(dataSource());
        //Informa qual implementação do JPA está sendo utilizada e suas configurações (vendorAdapter)
        factory.setJpaVendorAdapter(vendorAdapter);
        //Diz ao spring onde procurar as entidades JPA - classes anotadas com @Entity
        factory.setPackagesToScan("com.utfpr.backendacervomusicalapi.entity");
        //Garante que todas as propriedades foram configuradas corretamente antes de usar a fábrica
        factory.afterPropertiesSet();

        //Retorna o objeto que será usado para criar o entity manager, o spring gerencia como um bean
        return factory.getObject();
    }

    //Coordenador de transações
    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory());
        manager.setJpaDialect(new HibernateJpaDialect());

        return manager;
    }
}
