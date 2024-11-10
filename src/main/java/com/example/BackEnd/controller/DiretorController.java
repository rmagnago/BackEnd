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

import com.example.BackEnd.model.Diretor;
import com.example.BackEnd.service.DiretorService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/diretor")
public class DiretorController {

    @Autowired
    private DiretorService service;

    @Operation(summary = "Listar todos os diretores", description = "Retorna uma lista com todos os diretores cadastrados.")
    @GetMapping
    public List<Diretor> listarDiretores() {
        return service.listAll();
    }

    @Operation(summary = "Listar diretor por ID", description = "Retorna um diretor específico com base no seu ID.")
    @GetMapping("/{id}")
    public Diretor listarDiretorId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @Operation(summary = "Criar novo diretor", description = "Cadastra um novo diretor no sistema.")
    @PostMapping("/novo")
    public Diretor criarDiretor(@RequestBody Diretor body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @Operation(summary = "Editar diretor existente", description = "Atualiza as informações de um diretor existente com base no ID.")
    @PutMapping("/{id}")
    public Diretor editarDiretor(@RequestBody Diretor body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @Operation(summary = "Deletar diretor", description = "Remove um diretor do sistema com base no seu ID.")
    @DeleteMapping("/{id}")
    public void deletarDiretor(@PathVariable UUID id) throws RelationNotFoundException {
        service.deleteId(id);
    }

}
