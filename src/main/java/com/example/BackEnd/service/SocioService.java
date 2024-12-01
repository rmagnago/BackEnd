package com.example.BackEnd.service;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEnd.model.Socio;
import com.example.BackEnd.repository.SocioRepository;

@Service
public class SocioService {
    @Autowired
    private SocioRepository repository;

    public Socio save(Socio socio) {
        repository.save(socio);
        return socio;
    }

    public List<Socio> listAll() {
        return repository.findAll();
    }

    public Socio listId(UUID id) throws RelationNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe socio com ID: " + id));
    }

    public void deleteId(UUID id) throws RelationNotFoundException {
        Socio deletado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe socio com ID: " + id));

        repository.delete(deletado);
    }

    public Socio editId(Socio socio, UUID id) throws RelationNotFoundException {
        Socio alterado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe socio com ID: " + id));

        alterado.setNome(socio.getNome());
        alterado.setDtNascimento(socio.getDtNascimento());
        alterado.setSexo(socio.getSexo());
        alterado.setAtivo(socio.getAtivo());
        alterado.setCpf(socio.getCpf());
        alterado.setTelefone(socio.getTelefone());
        alterado.setEndereco(socio.getEndereco());

        return repository.save(alterado);
    }
}