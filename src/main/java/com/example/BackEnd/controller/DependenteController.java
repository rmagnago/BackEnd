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

import com.example.BackEnd.model.Dependente;
import com.example.BackEnd.service.DependenteService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/dependente")
public class DependenteController {

    @Autowired
    private DependenteService service;

    @Operation(summary = "Listar todos os Dependentes", description = "Retorna uma lista com todos os Dependentes cadastrados.")
    @GetMapping
    public List<Dependente> listarDependentes() {
        return service.listAll();
    }

    @Operation(summary = "Listar Dependente por ID", description = "Retorna um Dependente específico com base no seu ID.")
    @GetMapping("/{id}")
    public Dependente listarDependenteId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @Operation(summary = "Criar novo Dependente", description = "Cadastra um novo Dependente no sistema.")
    @PostMapping("/novo")
    public Dependente criarDependente(@RequestBody Dependente body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @Operation(summary = "Editar Dependente existente", description = "Atualiza as informações de um Dependente existente com base no ID.")
    @PutMapping("/{id}")
    public Dependente editarDependente(@RequestBody Dependente body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @Operation(summary = "Deletar Dependente", description = "Remove um Dependente do sistema com base no seu ID.")
    @DeleteMapping("/{id}")
    public void deletarDependente(@PathVariable UUID id) throws RelationNotFoundException {
        service.deleteId(id);
    }

}
