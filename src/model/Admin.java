package model;

public class Admin extends User {
    private int adminId;
    private String roleLevel;

    public Admin(int userId, String name, String email, String phoneNumber, String password, int adminId, String roleLevel) {
        super(userId, name, email, phoneNumber, password);
        this.adminId = adminId;
        this.roleLevel = roleLevel;
    }

    public int getAdminId() { return adminId; }
    public String getRoleLevel() { return roleLevel; }

    @Override
    public String getRole() { return "Admin"; }

    public void displayAdminInfo() {
        System.out.println("Admin: " + name + " | Level: " + roleLevel);
    }
}
