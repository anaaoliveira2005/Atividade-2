package com.example.atividade2;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.atividade2.models.Diretor;
import com.example.atividade2.models.Filme;
import com.example.atividade2.repositories.DiretorRepository;
import com.example.atividade2.repositories.FilmeRepository;

@SpringBootApplication
public class Atividade2Application {
	@Bean
    public CommandLineRunner init(
            @Autowired FilmeRepository filmeRepository,
            @Autowired DiretorRepository diretorRepository) {

        return args -> {
            Diretor diretor1 = new Diretor(null, "Steven Spielberg", null);
            Diretor diretor2 = new Diretor(null, "Christopher Nolan", null);

            diretorRepository.save(diretor1);
            diretorRepository.save(diretor2);

            Filme filme1 = new Filme(null, "Jurassic Park", 150, diretor1);
            Filme filme2 = new Filme(null, "ET O Extraterrestre", 120, diretor1);
            Filme filme3 = new Filme(null, "Interestelar", 150, diretor2);
            Filme filme4 = new Filme(null, "Batman: O Cavaleiro das Trevas", 120, diretor2);

            filmeRepository.save(filme1);
            filmeRepository.save(filme2);
            filmeRepository.save(filme3);
            filmeRepository.save(filme4);

            System.out.println("\n--- FILMES COM DURAÇÃO MAIOR QUE 120 MINUTOS ---");
            List<Filme> filmesMaior120 = filmeRepository.findByDuracaoGreaterThan(120);
            filmesMaior120.forEach(System.out::println);

            System.out.println("\n--- FILMES COM DURAÇÃO MENOR OU IGUAL A 120 MINUTOS ---");
            List<Filme> filmesMenorIgual120 = filmeRepository.findByDuracaoLessThanEqual(120);
            filmesMenorIgual120.forEach(System.out::println);

            System.out.println("\n--- FILMES CUJO TÍTULO COMEÇA COM 'E' ---");
            List<Filme> filmesTituloE = filmeRepository.findByTituloStartingWith("E");
            filmesTituloE.forEach(System.out::println);

            System.out.println("\n--- DIRETORES CUJO NOME COMEÇA COM 'Steven' ---");
            List<Diretor> diretoresSteven = diretorRepository.findByNomeStartingWith("Steven");
            diretoresSteven.forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Atividade2Application.class, args);
    }
}
