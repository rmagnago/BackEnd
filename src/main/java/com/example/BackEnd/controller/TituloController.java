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

import com.example.BackEnd.model.Titulo;
import com.example.BackEnd.service.TituloService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/titulo")
public class TituloController {

    @Autowired
    private TituloService service;

    @Operation(summary = "Listar todos os títulos", description = "Retorna uma lista com todos os títulos cadastrados.")
    @GetMapping
    public List<Titulo> listarTituloes() {
        return service.listAll();
    }

    @Operation(summary = "Listar título por ID", description = "Retorna um título específico com base no seu ID.")
    @GetMapping("/{id}")
    public Titulo listarTituloId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listById(id);
    }

    @Operation(summary = "Criar novo título", description = "Cadastra um novo título no sistema.")
    @PostMapping("/novo")
    public Titulo criarTitulo(@RequestBody Titulo body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @Operation(summary = "Editar título existente", description = "Atualiza as informações de um título existente com base no ID.")
    @PutMapping("/{id}")
    public Titulo editarTitulo(@RequestBody Titulo body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @Operation(summary = "Deletar título", description = "Remove um título do sistema com base no seu ID.")
    @DeleteMapping("/{id}")
    public void deletarTitulo(@PathVariable UUID id) throws RelationNotFoundException {
        service.delete(id);
    }

}
