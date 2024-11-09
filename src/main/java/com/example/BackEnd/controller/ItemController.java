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

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping
    public List<Item> listarItemes() {
        return service.listAll();
    }

    @GetMapping("/{id}")
    public Item listarItemId(@PathVariable int id) throws RelationNotFoundException {
        return service.listById(id);
    }

    @PostMapping("/novo")
    public Item criarItem(@RequestBody Item body) throws RelationNotFoundException {
        return service.saveAll(body);
    }

    @PutMapping("/{id}")
    public Item editarItem(@RequestBody Item body, @PathVariable int id) throws RelationNotFoundException {
        return service.editId(body, id);
    }

    @DeleteMapping("/{id}")
    public void deletarItem(@PathVariable int id) throws RelationNotFoundException {
        service.delete(id);
    }

}
