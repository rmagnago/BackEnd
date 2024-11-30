package com.example.BackEnd.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private Date dtNascimento;

    private int numInscricao;

    private String sexo;

    private boolean ativo;
}