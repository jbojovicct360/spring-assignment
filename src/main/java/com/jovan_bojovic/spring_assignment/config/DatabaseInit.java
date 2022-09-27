package com.jovan_bojovic.spring_assignment.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DatabaseInit {

    @Autowired
    JdbcTemplate template;

    @Bean
    CommandLineRunner createDatabase() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Bonjour monde!', 'FR')");
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Hallo Welt!', 'GE')");
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Ciao mondo!', 'IT')");
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Privet mir!', 'RU')");
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Hello world!', 'EN')");
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Hola mundo!', 'ES')");
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Hallo Wereld!', 'DU')");
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Hei maailma!', 'FI')");
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Ahoj svete!', 'CZ')");
                template.execute("INSERT INTO HELLO(CURRENT, LANG) VALUES ('Zdravo svete!', 'SR')");
            }
        };
    }

}
