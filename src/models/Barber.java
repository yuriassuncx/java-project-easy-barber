/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Fábio
 */
public class Barber {
    private String barbeiro;
    private int likes;
    private int deslikes;
    private int total_avaliacao;
    
    public String getBarberName() {
        return barbeiro;
    }

    public void setBarbeiro(String barbeiro) {
        this.barbeiro = barbeiro;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    public int getDeslikes() {
        return deslikes;
    }
    
    public void setDeslikes(int deslikes) {
        this.deslikes = deslikes;
    }
    
    public int getTotalAvaliacao() {
        return total_avaliacao;
    }

    public void setTotalAvaliacao(int total_avaliacao) {
        this.total_avaliacao = total_avaliacao;
    }    
}
