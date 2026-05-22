package vn.htv.ams_backend.dto;

public class LoginRequest {
    private String username;
    private String password;

    // Em tự Generate Getter/Setter cho 2 biến này nhé

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}