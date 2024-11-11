package com.example.BackEnd.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.BackEnd.model.Item;

public interface ItemRepository extends JpaRepository<Item, UUID> {

}
