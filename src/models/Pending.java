/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

public class Pending {
    private String userName;
    private int price;

    public Pending(String userName, int price) {
        this.userName = userName;
        this.price = price;
    }

    public String getUserName() {
        return userName;
    }

    public int getPrice() {
        return price;
    }
}
