package com.example.BackEnd.service;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEnd.model.Diretor;
import com.example.BackEnd.repository.DiretorRepository;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository repository;

    public Diretor saveAll(Diretor diretor) {
        repository.save(diretor);
        return diretor;
    }

    public List<Diretor> listAll() {
        return repository.findAll();
    }

    public Diretor listId(UUID id) throws RelationNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe diretor com ID: " + id));
    }

    public void deleteId(UUID id) throws RelationNotFoundException {
        Diretor delatada = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe diretor com ID: " + id));

        repository.delete(delatada);
    }

    public Diretor editId(Diretor diretor, UUID id) throws RelationNotFoundException {
        Diretor alterado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe diretor com ID: " + id));

        alterado.setNome(diretor.getNome());

        return repository.save(alterado);
    }

}
