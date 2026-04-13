package com.itafrotas.orcamento.repository;

import com.itafrotas.orcamento.model.ItemOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemOrcamento, Long> {
}