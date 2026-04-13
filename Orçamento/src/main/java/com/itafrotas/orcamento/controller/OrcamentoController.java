package com.itafrotas.orcamento.controller;

import com.itafrotas.orcamento.dto.OrcamentoRequestDTO;
import com.itafrotas.orcamento.dto.OrcamentoResponseDTO;
import com.itafrotas.orcamento.service.OrcamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orcamentos")
@CrossOrigin(origins = "*")
public class OrcamentoController {

    private final OrcamentoService orcamentoService;

    // Injeção via construtor (Boa prática recomendada pelo Spring)
    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @PostMapping
    public ResponseEntity<OrcamentoResponseDTO> salvarOrcamento(@RequestBody OrcamentoRequestDTO request) {
        OrcamentoResponseDTO response = orcamentoService.salvarOrcamento(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoResponseDTO> buscarOrcamentoPorId(@PathVariable Long id) {
        return orcamentoService.buscarOrcamentoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ultimo")
    public ResponseEntity<OrcamentoResponseDTO> buscarUltimoOrcamento() {
        return orcamentoService.buscarUltimoOrcamento()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<OrcamentoResponseDTO>> listarTodosOrcamentos() {
        List<OrcamentoResponseDTO> orcamentos = orcamentoService.listarTodosOrcamentos();
        return ResponseEntity.ok(orcamentos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarOrcamento(@PathVariable Long id) {
        orcamentoService.deletarOrcamento(id);
        return ResponseEntity.noContent().build();
    }
}