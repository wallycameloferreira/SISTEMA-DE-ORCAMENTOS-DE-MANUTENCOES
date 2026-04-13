package com.itafrotas.orcamento.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orcamentos")
public class Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String empresa;

    @Column(nullable = false)
    private String endereco;

    @Column(name = "placa_carro", nullable = false)
    private String placaCarro;

    @Column(name = "modelo_carro", nullable = false)
    private String modeloCarro;

    @Column(nullable = false)
    private String cliente;

    @Column(name = "cliente_endereco", nullable = false)
    private String clienteEndereco;

    @Column(name = "cliente_telefone", nullable = false)
    private String clienteTelefone;

    @Column(name = "cliente_email")
    private String clienteEmail;

    @Column(nullable = false)
    private Integer validade;

    @Column(name = "porcentagem_sinistro", nullable = false)
    private String porcentagemSinistro;

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @Column(columnDefinition = "TEXT")
    private String fotos;

    @Column(name = "ultima_atualizacao")
    private LocalDateTime ultimaAtualizacao;

    @OneToMany(mappedBy = "orcamento", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<ItemOrcamento> itens = new ArrayList<>();

    // Construtor Padrão (Obrigatório para o JPA)
    public Orcamento() {
    }

    // Construtor com Argumentos
    public Orcamento(String empresa, String endereco, String placaCarro, String modeloCarro,
                     String cliente, String clienteEndereco, String clienteTelefone,
                     String clienteEmail, Integer validade, String porcentagemSinistro,
                     String observacoes, String fotos) {
        this.empresa = empresa;
        this.endereco = endereco;
        this.placaCarro = placaCarro;
        this.modeloCarro = modeloCarro;
        this.cliente = cliente;
        this.clienteEndereco = clienteEndereco;
        this.clienteTelefone = clienteTelefone;
        this.clienteEmail = clienteEmail;
        this.validade = validade;
        this.porcentagemSinistro = porcentagemSinistro;
        this.observacoes = observacoes;
        this.fotos = fotos;
        this.ultimaAtualizacao = LocalDateTime.now();
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
    public void setItens(List<ItemOrcamento> itens) {
        this.itens = itens;
        if (itens != null) {
            for (ItemOrcamento item : itens) {
                item.setOrcamento(this);
            }
        }
    }
}