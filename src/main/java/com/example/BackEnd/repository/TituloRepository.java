package com.example.BackEnd.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BackEnd.model.Titulo;

public interface TituloRepository extends JpaRepository<Titulo, UUID> {

}
