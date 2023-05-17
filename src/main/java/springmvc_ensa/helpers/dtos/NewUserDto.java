package springmvc_ensa.helpers.dtos;

import springmvc_ensa.helpers.Role;

public class NewUserDto {
    private String username;
    private String email;
    private Role role;
    private String description;

    public NewUserDto(String username, String email, Role role, String description) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.description = description;
    }

    public NewUserDto() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
