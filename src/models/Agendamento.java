/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Fábio
 */
public class Agendamento {
    private String barbeiro;
    private String servico;
    private String data_agend;
    private String hora_agend;
    private String observacao;
    private int id;

    public String getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(String barbeiro) {
        this.barbeiro = barbeiro;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getData_agend() {
        return data_agend;
    }

    public void setData_agend(String data_agend) {
        this.data_agend = data_agend;
    }

    public String getHora_agend() {
        return hora_agend;
    }

    public void setHora_agend(String hora_agend) {
        this.hora_agend = hora_agend;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
