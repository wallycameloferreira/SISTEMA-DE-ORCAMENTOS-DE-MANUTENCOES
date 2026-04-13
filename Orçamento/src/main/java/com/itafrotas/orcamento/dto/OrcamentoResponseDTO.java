package com.itafrotas.orcamento.dto;

import com.itafrotas.orcamento.model.ItemOrcamento;
import com.itafrotas.orcamento.model.Orcamento;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrcamentoResponseDTO {

    private Long id;
    private String empresa;
    private String endereco;
    private String placaCarro;
    private String modeloCarro;
    private String cliente;
    private String clienteEndereco;
    private String clienteTelefone;
    private String clienteEmail;
    private Integer validade;
    private String porcentagemSinistro;
    private String observacoes;
    private String fotos;
    private LocalDateTime ultimaAtualizacao;
    private List<ItemOrcamento> itens;
    private BigDecimal subtotal;
    private BigDecimal acrescimoSinistro;
    private BigDecimal totalGeral;

    public OrcamentoResponseDTO(Orcamento orcamento) {
        this.id = orcamento.getId();
        this.empresa = orcamento.getEmpresa();
        this.endereco = orcamento.getEndereco();
        this.placaCarro = orcamento.getPlacaCarro();
        this.modeloCarro = orcamento.getModeloCarro();
        this.cliente = orcamento.getCliente();
        this.clienteEndereco = orcamento.getClienteEndereco();
        this.clienteTelefone = orcamento.getClienteTelefone();
        this.clienteEmail = orcamento.getClienteEmail();
        this.validade = orcamento.getValidade();
        this.porcentagemSinistro = orcamento.getPorcentagemSinistro();
        this.observacoes = orcamento.getObservacoes();
        this.fotos = orcamento.getFotos();
        this.ultimaAtualizacao = orcamento.getUltimaAtualizacao();
        this.itens = orcamento.getItens();

        // Cálculos
        this.subtotal = itens.stream()
                .map(item -> item.getValorUnitario().multiply(BigDecimal.valueOf(item.getQuantidade())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        double percentual = Double.parseDouble(porcentagemSinistro) / 100;
        this.acrescimoSinistro = subtotal.multiply(BigDecimal.valueOf(percentual));
        this.totalGeral = subtotal.add(acrescimoSinistro);
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getPlacaCarro() { return placaCarro; }
    public void setPlacaCarro(String placaCarro) { this.placaCarro = placaCarro; }

    public String getModeloCarro() { return modeloCarro; }
    public void setModeloCarro(String modeloCarro) { this.modeloCarro = modeloCarro; }

    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getClienteEndereco() { return clienteEndereco; }
    public void setClienteEndereco(String clienteEndereco) { this.clienteEndereco = clienteEndereco; }

    public String getClienteTelefone() { return clienteTelefone; }
    public void setClienteTelefone(String clienteTelefone) { this.clienteTelefone = clienteTelefone; }

    public String getClienteEmail() { return clienteEmail; }
    public void setClienteEmail(String clienteEmail) { this.clienteEmail = clienteEmail; }

    public Integer getValidade() { return validade; }
    public void setValidade(Integer validade) { this.validade = validade; }

    public String getPorcentagemSinistro() { return porcentagemSinistro; }
    public void setPorcentagemSinistro(String porcentagemSinistro) { this.porcentagemSinistro = porcentagemSinistro; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public String getFotos() { return fotos; }
    public void setFotos(String fotos) { this.fotos = fotos; }

    public LocalDateTime getUltimaAtualizacao() { return ultimaAtualizacao; }
    public void setUltimaAtualizacao(LocalDateTime ultimaAtualizacao) { this.ultimaAtualizacao = ultimaAtualizacao; }

    public List<ItemOrcamento> getItens() { return itens; }
    public void setItens(List<ItemOrcamento> itens) { this.itens = itens; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    public BigDecimal getAcrescimoSinistro() { return acrescimoSinistro; }
    public void setAcrescimoSinistro(BigDecimal acrescimoSinistro) { this.acrescimoSinistro = acrescimoSinistro; }

    public BigDecimal getTotalGeral() { return totalGeral; }
    public void setTotalGeral(BigDecimal totalGeral) { this.totalGeral = totalGeral; }
}
