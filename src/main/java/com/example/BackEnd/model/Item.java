package com.example.BackEnd.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Item {

    @Id
    private int numSerie;

    private Date dtAquisicao;

    private String tipoItem;
}
