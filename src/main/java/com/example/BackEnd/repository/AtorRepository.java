package com.example.BackEnd.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BackEnd.model.Ator;

public interface AtorRepository extends JpaRepository<Ator, UUID> {

}
