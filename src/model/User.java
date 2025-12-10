package model;

public abstract class User {
    protected int userId;
    protected String name;
    protected String email;
    protected String phoneNumber;
    protected String password;

    public User(int userId, String name, String email, String phoneNumber, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public int getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void logout() { /* placeholder for session logic */ }

    public void displayUserInfo() {
        System.out.println("User: " + name + " (" + email + ")");
    }

    public abstract String getRole();
}
