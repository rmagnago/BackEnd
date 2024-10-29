package com.example.BackEnd.service;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.BackEnd.model.Item;
import com.example.BackEnd.repository.ItemRepository;

public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item saveAll(Item item) {
        repository.save(item);
        return item;
    }

    public List<Item> listAll() {
        return repository.findAll();
    }

    public Item listById(int id) throws RelationNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe item com número de série: '" + id + "'"));
    }

    public void delete(int id) throws RelationNotFoundException {
        Item delatada = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe item com número de série: '" + id + "'"));
        repository.delete(delatada);
    }

    public Item editId(Item item, int id) throws RelationNotFoundException {
        Item alterado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe item com número de série: '" + id + "'"));

        alterado.setNumSerie(item.getNumSerie());
        alterado.setDtAquisicao(item.getDtAquisicao());
        alterado.setTipoItem(item.getTipoItem());

        return repository.save(alterado);
    }
}
