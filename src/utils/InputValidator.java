package utils;

public class InputValidator {
    public static boolean validateEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    public static boolean validateLicense(String license) {
        return license != null && license.length() >= 5;
    }
    public static boolean validatePassword(String pw) {
        return pw != null && pw.length() >= 6;
    }
}
