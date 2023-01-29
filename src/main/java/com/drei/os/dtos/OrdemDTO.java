package com.drei.os.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.drei.os.domain.Ordem;
import com.fasterxml.jackson.annotation.JsonFormat;

public class OrdemDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataAbertura;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataFechamento;
    
    private Integer prioridade;
    private String observacoes;
    private Integer status;
    private Integer idTecnico;
    private Integer idCliente;

    public OrdemDTO(Ordem inOrdem) {
        this.id = inOrdem.getId();
        this.dataAbertura = inOrdem.getDataAbertura();
        this.dataFechamento = inOrdem.getDataFechamento();
        this.prioridade = inOrdem.getPrioridade().getCodigo();
        this.observacoes = inOrdem.getObservacoes();
        this.status = inOrdem.getStatus().getCodigo();
        this.idTecnico = inOrdem.getTecnico().getId();
        this.idCliente = inOrdem.getCliente().getId();
    }

    public OrdemDTO() {
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}
