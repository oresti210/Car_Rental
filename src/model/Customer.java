package model;

public class Customer {
    private String id;
    private String name;
    private String email;

    //Constructor
    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    //Get Method
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
