package com.example.BackEnd.service;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEnd.model.Dependente;
import com.example.BackEnd.repository.DependenteRepository;

@Service
public class DependenteService {

    @Autowired
    private DependenteRepository repository;

    public Dependente saveAll(Dependente dependente) {
        repository.save(dependente);
        return dependente;
    }

    public List<Dependente> listAll() {
        return repository.findAll();
    }

    public Dependente listId(UUID id) throws RelationNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe dependente com ID: " + id));
    }

    public void deleteId(UUID id) throws RelationNotFoundException {
        Dependente delatada = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe dependente com ID: " + id));

        repository.delete(delatada);
    }

    public Dependente editId(Dependente dependente, UUID id) throws RelationNotFoundException {
        Dependente alterado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe dependente com ID: " + id));

        alterado.setNome(dependente.getNome());
        alterado.setDtNascimento(dependente.getDtNascimento());
        alterado.setSexo(dependente.getSexo());
        alterado.setAtivo(dependente.isAtivo());

        return repository.save(alterado);
    }

}