package com.example.BackEnd.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BackEnd.model.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, UUID> {

}
