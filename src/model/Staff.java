package model;

public class Staff extends User {
    private int employeeId;
    private String department;

    public Staff(int userId, String name, String email, String phoneNumber, String password, int employeeId, String department) {
        super(userId, name, email, phoneNumber, password);
        this.employeeId = employeeId;
        this.department = department;
    }

    @Override
    public String getRole() { return "Staff"; }

    public void assistCustomer() { /* placeholder */ }
    public void processReturn() { /* placeholder */ }
}
