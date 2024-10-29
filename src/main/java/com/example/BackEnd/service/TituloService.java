package com.example.BackEnd.service;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BackEnd.model.Titulo;
import com.example.BackEnd.repository.TituloRepository;

public class TituloService {

    @Autowired
    private TituloRepository repository;

    public Titulo saveAll(Titulo titulo) {
        repository.save(titulo);
        return titulo;
    }

    public List<Titulo> listAll() {
        return repository.findAll();
    }

    public Titulo listById(UUID id) throws RelationNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe titulo com id: '" + id + "'"));
    }

    public void delete(UUID id) throws RelationNotFoundException {
        Titulo deeltado = listById(id);
        repository.delete(deeltado);
    }

    public Titulo editId(Titulo titulo, UUID id) throws RelationNotFoundException {
        Titulo alterado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe titulo com id: '" + id + "'"));

        alterado.setNome(titulo.getNome());
        alterado.setAno(titulo.getAno());
        alterado.setSinopse(titulo.getSinopse());
        alterado.setCategoria(titulo.getCategoria());

        return repository.save(alterado);
    }

}
