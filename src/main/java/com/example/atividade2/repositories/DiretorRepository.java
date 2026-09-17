package com.example.atividade2.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.atividade2.models.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long> {

    List<Diretor> findByNomeStartingWith(String nome);
}
