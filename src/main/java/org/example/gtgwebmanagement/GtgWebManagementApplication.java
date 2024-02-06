package org.example.gtgwebmanagement;

import org.example.gtgwebmanagement.models.dao.BowlDAOImpl;
import org.example.gtgwebmanagement.models.dao.IngredienteDAOImpl;
import org.example.gtgwebmanagement.models.dao.MenuDAOImpl;
import org.example.gtgwebmanagement.seeds.Seeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GtgWebManagementApplication {

    @Autowired
    MenuDAOImpl menuRepository;

    @Autowired
    BowlDAOImpl bowlRepository;

    @Autowired
    IngredienteDAOImpl ingredienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(GtgWebManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner () {
        Seeds seeds = new Seeds(ingredienteRepository, bowlRepository, menuRepository);
        return runner -> {
            seeds.generateSeeds();
        };
    }
}
