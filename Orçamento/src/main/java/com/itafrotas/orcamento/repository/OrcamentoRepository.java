package com.itafrotas.orcamento.repository;

import com.itafrotas.orcamento.model.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Long> {

    @Query(value = "SELECT * FROM orcamentos ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Optional<Orcamento> findUltimoOrcamento();
}