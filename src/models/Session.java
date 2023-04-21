package models;

public class Session {
    private static Session instance;
    private int userId;
    private String userName;
    
    private Session() {}
    
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        
        return instance;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public void clear() {
        userId = 0;
    }
}
