package models;


public class Service {
    private int id;
    private String servico;
    private int price;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getService() {
        return servico;
    }

    public void setService(String servico) {
        this.servico = servico;
    }
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
