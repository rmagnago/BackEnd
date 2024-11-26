package com.example.BackEnd.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Date dtLocacao;
    private Date dtDevolucaoPrevista;
    private Date dtDevolucaoEfetiva;
    private double valor;
    private double multa;

    @ManyToOne
    private Item item;

    @ManyToOne
    private Cliente cliente;
}