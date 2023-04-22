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
    private String cliente;
    private int barber_id;
    private int user_id;
    private String servico;
    private String data_agend;
    private String hora_agend;
    private String observacao;
    private int preco;
    private int id;
    
    public int getBarberId() {
        return barber_id;
    }

    public void setBarberId(int barber_id) {
        this.barber_id = barber_id;
    } 

    public String getBarbeiro() {
        return barbeiro;
    }

    public void setBarbeiro(String barbeiro) {
        this.barbeiro = barbeiro;
    }
    
    public int getClienteId() {
        return user_id;
    }

    public void setClienteId(int user_id) {
        this.user_id = user_id;
    } 
    
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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
    
    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    } 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
