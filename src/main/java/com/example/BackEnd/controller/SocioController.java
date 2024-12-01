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

import com.example.BackEnd.model.Socio;
import com.example.BackEnd.service.SocioService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/socio")
public class SocioController {
    @Autowired
    private SocioService service;

    @Operation(summary = "Listar todos os socios", description = "Retorna uma lista com todos os socios cadastrados.")
    @GetMapping
    public List<Socio> listarSocios() {
        return service.listAll();
    }

    @Operation(summary = "Listar Socio por ID", description = "Retorna um Socio específico com base no seu ID.")
    @GetMapping("/{id}")
    public Socio listarSocioId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @Operation(summary = "Criar novo Socio", description = "Cadastra um novo Socio no sistema.")
    @PostMapping("/novo")
    public Socio criarSocio(@RequestBody Socio body) throws RelationNotFoundException {
        return service.save(body);
    }

    @Operation(summary = "Editar Socio existente", description = "Atualiza as informações de um Socio existente com base no ID.")
    @PutMapping("/{id}")
    public Socio editarSocio(@RequestBody Socio body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @Operation(summary = "Deletar Socio", description = "Remove um Socio do sistema com base no seu ID.")
    @DeleteMapping("/{id}")
    public void deletarSocio(@PathVariable UUID id) throws RelationNotFoundException {
        service.deleteId(id);
    }
}