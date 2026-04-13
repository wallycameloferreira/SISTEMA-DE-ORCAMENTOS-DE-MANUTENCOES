package com.itafrotas.orcamento.service;

import com.itafrotas.orcamento.dto.OrcamentoRequestDTO;
import com.itafrotas.orcamento.dto.OrcamentoResponseDTO;
import com.itafrotas.orcamento.model.ItemOrcamento;
import com.itafrotas.orcamento.model.Orcamento;
import com.itafrotas.orcamento.repository.OrcamentoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrcamentoService {

    private final OrcamentoRepository orcamentoRepository;

    // Construtor para injeção de dependência (substitui o @Autowired no campo)
    public OrcamentoService(OrcamentoRepository orcamentoRepository) {
        this.orcamentoRepository = orcamentoRepository;
    }

    @Transactional
    public OrcamentoResponseDTO salvarOrcamento(OrcamentoRequestDTO request) {
        Orcamento orcamento;

        if (request.getId() != null && orcamentoRepository.existsById(request.getId())) {
            // Atualiza orçamento existente
            orcamento = orcamentoRepository.findById(request.getId())
                    .orElseThrow(() -> new RuntimeException("Orçamento não encontrado"));
            atualizarOrcamento(orcamento, request);
        } else {
            // Cria novo orçamento
            orcamento = criarNovoOrcamento(request);
        }

        orcamento.setUltimaAtualizacao(LocalDateTime.now());
        Orcamento saved = orcamentoRepository.save(orcamento);
        return new OrcamentoResponseDTO(saved);
    }

    private Orcamento criarNovoOrcamento(OrcamentoRequestDTO request) {
        Orcamento orcamento = new Orcamento();
        preencherDados(orcamento, request);
        return orcamento;
    }

    private void atualizarOrcamento(Orcamento orcamento, OrcamentoRequestDTO request) {
        preencherDados(orcamento, request);
    }

    // Método auxiliar para evitar duplicação de código (DRY)
    private void preencherDados(Orcamento orcamento, OrcamentoRequestDTO request) {
        orcamento.setEmpresa(request.getEmpresa());
        orcamento.setEndereco(request.getEndereco());
        orcamento.setPlacaCarro(request.getPlacaCarro());
        orcamento.setModeloCarro(request.getModeloCarro());
        orcamento.setCliente(request.getCliente());
        orcamento.setClienteEndereco(request.getClienteEndereco());
        orcamento.setClienteTelefone(request.getClienteTelefone());
        orcamento.setClienteEmail(request.getClienteEmail());
        orcamento.setValidade(request.getValidade());
        orcamento.setPorcentagemSinistro(request.getPorcentagemSinistro());
        orcamento.setObservacoes(request.getObservacoes());
        orcamento.setFotos(request.getFotos());

        // Configura itens e garante o vínculo bidirecional
        if (request.getItens() != null) {
            for (ItemOrcamento item : request.getItens()) {
                item.setOrcamento(orcamento);
            }
            orcamento.setItens(request.getItens());
        }
    }

    public Optional<OrcamentoResponseDTO> buscarOrcamentoPorId(Long id) {
        return orcamentoRepository.findById(id)
                .map(OrcamentoResponseDTO::new);
    }

    public Optional<OrcamentoResponseDTO> buscarUltimoOrcamento() {
        return orcamentoRepository.findUltimoOrcamento()
                .map(OrcamentoResponseDTO::new);
    }

    public List<OrcamentoResponseDTO> listarTodosOrcamentos() {
        return orcamentoRepository.findAll()
                .stream()
                .map(OrcamentoResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deletarOrcamento(Long id) {
        orcamentoRepository.deleteById(id);
    }
}