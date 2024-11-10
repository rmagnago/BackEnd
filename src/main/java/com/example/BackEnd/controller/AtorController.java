package com.example.BackEnd.controller;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BackEnd.model.Ator;
import com.example.BackEnd.service.AtorService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/ator")
public class AtorController {

    @Autowired
    private AtorService service;

    @Operation(summary = "Listar todos os atores", description = "Retorna uma lista com todos os atores cadastrados.")
    @GetMapping
    public List<Ator> listarAtores() {
        return service.listAll();
    }

    @Operation(summary = "Listar ator por ID", description = "Retorna um ator específico com base no seu ID.")
    @GetMapping("/{id}")
    public Ator listarAtorId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @Operation(summary = "Criar novo ator", description = "Cadastra um novo ator no sistema.")
    @PostMapping("/novo")
    public Ator criarAtor(@RequestBody Ator body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @Operation(summary = "Editar ator existente", description = "Atualiza as informações de um ator existente com base no ID.")
    @PutMapping("/{id}")
    public Ator editarAtor(@RequestBody Ator body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @Operation(summary = "Deletar ator", description = "Remove um ator do sistema com base no seu ID.")
    @DeleteMapping("/{id}")
    public void deletarAtor(@PathVariable UUID id) throws RelationNotFoundException {
        System.out.println(id);
        service.deleteId(id);
    }

}
