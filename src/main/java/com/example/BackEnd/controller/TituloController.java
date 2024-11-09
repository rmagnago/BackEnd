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

@RestController
@RequestMapping("/api/titulo")
public class TituloController {

    @Autowired
    private TituloService service;

    @GetMapping
    public List<Titulo> listarTituloes() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Titulo listarTituloId(@PathVariable UUID id) throws RelationNotFoundException {
        return service.listById(id);
    }

    @PostMapping("/novo")
    public Titulo criarTitulo(@RequestBody Titulo body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @PutMapping("/{id}")
    public Titulo editarTitulo(@RequestBody Titulo body, @PathVariable UUID id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @DeleteMapping("/{id}")
    public void deletarTitulo(@PathVariable UUID id) throws RelationNotFoundException {
        service.delete(id);
    }

}
