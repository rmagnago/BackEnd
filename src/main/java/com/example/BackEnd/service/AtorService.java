package com.example.BackEnd.service;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEnd.model.Ator;
import com.example.BackEnd.repository.AtorRepository;

@Service
public class AtorService {

    @Autowired
    private AtorRepository repository;

    public Ator saveAll(Ator ator) {
        repository.save(ator);
        return ator;
    }

    public List<Ator> listAll() {
        return repository.findAll();
    }

    public Ator listId(UUID id) throws RelationNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe ator com ID: " + id));
    }

    public void deleteId(UUID id) throws RelationNotFoundException {
        Ator delatada = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe ator com ID: " + id));

        repository.delete(delatada);
    }

    public Ator editId(Ator ator, UUID id) throws RelationNotFoundException {
        Ator alterado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe ator com ID: " + id));

        alterado.setNome(ator.getNome());

        return repository.save(alterado);
    }

}
