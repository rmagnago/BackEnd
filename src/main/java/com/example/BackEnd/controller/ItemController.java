package com.example.BackEnd.controller;

import java.util.List;

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

import com.example.BackEnd.model.Item;
import com.example.BackEnd.service.ItemService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @Operation(summary = "Listar todos os itens", description = "Retorna uma lista com todos os itens cadastrados.")
    @GetMapping
    public List<Item> listarItemes() {
        return service.listAll();
    }

    @Operation(summary = "Listar item por ID", description = "Retorna um item específico com base no seu ID.")
    @GetMapping("/{id}")
    public Item listarItemId(@PathVariable int id) throws RelationNotFoundException {
        return service.listById(id);
    }

    @Operation(summary = "Criar novo item", description = "Cadastra um novo item no sistema.")
    @PostMapping("/novo")
    public Item criarItem(@RequestBody Item body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @Operation(summary = "Editar item existente", description = "Atualiza as informações de um item existente com base no ID.")
    @PutMapping("/{id}")
    public Item editarItem(@RequestBody Item body, @PathVariable int id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @Operation(summary = "Deletar item", description = "Remove um item do sistema com base no seu ID.")
    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable int id) throws RelationNotFoundException {
        service.delete(id);
    }

}
