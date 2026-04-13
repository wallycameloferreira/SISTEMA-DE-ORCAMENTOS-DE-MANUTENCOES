package com.itafrotas.orcamento.dto;

import com.itafrotas.orcamento.model.ItemOrcamento;
import java.util.List;

public class OrcamentoRequestDTO {

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
    private List<ItemOrcamento> itens;

    // Construtores
    public OrcamentoRequestDTO() {}

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

    public List<ItemOrcamento> getItens() { return itens; }
    public void setItens(List<ItemOrcamento> itens) { this.itens = itens; }
}
