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

@RestController
@RequestMapping("/api/diretor")
public class DiretorController {

    @Autowired
    private DiretorService service;

    @GetMapping
    public List<Diretor> listarDiretores() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Diretor listarDiretorId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listId(id);
    }

    @PostMapping("/{id}")
    public Diretor criarDiretor(@RequestBody Diretor body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @PutMapping("/{id}")
    public Diretor editarDiretor(@RequestBody Diretor body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @DeleteMapping("/{id}")
    public void deletarDiretor(@PathVariable UUID id) throws RelationNotFoundException {
        service.deleteId(id);
    }

}
