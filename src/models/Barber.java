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
    private int total_likes;
    
    public String getBarberName() {
        return barbeiro;
    }

    public void setBarbeiro(String barbeiro) {
        this.barbeiro = barbeiro;
    }
    
    public int getTotalLikes() {
        return total_likes;
    }

    public void setTotalLikes(int total_likes) {
        this.total_likes = total_likes;
    }    
}
