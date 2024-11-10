package com.example.BackEnd.model;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Titulo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nome;

    private int ano;

    private String sinopse;

    private String categoria;

    @ManyToMany
    @JoinTable(
        name = "titulo_ator",
        joinColumns = @JoinColumn(name = "titulo_id"),
        inverseJoinColumns = @JoinColumn(name = "ator_id")
    )
    private List<Ator> ator;

    @ManyToOne
    private Classe classe;

    @ManyToOne
    private Diretor diretor;
}
