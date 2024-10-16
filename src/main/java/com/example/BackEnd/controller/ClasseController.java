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

import com.example.BackEnd.model.Classe;
import com.example.BackEnd.service.ClasseService;

@RestController
@RequestMapping("/api/classe")
public class ClasseController {

    @Autowired
    private ClasseService service;

    @GetMapping
    public List<Classe> listarClasses() {
        return service.listAll();
    }

    @GetMapping("/listar/{id}")
    public Classe listarClasseId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @PostMapping("/novo")
    public Classe criarClasse(@RequestBody Classe body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @PutMapping("/editar/{id}")
    public Classe editarClasse(@RequestBody Classe body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarClasse(@PathVariable UUID id) throws RelationNotFoundException {
        service.deleteId(id);
    }

}
