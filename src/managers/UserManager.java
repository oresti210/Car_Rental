package managers;

import model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserManager {
    private List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        if (findUserByEmail(user.getEmail()) == null) {
            users.add(user);
            System.out.println("[UserManager] Added user: " + user.getName());
        } else {
            System.out.println("[UserManager] User already exists with email: " + user.getEmail());
        }
    }

    public void removeUser(int userId) {
        users.removeIf(u -> u.getUserId() == userId);
    }

    public User findUserById(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) return u;
        }
        return null;
    }

    public User findUserByEmail(String email) {
        for (User u : users) {
            if (u.getEmail().equalsIgnoreCase(email)) return u;
        }
        return null;
    }

    public User authenticateUser(String email, String password) {
        for (User u : users) {
            if (u.login(email, password)) return u;
        }
        return null;
    }

    public List<User> getUsersByRole(String role) {
        return users.stream()
                .filter(u -> u.getRole().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }

    public void displayAllUsers() {
        if (users.isEmpty()) {
            System.out.println("[UserManager] No users available.");
            return;
        }
        for (User u : users) {
            System.out.println(u.getRole() + " -> " + u.getName() + " (" + u.getEmail() + ")");
        }
    }

    public List<User> getAllUsers() {
        return users;
    }

    public int getTotalUsers() {
        return users.size();
    }
}
