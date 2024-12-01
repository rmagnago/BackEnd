package com.example.BackEnd.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "socio")
    private List<Dependente> dependentes;
}