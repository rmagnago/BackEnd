package com.example.BackEnd.service;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEnd.model.Classe;
import com.example.BackEnd.repository.ClasseRepository;

@Service
public class ClasseService {

    @Autowired
    private ClasseRepository repository;

    public Classe saveAll(Classe classe) {
        repository.save(classe);
        return classe;
    }

    public List<Classe> listAll() {
        return repository.findAll();
    }

    public Classe listId(UUID id) throws RelationNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe classe com ID: " + id));
    }

    public void deleteId(UUID id) throws RelationNotFoundException {
        Classe delatada = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe classe com ID: " + id));

        repository.delete(delatada);
    }

    public Classe editId(Classe classe, UUID id) throws RelationNotFoundException {
        Classe alterado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe classe com ID: " + id));

        alterado.setNome(classe.getNome());
        alterado.setPrazoDevolucao(classe.getPrazoDevolucao());
        alterado.setValor(classe.getValor());

        return repository.save(alterado);
    }

}
