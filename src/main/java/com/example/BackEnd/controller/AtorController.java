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

@RestController
@RequestMapping("/api/ator")
public class AtorController {

    @Autowired
    private AtorService service;

    @GetMapping
    public List<Ator> listarAtores() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Ator listarAtorId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @PostMapping("/novo")
    public Ator criarAtor(@RequestBody Ator body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @PutMapping("/{id}")
    public Ator editarAtor(@RequestBody Ator body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @DeleteMapping("/{id}")
    public void deletarAtor(@PathVariable UUID id) throws RelationNotFoundException {
        System.out.println(id);
        service.deleteId(id);
    }

}
