package com.example.BackEnd.service;

import java.util.List;
import java.util.UUID;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BackEnd.model.Locacao;
import com.example.BackEnd.repository.LocacaoRepository;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository repository;

    public Locacao saveAll(Locacao locacao) {
        repository.save(locacao);
        return locacao;
    }

    public List<Locacao> listAll() {
        return repository.findAll();
    }

    public Locacao listId(UUID id) throws RelationNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe locacao com ID: " + id));
    }

    public void deleteId(UUID id) throws RelationNotFoundException {
        Locacao delatada = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe locacao com ID: " + id));

        repository.delete(delatada);
    }

    public Locacao editId(Locacao locacao, UUID id) throws RelationNotFoundException {
        Locacao alterado = repository.findById(id)
                .orElseThrow(() -> new RelationNotFoundException("Não existe locacao com ID: " + id));

        alterado.setCliente(locacao.getCliente());
        alterado.setItem(locacao.getItem());
        alterado.setDtLocacao(locacao.getDtLocacao());
        alterado.setDtDevolucaoPrevista(locacao.getDtDevolucaoPrevista());
        alterado.setDtDevolucaoEfetiva(locacao.getDtDevolucaoEfetiva());
        alterado.setValor(locacao.getValor());
        alterado.setMulta(locacao.getMulta());

        return repository.save(alterado);
    }

}