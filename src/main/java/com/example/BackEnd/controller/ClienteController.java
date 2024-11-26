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

import com.example.BackEnd.model.Cliente;
import com.example.BackEnd.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @Operation(summary = "Listar todos os clientes", description = "Retorna uma lista com todos os clientes cadastrados.")
    @GetMapping
    public List<Cliente> listarClientes() {
        return service.listAll();
    }

    @Operation(summary = "Listar Cliente por ID", description = "Retorna um Cliente específico com base no seu ID.")
    @GetMapping("/{id}")
    public Cliente listarClienteId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @Operation(summary = "Criar novo Cliente", description = "Cadastra um novo Cliente no sistema.")
    @PostMapping("/novo")
    public Cliente criarCliente(@RequestBody Cliente body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @Operation(summary = "Editar Cliente existente", description = "Atualiza as informações de um Cliente existente com base no ID.")
    @PutMapping("/{id}")
    public Cliente editarCliente(@RequestBody Cliente body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @Operation(summary = "Deletar Cliente", description = "Remove um Cliente do sistema com base no seu ID.")
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable UUID id) throws RelationNotFoundException {
        service.deleteId(id);
    }

}
