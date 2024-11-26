package com.example.BackEnd.service;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEnd.model.Cliente;
import com.example.BackEnd.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente saveAll(Cliente cliente) {
        repository.save(cliente);
        return cliente;
    }

    public List<Cliente> listAll() {
        return repository.findAll();
    }

    public Cliente listId(UUID id) throws RelationNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe cliente com ID: " + id));
    }

    public void deleteId(UUID id) throws RelationNotFoundException {
        Cliente delatada = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe cliente com ID: " + id));

        repository.delete(delatada);
    }

    public Cliente editId(Cliente cliente, UUID id) throws RelationNotFoundException {
        Cliente alterado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe cliente com ID: " + id));

        alterado.setNome(cliente.getNome());
        alterado.setDtNascimento(cliente.getDtNascimento());
        alterado.setSexo(cliente.getSexo());
        alterado.setAtivo(cliente.isAtivo());

        return repository.save(alterado);
    }

}