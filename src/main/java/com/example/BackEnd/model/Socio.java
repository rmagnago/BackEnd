package com.example.BackEnd.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio extends Cliente {
    private String cpf;
    private String endereco;
    private String telefone;

}