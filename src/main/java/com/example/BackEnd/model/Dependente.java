package com.example.BackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Dependente extends Cliente {

    @ManyToOne
    private Socio socio;
}
