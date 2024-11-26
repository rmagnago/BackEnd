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

import com.example.BackEnd.model.Locacao;
import com.example.BackEnd.service.LocacaoService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService service;

    @Operation(summary = "Listar todos os locacoes", description = "Retorna uma lista com todos os locacoes cadastrados.")
    @GetMapping
    public List<Locacao> listarLocacoes() {
        return service.listAll();
    }

    @Operation(summary = "Listar Locacao por ID", description = "Retorna um Locacao específico com base no seu ID.")
    @GetMapping("/{id}")
    public Locacao listarLocacaoId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @Operation(summary = "Criar novo Locacao", description = "Cadastra um novo Locacao no sistema.")
    @PostMapping("/novo")
    public Locacao criarLocacao(@RequestBody Locacao body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @Operation(summary = "Editar Locacao existente", description = "Atualiza as informações de um Locacao existente com base no ID.")
    @PutMapping("/{id}")
    public Locacao editarLocacao(@RequestBody Locacao body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @Operation(summary = "Deletar Locacao", description = "Remove um Locacao do sistema com base no seu ID.")
    @DeleteMapping("/{id}")
    public void deletarLocacao(@PathVariable UUID id) throws RelationNotFoundException {
        service.deleteId(id);
    }

}
