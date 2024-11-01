package com.example.BackEnd.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    private int numSerie;

    private Date dtAquisicao;

    private String tipoItem;

    @ManyToOne
    private Titulo titulo;
}
