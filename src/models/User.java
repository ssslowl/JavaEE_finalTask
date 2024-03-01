package models;

public class User {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private Integer role;

    public User(Long id, String username, String password, String fullName, Integer role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }
    public User(String username, String password, String fullName, Integer role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.role = role;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
